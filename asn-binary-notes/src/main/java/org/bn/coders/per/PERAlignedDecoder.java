/*
 Copyright 2006-2011 Abdulla Abdurakhmanov (abdulla@latestbit.com)
 Original sources are available at www.latestbit.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.bn.coders.per;

import org.bn.annotations.ASN1EnumItem;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.bn.coders.CoderUtils;
import org.bn.coders.DecodedObject;
import org.bn.coders.Decoder;
import org.bn.coders.ElementInfo;
import org.bn.metadata.ASN1SequenceOfMetadata;
import org.bn.metadata.constraints.ASN1SizeConstraintMetadata;
import org.bn.metadata.constraints.ASN1ValueRangeConstraintMetadata;
import org.bn.metadata.constraints.IASN1ConstraintMetadata;
import org.bn.types.BitString;
import org.bn.types.ObjectIdentifier;
import org.bn.utils.BitArrayInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedList;
import java.util.SortedMap;

/**
 * @author zhangyong
 */
public class PERAlignedDecoder extends Decoder {

    @Override
    public <T> T decode(InputStream stream, Class<T> objectClass) throws Exception {
        return super.decode(new BitArrayInputStream(stream), objectClass);
    }

    @Override
    public DecodedObject decodeTag(InputStream stream) throws Exception {
        return null;
    }

    protected void skipAlignedBits(InputStream stream) {
        ((BitArrayInputStream) stream).skipUnreadedBits();
    }

    protected long decodeIntegerValueAsBytes(int intLen, InputStream stream) throws Exception {
        /*long result = 0;
        for (int i = intLen-1 ; i >= 0; i--) {
            result|= (stream.read()) << 8*i;
        }        
        return result;*/
        long value = 0;
        for (int i = 0; i < intLen; i++) {
            int bt = stream.read();
            if (bt == -1) {
                throw new IllegalArgumentException("Unexpected EOF when decoding!");
            }

            if (i == 0 && (bt & (byte) 0x80) != 0) {
                bt = bt - 256;
            }

            value = (value << 8) | bt;
        }
        return value;
    }

    /**
     * Decode the constraint length determinant.
     * ITU-T X.691. 10.9. General rules for encoding a length determinant
     */
    protected int decodeConstraintLengthDeterminant(int min, int max, BitArrayInputStream stream) throws Exception {
        if (max <= 0xFFFF) {
            // 10.9. NOTE 2  (Tutorial) In the case of the ALIGNED variant
            // if the length count is bounded above by an upper bound that is 
            // less than 64K, then the constrained whole number encoding 
            // is used for the length.
            return (int) decodeConstraintNumber(min, max, stream); // encoding as constraint integer
        } else {
            return decodeLengthDeterminant(stream);
        }
    }

    /**
     * Decode the length determinant
     * ITU-T X.691. 10.9. General rules for encoding a length determinant
     */
    protected int decodeLengthDeterminant(BitArrayInputStream stream) throws IOException {
        skipAlignedBits(stream);
        int result = stream.read();
        if ((result & 0x80) == 0) {
            // NOTE 2. a) ("n" less than 128)             
            // a single octet containing "n" with bit 8 set to zero;
            return result;
        } else {
            // NOTE 2. b) ("n" less than 16K) two octets 
            // containing "n" with bit 8 of the first octet 
            // set to 1 and bit 7 set to zero;        
            result = (result & 0x3f) << 8;
            result |= stream.read();
        }
        // WARNING! Large N doesn't supported NOW!
        // NOTE 2. b) (large "n") a single octet containing a count "m" 
        // with bit 8 set to 1 and bit 7 set to 1. 
        // The count "m" is one to four, and the length indicates that 
        // a fragment of the material follows (a multiple "m" of 16K items). 
        // For all values of "m", the fragment is then followed 
        // by another length encoding for the remainder of the material.        
        return result;
    }

    /**
     * Decode of the constrained whole number
     * ITU-T X.691. 10.5.
     * NOTE  (Tutorial) This subclause is referenced by other clauses,
     * and itself references earlier clauses for the production of
     * a nonnegative-binary-integer or a 2's-complement-binary-integer encoding.
     */
    protected long decodeConstraintNumber(long min, long max, BitArrayInputStream stream) throws Exception {
        long result = 0;
        long valueRange = max - min;
        //!!!! int narrowedVal = value - min; !!!
        int maxBitLen = PERCoderUtils.getMaxBitLength(valueRange);

        if (valueRange == 0) {
            return max;
        }

        // The rest of this Note addresses the ALIGNED variant. 
        if (valueRange > 0 && valueRange < 256) {
            /*
             * 1. Where the range is less than or equal to 255, the value encodes
             * into a bit-field of the minimum size for the range.
             * 2. Where the range is exactly 256, the value encodes
             * into a single octet octet-aligned bit-field.
             */
            skipAlignedBits(stream);
            result = stream.readBits(maxBitLen);
            result += min;
        } else if (valueRange > 0 && valueRange < 65536) {
            /*
             * 3. Where the range is 257 to 64K, the value encodes into
             * a two octet octet-aligned bit-field.
             */
            skipAlignedBits(stream);
            result = stream.read() << 8;
            result |= stream.read();
            result += min;
        } else {
            /*
             * 4. Where the range is greater than 64K, the range is ignored
             * and the value encodes into an  octet-aligned bit-field
             * which is the minimum number of octets for the value.
             * In this latter case, later procedures (see 10.9)
             * also encode a length field (usually a single octet) to indicate
             * the length of the encoding. For the other cases, the length
             * of the encoding is independent of the value being encoded,
             * and is not explicitly encoded.
             */
            int intLen = decodeConstraintLengthDeterminant(
                    1, CoderUtils.getPositiveIntegerLength(valueRange),
                    stream
            );
            skipAlignedBits(stream);
            result = (int) decodeIntegerValueAsBytes(intLen, stream);
            result += min;
        }

        return result;
    }

    /**
     * Decode the semi-constrained whole number
     * ITU-T X.691. 10.7.
     * NOTE  (Tutorial) This procedure is used when a lower bound can be
     * identified but not an upper bound. The encoding procedure places
     * the offset from the lower bound into the minimum number of octets
     * as a non-negative-binary-integer, and requires an explicit length
     * encoding (typically a single octet) as specified in later procedures.
     */
    protected int decodeSemiConstraintNumber(int min, BitArrayInputStream stream) throws Exception {
        int result = 0;
        int intLen = decodeLengthDeterminant(stream);
        skipAlignedBits(stream);
        result = (int) decodeIntegerValueAsBytes(intLen, stream);
        result += min;
        return result;
    }

    /**
     * Decode the normally small number
     * ITU-T X.691. 10.6
     * NOTE  (Tutorial) This procedure is used when encoding
     * a non-negative whole number that is expected to be small, but whose size
     * is potentially unlimited due to the presence of an extension marker.
     * An example is a choice index.
     */
    protected int decodeNormallySmallNumber(BitArrayInputStream stream) throws Exception {
        int result = 0;
        int bitIndicator = stream.readBit();
        if (bitIndicator == 0) {
            /* 10.6.1 If the non-negative whole number, "n", is less than
             * or equal to 63, then a single-bit bit-field shall be appended
             * to the field-list with the bit set to 0, and "n" shall be
             * encoded as a non-negative-binary-integer into a 6-bit bit-field.
             */
            result = stream.readBits(6);
        } else {
            /* If "n" is greater than or equal to 64, a single-bit
             * bit-field with the bit set to 1 shall be appended to the field-list.
             * The value "n" shall then be encoded as a semi-constrained
             * whole number with "lb" equal to 0 and the procedures of
             * 10.9 shall be invoked to add it to the field-list preceded
             * by a length determinant.
             */
            result = decodeSemiConstraintNumber(0, stream);
        }
        return result;
    }

    /**
     * Decode the unconstrained whole number
     * ITU-T X.691. 10.8.
     * NOTE  (Tutorial) This case only arises in the encoding of the
     * value of an integer type with no lower bound. The procedure
     * encodes the value as a 2's-complement-binary-integer into
     * the minimum number of octets required to accommodate the encoding,
     * and requires an explicit length encoding (typically a single octet)
     * as specified in later procedures.
     */
    protected int decodeUnconstraintNumber(BitArrayInputStream stream) throws Exception {
        int result = 0;
        int numLen = decodeLengthDeterminant(stream);
        skipAlignedBits(stream);
        result += (int) decodeIntegerValueAsBytes(numLen, stream);
        return result;
    }

    protected int decodeLength(ElementInfo elementInfo, InputStream stream) throws Exception {
        int result = 0;
        BitArrayInputStream bitStream = (BitArrayInputStream) stream;
        if (elementInfo.hasPreparedInfo()) {
            if (elementInfo.getPreparedInfo().hasConstraint()) {
                IASN1ConstraintMetadata constraint = elementInfo.getPreparedInfo().getConstraint();
                if (constraint instanceof ASN1ValueRangeConstraintMetadata) {
                    result = decodeConstraintLengthDeterminant(
                            (int) ((ASN1ValueRangeConstraintMetadata) constraint).getMin(),
                            (int) ((ASN1ValueRangeConstraintMetadata) constraint).getMax(),
                            bitStream
                    );
                } else if (constraint instanceof ASN1SizeConstraintMetadata) {
                    result = (int) ((ASN1SizeConstraintMetadata) constraint).getMax();
                }
            } else {
                result = decodeLengthDeterminant(bitStream);
            }
        } else if (elementInfo.getAnnotatedClass().isAnnotationPresent(ASN1ValueRangeConstraint.class)) {
            ASN1ValueRangeConstraint constraint = elementInfo.getAnnotatedClass().getAnnotation(ASN1ValueRangeConstraint.class);
            result = decodeConstraintLengthDeterminant((int) constraint.min(), (int) constraint.max(), bitStream);
        } else if (elementInfo.getAnnotatedClass().isAnnotationPresent(ASN1SizeConstraint.class)) {
            // For strictly definited size doesn't encode any len
            ASN1SizeConstraint constraint = elementInfo.getAnnotatedClass().getAnnotation(ASN1SizeConstraint.class);
            result = (int) constraint.max();
        } else {
            result = decodeLengthDeterminant(bitStream);
        }
        CoderUtils.checkConstraints(result, elementInfo);
        return result;
    }

    @Override
    public DecodedObject decodeChoice(DecodedObject decodedTag,
                                      Class objectClass,
                                      ElementInfo elementInfo,
                                      InputStream stream) throws Exception {
        Object choice = createInstanceForElement(objectClass, elementInfo);
        skipAlignedBits(stream);
        Field[] fields = null;
        if (elementInfo.hasPreparedInfo()) {
            fields = elementInfo.getPreparedInfo().getFields();
        } else {
            fields = PERCoderUtils.getRealFields(objectClass).toArray(new Field[0]);
        }
        int elementIndex = (int) decodeConstraintNumber(1, fields.length, (BitArrayInputStream) stream);
        DecodedObject value = null;
        for (int i = 0; i < elementIndex && i < fields.length; i++) {
            if (i + 1 == elementIndex) {
                Field field = fields[i];
                ElementInfo info = new ElementInfo();
                info.setAnnotatedClass(field);
                if (elementInfo.hasPreparedInfo()) {
                    info.setPreparedInfo(elementInfo.getPreparedInfo().getFieldMetadata(i));
                } else {
                    info.setASN1ElementInfoForClass(field);
                }
                info.setGenericInfo(field.getGenericType());
                value = decodeClassType(decodedTag, field.getType(), info, stream);
                invokeSelectMethodForField(field, choice, value.getValue(), info);
                break;
            }
            ;
        }
        if (value == null && !CoderUtils.isOptional(elementInfo)) {
            throw new IllegalArgumentException("The choice '" + objectClass.toString() + "' does not have a selected item!");
        } else {
            return new DecodedObject(choice);
        }
    }


    protected int getSequencePreambleBitLen(Class objectClass, ElementInfo elementInfo) throws Exception {
        int preambleLen = 0;
        ElementInfo info = new ElementInfo();
        int fieldIdx = 0;
        for (Field field : elementInfo.getFields(objectClass)) {
            if (!field.isSynthetic()) {
                if (elementInfo.hasPreparedInfo()) {
                    info.setPreparedInfo(elementInfo.getPreparedInfo().getFieldMetadata(fieldIdx));
                }
                if (CoderUtils.isOptionalField(field, info)) {
                    preambleLen++;
                }
                fieldIdx++;
            }
        }
        return preambleLen;
    }

    @Override
    public DecodedObject decodeSequence(DecodedObject decodedTag, Class objectClass,
                                        ElementInfo elementInfo, InputStream stream) throws Exception {
        // TO DO 
        // Decode sequence preamble               
        BitArrayInputStream bitStream = (BitArrayInputStream) stream;
        int preambleLen = getSequencePreambleBitLen(objectClass, elementInfo);
        int preamble = bitStream.readBits(preambleLen);
        int preambleCurrentBit = 32 - preambleLen;
        skipAlignedBits(stream);
        Object sequence = createInstanceForElement(objectClass, elementInfo);
        initDefaultValues(sequence, elementInfo);
        Field[] fields = null;
        if (!CoderUtils.isSequenceSet(elementInfo) || elementInfo.hasPreparedInfo()) {
            fields = elementInfo.getFields(objectClass);
        } else {
            SortedMap<Integer, Field> fieldOrder = CoderUtils.getSetOrder(objectClass);
            fields = new Field[0];
            fields = fieldOrder.values().toArray(fields);
        }
        int idx = 0;
        ElementInfo info = new ElementInfo();
        for (Field field : fields) {
            if (!field.isSynthetic()) {
                if (elementInfo.hasPreparedInfo()) {
                    info.setPreparedInfo(elementInfo.getPreparedInfo().getFieldMetadata(idx));
                }
                if (CoderUtils.isOptionalField(field, info)) {
                    if ((preamble & (0x80000000 >>> preambleCurrentBit)) != 0) {
                        decodeSequenceField(null, sequence, idx, field, stream, elementInfo, true);
                    }
                    preambleCurrentBit++;
                } else {
                    decodeSequenceField(null, sequence, idx, field, stream, elementInfo, true);
                }
                idx++;
            }
        }
        return new DecodedObject(sequence);
/*         }
         else {
             return decodeSet(decodedTag, objectClass, elementInfo, stream);
         }*/
    }


    public DecodedObject decodeEnumItem(DecodedObject decodedTag, Class objectClass, Class enumClass,
                                        ElementInfo elementInfo,
                                        InputStream stream) throws Exception {
        //ASN1EnumItem enumObj = elementInfo.getAnnotatedClass().getAnnotation(ASN1EnumItem.class);
        //int min = 0, max = enumClass.getDeclaredFields().length;
        int min = 0, max = 0;
        for (Field enumItem : enumClass.getDeclaredFields()) {
            if (enumItem.isAnnotationPresent(ASN1EnumItem.class)) {
                max++;
            }
        }

        if (max <= 0) {
            throw new Exception("Unable to present any enum item!");
        }

        int enumItemIdx = (int) decodeConstraintNumber(min, max - 1, (BitArrayInputStream) stream);
        DecodedObject<Integer> result = new DecodedObject<Integer>();
        int idx = 0;
        for (Field enumItem : enumClass.getDeclaredFields()) {
            if (enumItem.isAnnotationPresent(ASN1EnumItem.class)) {
                if (idx++ == enumItemIdx) {
                    ASN1EnumItem enumItemObj = enumItem.getAnnotation(ASN1EnumItem.class);
                    result.setValue(enumItemObj.tag());
                    break;
                }
            }
        }
        return result;
    }

    public DecodedObject decodeBoolean(DecodedObject decodedTag, Class objectClass,
                                       ElementInfo elementInfo,
                                       InputStream stream) throws Exception {
        DecodedObject<Boolean> result = new DecodedObject<Boolean>();
        BitArrayInputStream bitStream = (BitArrayInputStream) stream;
        result.setValue(bitStream.readBit() == 1);
        return result;
    }

    public DecodedObject decodeAny(DecodedObject decodedTag, Class objectClass,
                                   ElementInfo elementInfo,
                                   InputStream stream) throws Exception {
        return null;
    }

    public DecodedObject decodeNull(DecodedObject decodedTag, Class objectClass,
                                    ElementInfo elementInfo,
                                    InputStream stream) throws Exception {
        return new DecodedObject(objectClass.newInstance());
    }

    public DecodedObject decodeInteger(DecodedObject decodedTag, Class objectClass,
                                       ElementInfo elementInfo,
                                       InputStream stream) throws Exception {

        boolean hasConstraint = false;
        long min = 0, max = 0;

        if (elementInfo.hasPreparedInfo()) {
            if (elementInfo.getPreparedInfo().hasConstraint()
                    && elementInfo.getPreparedInfo().getConstraint() instanceof ASN1ValueRangeConstraintMetadata) {
                IASN1ConstraintMetadata constraint = elementInfo.getPreparedInfo().getConstraint();
                hasConstraint = true;
                min = ((ASN1ValueRangeConstraintMetadata) constraint).getMin();
                max = ((ASN1ValueRangeConstraintMetadata) constraint).getMax();
            }
        } else if (elementInfo.getAnnotatedClass().isAnnotationPresent(ASN1ValueRangeConstraint.class)) {
            hasConstraint = true;
            ASN1ValueRangeConstraint constraint = elementInfo.getAnnotatedClass().getAnnotation(ASN1ValueRangeConstraint.class);
            min = constraint.min();
            max = constraint.max();
        }

        if (objectClass.equals(Integer.class)) {
            DecodedObject<Integer> result = new DecodedObject<Integer>();
            BitArrayInputStream bitStream = (BitArrayInputStream) stream;
            int value = 0;
            if (hasConstraint) {
                value = (int) decodeConstraintNumber(
                        (int) min,
                        (int) max,
                        bitStream
                );
            } else {
                value = (int) decodeUnconstraintNumber(bitStream);
            }
            result.setValue(value);
            return result;
        } else {
            DecodedObject<Long> result = new DecodedObject<Long>();
            BitArrayInputStream bitStream = (BitArrayInputStream) stream;
            long value = 0;
            if (hasConstraint) {
                value = decodeConstraintNumber(
                        min,
                        max,
                        bitStream
                );
            } else {
                value = decodeUnconstraintNumber(bitStream);
            }
            result.setValue(value);
            return result;
        }
    }

    public DecodedObject decodeReal(DecodedObject decodedTag, Class objectClass,
                                    ElementInfo elementInfo,
                                    InputStream stream) throws Exception {
        BitArrayInputStream bitStream = (BitArrayInputStream) stream;
        int len = decodeLengthDeterminant(bitStream);
        int realPreamble = stream.read();
        skipAlignedBits(stream);

        Double result = 0.0D;
        int szResult = len;
        if ((realPreamble & 0x40) == 1) {
            // 01000000 Value is PLUS-INFINITY
            result = Double.POSITIVE_INFINITY;
        }
        if ((realPreamble & 0x41) == 1) {
            // 01000001 Value is MINUS-INFINITY
            result = Double.NEGATIVE_INFINITY;
            szResult += 1;
        } else if (len > 0) {
            int szOfExp = 1 + (realPreamble & 0x3);
            int sign = realPreamble & 0x40;
            int ff = (realPreamble & 0x0C) >> 2;
            long exponent = decodeIntegerValueAsBytes(szOfExp, stream);
            long mantissaEncFrm = decodeIntegerValueAsBytes(szResult - szOfExp - 1, stream);
            // Unpack mantissa & decrement exponent for base 2
            long mantissa = mantissaEncFrm << ff;
            while ((mantissa & 0x000ff00000000000L) == 0x0) {
                exponent -= 8;
                mantissa <<= 8;
            }
            while ((mantissa & 0x0010000000000000L) == 0x0) {
                exponent -= 1;
                mantissa <<= 1;
            }
            mantissa &= 0x0FFFFFFFFFFFFFL;
            long lValue = (exponent + 1023 + 52) << 52;
            lValue |= mantissa;
            if (sign == 1) {
                lValue |= 0x8000000000000000L;
            }
            result = Double.longBitsToDouble(lValue);
        }
        return new DecodedObject(result, szResult);

    }


    public DecodedObject decodeOctetString(DecodedObject decodedTag, Class objectClass,
                                           ElementInfo elementInfo,
                                           InputStream stream) throws Exception {
        DecodedObject<byte[]> result = new DecodedObject<byte[]>();
        int sizeOfString = decodeLength(elementInfo, stream);
        skipAlignedBits(stream);
        if (sizeOfString > 0) {
            byte[] value = new byte[sizeOfString];
            stream.read(value);
            result.setValue(value);
        } else {
            result.setValue(new byte[0]);
        }
        return result;
    }

    public DecodedObject decodeBitString(DecodedObject decodedTag, Class objectClass,
                                         ElementInfo elementInfo,
                                         InputStream stream) throws Exception {
        DecodedObject<BitString> result = new DecodedObject<BitString>();
        BitArrayInputStream bitStream = (BitArrayInputStream) stream;
        skipAlignedBits(stream);
        int sizeOfString = decodeLength(elementInfo, stream);
        skipAlignedBits(stream);
        int trailBits = 8 - sizeOfString % 8;
        sizeOfString = sizeOfString / 8;
        if (sizeOfString > 0 || (sizeOfString == 0 && trailBits > 0)) {
            byte[] value = new byte[trailBits > 0 ? sizeOfString + 1 : sizeOfString];
            if (sizeOfString > 0) {
                stream.read(value, 0, sizeOfString);
            }
            if (trailBits > 0) {
                value[sizeOfString] = (byte) (bitStream.readBits(trailBits) << (8 - trailBits));
            }

            result.setValue(new BitString(value, trailBits));
        } else {
            result.setValue(new BitString(new byte[0]));
        }
        return result;
    }

    public DecodedObject decodeString(DecodedObject decodedTag, Class objectClass,
                                      ElementInfo elementInfo,
                                      InputStream stream) throws Exception {
        DecodedObject<String> result = new DecodedObject<String>();
        int strLen = decodeLength(elementInfo, stream);
        skipAlignedBits(stream);
        if (strLen > 0) {
            byte[] value = new byte[strLen];
            stream.read(value);
            result.setValue(CoderUtils.bufferToASN1String(value, elementInfo));
        } else {
            result.setValue("");
        }

        return result;
    }

    public DecodedObject decodeSequenceOf(DecodedObject decodedTag, Class objectClass,
                                          ElementInfo elementInfo,
                                          InputStream stream) throws Exception {
        Collection result = new LinkedList();
        int countOfElements = decodeLength(elementInfo, stream);
        ;

        if (countOfElements > 0) {

            Class paramType = CoderUtils.getCollectionType(elementInfo);

            for (int i = 0; i < countOfElements; i++) {
                ElementInfo info = new ElementInfo();
                info.setAnnotatedClass(paramType);
                info.setParentAnnotated(elementInfo.getAnnotatedClass());
                if (elementInfo.hasPreparedInfo()) {
                    ASN1SequenceOfMetadata seqOfMeta = (ASN1SequenceOfMetadata) elementInfo.getPreparedInfo().getTypeMetadata();
                    info.setPreparedInfo(seqOfMeta.getItemClassMetadata());
                }

                DecodedObject item = decodeClassType(null, paramType, info, stream);
                if (item != null) {
                    result.add(item.getValue());
                }
            }
            ;
        }
        return new DecodedObject(result);
    }


    public DecodedObject decodeObjectIdentifier(DecodedObject decodedTag,
                                                Class objectClass,
                                                ElementInfo elementInfo,
                                                InputStream stream) throws Exception {
        int len = decodeLength(elementInfo, stream);
        byte[] byteBuf = new byte[len];
        stream.read(byteBuf, 0, byteBuf.length);
        String dottedDecimal = org.bn.coders.ber.BERObjectIdentifier.Decode(byteBuf);
        return new DecodedObject<Object>(new ObjectIdentifier(dottedDecimal));
    }
}


