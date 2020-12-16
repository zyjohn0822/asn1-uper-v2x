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

import org.bn.coders.ElementInfo;
import org.bn.utils.BitArrayOutputStream;

import java.io.OutputStream;

/**
 * @param <T>
 * @author zhangyong
 */
public class PERUnalignedEncoder<T> extends PERAlignedEncoder<T> {
    public PERUnalignedEncoder() {
    }

    @Override
    protected int encodeConstraintNumber(long value, long min, long max, BitArrayOutputStream stream) throws Exception {
        int result = 0;
        long valueRange = max - min;
        long narrowedVal = value - min;
        int maxBitLen = PERCoderUtils.getMaxBitLength(valueRange);

        if (valueRange == 0) {
            return result;
        }

        //For the UNALIGNED variant the value is always encoded in the minimum 
        // number of bits necessary to represent the range (defined in 10.5.3). 
        int currentBit = maxBitLen;
        while (currentBit > 8) {
            currentBit -= 8;
            result++;
            stream.write((int) (narrowedVal >>> currentBit));

        }
        if (currentBit > 0) {
            for (int i = currentBit - 1; i >= 0; i--) {
                int bitValue = (int) ((narrowedVal >> i) & 0x1);
                stream.writeBit(bitValue);
            }
            result += 1;
        }
        return result;
    }

    @Override
    public int encodeString(Object object, OutputStream stream,
                            ElementInfo elementInfo) throws Exception {

        int resultSize = 0;
        if (!PERCoderUtils.is7BitEncodedString(elementInfo)) {
            resultSize = super.encodeString(object, stream, elementInfo);
        } else {

            byte[] value = object.toString().getBytes();
            resultSize = encodeLength(value.length, elementInfo, stream);
            if (value.length == 0) {
                return resultSize;
            }

            BitArrayOutputStream bitStream = (BitArrayOutputStream) stream;
            // 7-bit encoding of string
            for (int i = 0; i < value.length; i++) {
                bitStream.writeBits(value[i], 7);
            }
        }
        return resultSize;

    }

    @Override
    protected void doAlign(OutputStream stream) {
        // Do nothing! Unaligned encoding ;)
    }

}
