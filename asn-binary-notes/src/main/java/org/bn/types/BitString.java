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

package org.bn.types;

/**
 * BitString represents ASN.1 BIT STRING data types
 *
 * @author zhangyong
 * @todo Need more functional operations for write/read bits
 */
public class BitString {
    private byte[] bitStrValue = new byte[0];
    /**
     * count of buffer bit's trail
     */
    private int trailBitsCnt = 0;

    public BitString() {
    }

    public BitString(byte[] bitStrValue) {
        setValue(bitStrValue);
    }

    public BitString(byte[] bitStrValue, int trailBitsCnt) {
        setValue(bitStrValue, trailBitsCnt);
    }

    public BitString(BitString src) {
        setValue(src.getValue(), src.getTrailBitsCnt());
    }

    public int getLength() {
        return bitStrValue.length;
    }

    public int getTrailBitsCnt() {
        return trailBitsCnt;
    }

    public int getLengthInBits() {
        return getLength() * 8 - getTrailBitsCnt();
    }

    public byte[] getValue() {
        return bitStrValue;
    }

    public void setValue(byte[] val) {
        this.bitStrValue = val;
        this.trailBitsCnt = 0;
    }

    public void setValue(byte[] val, int trailBitsCnt) {
        setValue(val);
        this.trailBitsCnt = trailBitsCnt;
    }
}
