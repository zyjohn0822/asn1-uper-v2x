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
import org.bn.coders.ElementInfo;
import org.bn.coders.Encoder;
import org.bn.metadata.ASN1SequenceOfMetadata;
import org.bn.metadata.constraints.ASN1SizeConstraintMetadata;
import org.bn.metadata.constraints.ASN1ValueRangeConstraintMetadata;
import org.bn.metadata.constraints.IASN1ConstraintMetadata;
import org.bn.types.BitString;
import org.bn.types.ObjectIdentifier;
import org.bn.utils.BitArrayOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.SortedMap;

/**
 * @param <T>
 * @author zhangyong
 */
public class PERAlignedEncoder<T> extends Encoder<T> {

    public PERAlignedEncoder() {
    }

    @Override
    public void encode(T object, OutputStream stream) throws Exception {
        BitArrayOutputStream bitStream = new BitArrayOutputStream();
        super.encode(object, bitStream);
        bitStream.writeTo(stream);
    }

    protected void doAlign(OutputStream stream) {
        ((BitArrayOutputStream) stream).align();
    }


    protected int encodeIntegerValueAsBytes(long value, OutputStream stream) throws Exception {
        int integerSize = CoderUtils.getIntegerLength(value);
        for (int i = integerSize - 1; i >= 0; i--) {
            long valueTmp = value >> (8 * i);
            stream.write((int) (valueTmp & 0xFF));
        }
        return integerSize;
    }

    /**
     * Encoding constraint length determinant procedure.
     * ITU-T X.691. 10.9. General rules for encoding a length determinant
     */
    protected int encodeConstraintLengthDeterminant(int length, int min, int max, BitArrayOutputStream stream) throws Exception {
        if (max <= 0xFFFF) {
            // 10.9. NOTE 2(Tutorial) In the case of the ALIGNED variant
            // if the length count is bounded above by an upper bound that is 
            // less than 64K, then the constrained whole number encoding 
            // is used for the length.
            return encodeConstraintNumber(length, min, max, stream); // encoding as constraint integer
        } else {
            return encodeLengthDeterminant(length, stream);
        }
    }

    /**
     * Encoding length determinant procedure.
     * ITU-T X.691. 10.9. General rules for encoding a length determinant
     */
    protected int encodeLengthDeterminant(int length, BitArrayOutputStream stream) throws IOException {
        int result = 0;
        doAlign(stream);
        if (length >= 0 && length < 0x80) { // NOTE 2. a) ("n" less than 128)
            stream.write(length); // a single octet containing "n" with bit 8 set to zero;
            result = 1;
        } else if (length < 0x4000) {
            // NOTE 2. b) ("n" less than 16K) two octets 
            // containing "n" with bit 8 of the first octet 
            // set to 1 and bit 7 set to zero;
            stream.write(length >>> 8 & 0x3f | 0x80);
            stream.write(length);
            result = 2;
        } else {
            // NOTE 2. b) (large "n") a single octet containing a count "m" 
            // with bit 8 set to 1 and bit 7 set to 1. 
            // The count "m" is one to four, and the length indicates that 
            // a fragment of the material follows (a multiple "m" of 16K items). 
            // For all values of "m", the fragment is then followed 
            // by another length encoding for the remainder of the material.        
            throw new InternalError("Not supported for this version. Length too big!");
        }
        return result;
    }


    /**
     * Encoding of a constrained whole number
     * ITU-T X.691. 10.5.
     * NOTE  (Tutorial) This subclause is referenced by other clauses,
     * and itself references earlier clauses for the production of
     * a nonnegative-binary-integer or a 2's-complement-binary-integer encoding.
     */
    protected int encodeConstraintNumber(long value, long min, long max, BitArrayOutputStream stream) throws Exception {
        int result = 0;
        long valueRange = max - min;
        long narrowedVal = value - min;
        int maxBitLen = PERCoderUtils.getMaxBitLength(valueRange);

        if (valueRange == 0) {
            return result;
        }

        // The rest of this Note addresses the ALIGNED variant. 
        if (valueRange > 0 && valueRange < 256) {
            /*
             * 1. Where the range is less than or equal to 255, the value encodes
             * into a bit-field of the minimum size for the range.
             * 2. Where the range is exactly 256, the value encodes
             * into a single octet octet-aligned bit-field.
             */
            doAlign(stream);
            for (int i = maxBitLen - 1; i >= 0; i--) {
                int bitValue = (int) ((narrowedVal >> i) & 0x1L);
                stream.writeBit(bitValue);
            }
            result = 1;
        } else if (valueRange > 0 && valueRange < 65536) {
            /*
             * 3. Where the range is 257 to 64K, the value encodes into
             * a two octet octet-aligned bit-field.
             */
            doAlign(stream);
            stream.write((int) (narrowedVal >>> 8));
            stream.write((int) (narrowedVal & 0xFF));
            result = 2;
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
            result = encodeConstraintLengthDeterminant(CoderUtils.getIntegerLength(narrowedVal),
                    1, CoderUtils.getPositiveIntegerLength(valueRange),
                    stream
            );
            doAlign(stream);
            result += encodeIntegerValueAsBytes(narrowedVal, stream);
        }
        return result;
    }

    /**
     * Encoding of a semi-constrained whole number
     * ITU-T X.691. 10.7.
     * NOTE  (Tutorial) This procedure is used when a lower bound can be
     * identified but not an upper bound. The encoding procedure places
     * the offset from the lower bound into the minimum number of octets
     * as a non-negative-binary-integer, and requires an explicit length
     * encoding (typically a single octet) as specified in later procedures.
     */
    protected int encodeSemiConstraintNumber(int value, int min, BitArrayOutputStream stream) throws Exception {
        int result = 0;
        int narrowedVal = value - min;
        int intLen = CoderUtils.getIntegerLength(narrowedVal);
        result += encodeLengthDeterminant(intLen, stream);
        doAlign(stream);
        result += encodeIntegerValueAsBytes(narrowedVal, stream);
        return result;
    }

    /**
     * Encode normally small number
     * ITU-T X.691. 10.6
     * NOTE  (Tutorial) This procedure is used when encoding
     * a non-negative whole number that is expected to be small, but whose size
     * is potentially unlimited due to the presence of an extension marker.
     * An example is a choice index.
     */
    protected int encodeNormallySmallNumber(int value, BitArrayOutputStream stream) throws Exception {
        int result = 0;
        if (value > 0 && value < 64) {
            /* 10.6.1 If the non-negative whole number, "n", is less than
             * or equal to 63, then a single-bit bit-field shall be appended
             * to the field-list with the bit set to 0, and "n" shall be
             * encoded as a non-negative-binary-integer into a 6-bit bit-field.
             */
            stream.writeBit(0);
            for (int i = 0; i < 6; i++) {
                int bitValue = (value >> 6 - i) & 0x1;
                stream.writeBit(bitValue);
            }
            result = 1;
        } else {
            /* If "n" is greater than or equal to 64, a single-bit
             * bit-field with the bit set to 1 shall be appended to the field-list.
             * The value "n" shall then be encoded as a semi-constrained
             * whole number with "lb" equal to 0 and the procedures of
             * 10.9 shall be invoked to add it to the field-list preceded
             * by a length determinant.
             */
            stream.writeBit(1);
            result += encodeSemiConstraintNumber(value, 0, stream);
        }
        return result;
    }

    /**
     * Encoding of a unconstrained whole number
     * ITU-T X.691. 10.8.
     * NOTE  (Tutorial) This case only arises in the encoding of the
     * value of an integer type with no lower bound. The procedure
     * encodes the value as a 2's-complement-binary-integer into
     * the minimum number of octets required to accommodate the encoding,
     * and requires an explicit length encoding (typically a single octet)
     * as specified in later procedures.
     */
    protected int encodeUnconstraintNumber(long value, BitArrayOutputStream stream) throws Exception {
        int result = 0;
        int intLen = CoderUtils.getIntegerLength(value);
        result += encodeLengthDeterminant(intLen, stream);
        doAlign(stream);
        result += encodeIntegerValueAsBytes(value, stream);
        return result;
    }

    public int encodeInteger(Object object, OutputStream stream,
                             ElementInfo elementInfo) throws Exception {
        int result = 0;
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

        if (object instanceof Integer) {
            Integer value = (Integer) object;
            BitArrayOutputStream bitStream = (BitArrayOutputStream) stream;
            if (hasConstraint) {
                result += encodeConstraintNumber(value, (int) min, (int) max, bitStream);
            } else {
                result += encodeUnconstraintNumber(value, bitStream);
            }
        } else {
            Long value = (Long) object;
            BitArrayOutputStream bitStream = (BitArrayOutputStream) stream;
            if (hasConstraint) {
                result += encodeConstraintNumber(value, min, max, bitStream);
            } else {
                result += encodeUnconstraintNumber(value, bitStream);
            }
        }
        return result;
    }

    public int encodeReal(Object object, OutputStream stream,
                          ElementInfo elementInfo) throws Exception {
        int result = 0;
        BitArrayOutputStream bitStream = (BitArrayOutputStream) stream;
        Double value = (Double) object;
        //CoderUtils.checkConstraints(value,elementInfo);
        int szOfInt = 0;
        long asLong = Double.doubleToLongBits(value);
        if (asLong == 0x7ff0000000000000L) { // positive infinity
            result += encodeLengthDeterminant(1, bitStream);
            doAlign(stream);
            stream.write(0x40); // 01000000 Value is PLUS-INFINITY
            result += 1;
        } else if (asLong == 0xfff0000000000000L) { // negative infinity
            result += encodeLengthDeterminant(1, bitStream);
            doAlign(stream);
            stream.write(0x41); // 01000001 Value is MINUS-INFINITY
            result += 1;
        } else if (asLong != 0x0) {
            long exponent = ((0x7ff0000000000000L & asLong) >> 52) - 1023 - 52;
            long mantissa = 0x000fffffffffffffL & asLong;
            mantissa |= 0x10000000000000L; // set virtual delimeter

            // pack mantissa for base 2
            while ((mantissa & 0xFFL) == 0x0) {
                mantissa >>= 8;
                exponent += 8; //increment exponent to 8 (base 2)
            }
            while ((mantissa & 0x01L) == 0x0) {
                mantissa >>= 1;
                exponent += 1; //increment exponent to 1
            }

            int szOfExp = CoderUtils.getIntegerLength(exponent);
            encodeLengthDeterminant(CoderUtils.getIntegerLength(mantissa) + szOfExp + 1, bitStream);
            doAlign(stream);
            int realPreamble = 0x80;

            realPreamble |= (byte) (szOfExp - 1);
            if ((asLong & 0x8000000000000000L) == 1) {
                realPreamble |= 0x40; // Sign
            }
            stream.write(realPreamble);
            result += 1;


            result += encodeIntegerValueAsBytes(exponent, stream);
            result += encodeIntegerValueAsBytes(mantissa, stream);
        }
        return result;
    }

    public int encodeLength(int value, ElementInfo elementInfo, OutputStream stream) throws Exception {
        int resultSize = 0;
        BitArrayOutputStream bitStream = (BitArrayOutputStream) stream;
        CoderUtils.checkConstraints(value, elementInfo);
        if (elementInfo.hasPreparedInfo()) {
            if (elementInfo.getPreparedInfo().hasConstraint()) {
                IASN1ConstraintMetadata constraint = elementInfo.getPreparedInfo().getConstraint();
                if (constraint instanceof ASN1ValueRangeConstraintMetadata) {
                    resultSize += encodeConstraintLengthDeterminant(value,
                            (int) ((ASN1ValueRangeConstraintMetadata) constraint).getMin(),
                            (int) ((ASN1ValueRangeConstraintMetadata) constraint).getMax(),
                            bitStream
                    );
                } else if (constraint instanceof ASN1SizeConstraintMetadata) {
                }
            } else {
                resultSize += encodeLengthDeterminant(value, bitStream);
            }
        } else if (elementInfo.getAnnotatedClass().isAnnotationPresent(ASN1ValueRangeConstraint.class)) {
            ASN1ValueRangeConstraint constraint = elementInfo.getAnnotatedClass().getAnnotation(ASN1ValueRangeConstraint.class);
            resultSize += encodeConstraintLengthDeterminant(value, (int) constraint.min(), (int) constraint.max(), bitStream);
        } else if (elementInfo.getAnnotatedClass().isAnnotationPresent(ASN1SizeConstraint.class)) {
            ASN1SizeConstraint constraint = elementInfo.getAnnotatedClass().getAnnotation(ASN1SizeConstraint.class);
            //resultSize += encodeConstraintLengthDeterminant(value, 0, (int)constraint.max(), bitStream);
        } else {
            resultSize += encodeLengthDeterminant(value, bitStream);
        }
        return resultSize;
    }


    protected int encodeSequencePreamble(Object object, Field[] fields, ElementInfo elementInfo, OutputStream stream) throws Exception {
        int resultBitSize = 0;
        ElementInfo info = new ElementInfo();
        int fieldIdx = 0;
        for (Field field : fields) {
            if (!field.isSynthetic()) {
                if (elementInfo.hasPreparedInfo()) {
                    info.setPreparedInfo(elementInfo.getPreparedInfo().getFieldMetadata(fieldIdx));
                }

                if (CoderUtils.isOptionalField(field, info)) {
                    Object invokeObjResult = invokeGetterMethodForField(field, object, info);
                    ((BitArrayOutputStream) stream).writeBit(invokeObjResult != null);
                    resultBitSize += 1;
                }
                fieldIdx++;
            }
        }
        doAlign(stream);
        return (resultBitSize / 8) + (resultBitSize % 8 > 0 ? 1 : 0);
    }

    @Override
    public int encodeSequence(Object object, OutputStream stream,
                              ElementInfo elementInfo) throws Exception {
        int resultSize = 0;
        if (!CoderUtils.isSequenceSet(elementInfo)) {
            resultSize += encodeSequencePreamble(object, elementInfo.getFields(object.getClass()), elementInfo, stream);
            resultSize += super.encodeSequence(object, stream, elementInfo);
        } else {
            resultSize += encodeSet(object, stream, elementInfo);
        }
        return resultSize;
    }

    protected int encodeChoicePreamble(Object object, OutputStream stream, int elementIndex, ElementInfo elementInfo) throws Exception {
        return encodeConstraintNumber(elementIndex, 1, PERCoderUtils.getRealFieldsCount(object.getClass(), elementInfo), (BitArrayOutputStream) stream);
    }

    /**
     * Encoding of the choice structure
     * ITU-T X.691. 22.
     * NOTE  (Tutorial) A choice type is encoded by encoding an index specifying
     * the chosen alternative. This is encoded as for a constrained integer
     * (unless the extension marker is present in the choice type,
     * in which case it is a normally small non-negative whole number)
     * and would therefore typically occupy a fixed length bit-field of the
     * minimum number of bits needed to encode the index. (Although it could
     * in principle be arbitrarily large.) This is followed by the encoding
     * of the chosen alternative, with alternatives that are extension
     * additions encoded as if they were the value of an open type field.
     * Where the choice has only one alternative, there is no encoding
     * for the index.
     */
    @Override
    public int encodeChoice(Object object, OutputStream stream,
                            ElementInfo elementInfo) throws Exception {
        int resultSize = 0;
        doAlign(stream);
        ElementInfo info = null;
        int elementIndex = 0;
        int fieldIdx = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            if (!field.isSynthetic()) {
                elementIndex++;
                info = new ElementInfo();
                info.setAnnotatedClass(field);
                if (elementInfo.hasPreparedInfo()) {
                    info.setPreparedInfo(elementInfo.getPreparedInfo().getFieldMetadata(fieldIdx));
                } else {
                    info.setASN1ElementInfoForClass(field);
                }
                if (isSelectedChoiceItem(field, object, info)) {
                    break;
                } else {
                    info = null;
                }
                fieldIdx++;
            }
        }
        if (info == null) {
            throw new IllegalArgumentException("The choice '" + object.toString() + "' does not have a selected item!");
        }
        Object invokeObjResult = invokeGetterMethodForField((Field) info.getAnnotatedClass(), object, info);
        resultSize += encodeChoicePreamble(object, stream, elementIndex, elementInfo);
        resultSize += encodeClassType(invokeObjResult, stream, info);
        return resultSize;
    }

    public int encodeEnumItem(Object enumConstant, Class enumClass, OutputStream stream,
                              ElementInfo elementInfo) throws Exception {
        ASN1EnumItem enumObj = elementInfo.getAnnotatedClass().getAnnotation(ASN1EnumItem.class);
        //int min = 0, max = enumClass.getDeclaredFields().length, value =0;
        int min = 0, max = 0, value = 0;
        for (Field enumItem : enumClass.getDeclaredFields()) {
            if (enumItem.isAnnotationPresent(ASN1EnumItem.class)) {

                ASN1EnumItem enumItemObj = enumItem.getAnnotation(ASN1EnumItem.class);
                if (enumItemObj.tag() == enumObj.tag()) {
                    value = max;
                }
                max++;
            }
        }

        if (max > 0) {
            return encodeConstraintNumber(value, min, max - 1, (BitArrayOutputStream) stream);
        } else {
            throw new Exception("Unable to present any enum item!");
        }
    }

    public int encodeBoolean(Object object, OutputStream stream,
                             ElementInfo elementInfo) throws Exception {
        int resultSize = 1;
        //doAlign(stream);
        BitArrayOutputStream bitStream = (BitArrayOutputStream) stream;
        bitStream.writeBit((Boolean) object);
        return resultSize;
    }

    public int encodeAny(Object object, OutputStream stream,
                         ElementInfo elementInfo) throws Exception {
        int resultSize = 0, sizeOfString = 0;
        byte[] buffer = (byte[]) object;
        stream.write(buffer);
        sizeOfString = buffer.length;
        resultSize += sizeOfString;
        return resultSize;
    }

    public int encodeOctetString(Object object, OutputStream stream,
                                 ElementInfo elementInfo) throws Exception {
        int resultSize = 0, sizeOfString = 0;
        byte[] buffer = (byte[]) object;
        sizeOfString = buffer.length;
        resultSize += encodeLength(sizeOfString, elementInfo, stream);
        doAlign(stream);
        if (sizeOfString > 0) {
            stream.write(buffer);
        }
        return resultSize;
    }

    public int encodeBitString(Object object, OutputStream stream,
                               ElementInfo elementInfo) throws Exception {
        /*NOTE � (Tutorial) Bitstrings constrained to a fixed length less than or equal to 16 bits do not cause octet alignment. Larger
        bitstrings are octet-aligned in the ALIGNED variant. If the length is fixed by constraints and the upper bound is less than 64K,
        there is no explicit length encoding, otherwise a length encoding is included which can take any of the forms specified earlier for
        length encodings, including fragmentation for large bit strings.*/

        int resultSize = 0, sizeOfString = 0;
        BitString str = (BitString) object;
        byte[] buffer = str.getValue();
        sizeOfString = str.getLengthInBits();

        BitArrayOutputStream bitStream = (BitArrayOutputStream) stream;
        resultSize += encodeLength(sizeOfString, elementInfo, stream);
        doAlign(stream);
        if (sizeOfString > 0) {

            if (str.getTrailBitsCnt() == 0) {
                stream.write(buffer);
            } else {
                bitStream.write(buffer, 0, buffer.length - 1);
                for (int i = 0; i < str.getTrailBitsCnt(); i++) {
                    int bitValue = (buffer[buffer.length - 1] >> (7 - i)) & 0x1;
                    bitStream.writeBit(bitValue);
                }
            }
        }

        return resultSize;
    }

    public int encodeString(Object object, OutputStream stream,
                            ElementInfo elementInfo) throws Exception {
        int resultSize = 0;
        byte[] value = CoderUtils.ASN1StringToBuffer(object, elementInfo);
        resultSize = encodeLength(value.length, elementInfo, stream);
        doAlign(stream);
        resultSize += value.length;
        if (value.length > 0) {
            stream.write(value);
        }
        return resultSize;
    }

    public int encodeSequenceOf(Object object, OutputStream stream,
                                ElementInfo elementInfo) throws Exception {
        int resultSize = 0;
        Object[] collection = ((Collection<Object>) object).toArray();

        resultSize += encodeLength(collection.length, elementInfo, stream);
        for (int i = 0; i < collection.length; i++) {
            Object obj = collection[i];
            ElementInfo info = new ElementInfo();
            info.setAnnotatedClass(obj.getClass());
            info.setParentAnnotated(elementInfo.getAnnotatedClass());
            if (elementInfo.hasPreparedInfo()) {
                ASN1SequenceOfMetadata seqOfMeta = (ASN1SequenceOfMetadata) elementInfo.getPreparedInfo().getTypeMetadata();
                info.setPreparedInfo(seqOfMeta.getItemClassMetadata());
            }

            resultSize += encodeClassType(obj, stream, info);
        }
        return resultSize;
    }

    public int encodeNull(Object object, OutputStream stream,
                          ElementInfo elementInfo) throws Exception {
        return 0;
    }


    protected int encodeSet(Object object, OutputStream stream,
                            ElementInfo elementInfo) throws Exception {
        int resultSize = 0;
        Field[] fields = null;
        if (elementInfo.hasPreparedInfo()) {
            fields = elementInfo.getPreparedInfo().getFields();
        } else {
            SortedMap<Integer, Field> fieldOrder = CoderUtils.getSetOrder(object.getClass());
            fields = new Field[0];
            fields = fieldOrder.values().toArray(fields);
        }
        resultSize += encodeSequencePreamble(object, fields, elementInfo, stream);

        int fieldIdx = 0;
        for (int i = 0; i < fields.length; i++) {
            resultSize += encodeSequenceField(object, fieldIdx++, fields[i], stream, elementInfo);
        }
        return resultSize;
    }

    public int encodeObjectIdentifier(Object object, OutputStream stream,
                                      ElementInfo elementInfo) throws Exception {
        ObjectIdentifier oid = (ObjectIdentifier) object;
        int[] ia = oid.getIntArray();
        byte[] buffer = org.bn.coders.ber.BERObjectIdentifier.Encode(ia);
        if (buffer.length < 1) {
            return 0;
        }
        int resultSize = 0; // size of tag 
        resultSize += encodeLength(buffer.length, elementInfo, stream);
        stream.write(buffer, 0, buffer.length);
        resultSize += buffer.length; // size of buffer         
        return resultSize;
    }
}
