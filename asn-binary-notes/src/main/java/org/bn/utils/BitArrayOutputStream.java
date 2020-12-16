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

package org.bn.utils;

import java.io.ByteArrayOutputStream;

/**
 * @author zhangyong
 */
public class BitArrayOutputStream extends ByteArrayOutputStream {
    int currentBit = 0;

    public BitArrayOutputStream() {
        super(1024);
    }

    public BitArrayOutputStream(int initialSize) {
        super(initialSize);
    }

    public void align() {
        currentBit = 0;
    }

    @Override
    public synchronized void write(int b) {
        if (currentBit == 0) {
            super.write(b);
        } else {
            byte lBt = buf[count - 1];
            byte nBt = (byte) (lBt | (b >> currentBit));
            buf[count - 1] = nBt;
            lBt = (byte) (b << (8 - currentBit));
            super.write(lBt);
        }
        //currentBit = 0;
    }

    @Override
    public synchronized void write(byte b[], int off, int len) {
        if (len == 0) {
            return;
        }
        if (currentBit == 0) {
            super.write(b, off, len);
        } else {
            byte lBt = buf[count - 1];
            for (int i = off; i < off + len; i++) {
                int bufByte = b[i] < 0 ? 256 + b[i] : b[i];
                byte nBt = (byte) (lBt | (bufByte >> currentBit));
                if (i == off) {
                    buf[count - 1] = nBt;
                } else {
                    super.write(nBt);
                }
                lBt = (byte) (bufByte << (8 - currentBit));
            }
            super.write(lBt);
        }
        //currentBit = 0;    
    }

    public void writeBit(boolean value) {
        writeBit(value ? 1 : 0);
    }

    public synchronized void writeBit(int bit) {
        if (currentBit < 8 && currentBit > 0) {
            if (bit != 0) {
                buf[count - 1] |= (byte) (0x80 >> currentBit);
            }
        } else {
            super.write(bit == 0 ? 0 : 0x80);
        }
        currentBit++;
        if (currentBit >= 8) {
            currentBit = 0;
        }
    }

    public synchronized void writeBits(int bt, int count) {
        for (int i = count - 1; i >= 0; i--) {
            writeBit((bt >> i) & 0x1);
        }
    }

    @Override
    public void reset() {
        currentBit = 0;
        super.reset();
    }

    public int getTrailBitsCnt() {
        return currentBit;
    }
}
