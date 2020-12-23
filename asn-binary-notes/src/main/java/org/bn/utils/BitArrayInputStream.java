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

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhangyong
 */
public class BitArrayInputStream extends InputStream {
    private InputStream byteStream;
    private int currentBit = 0, currentByte;

    public BitArrayInputStream(InputStream byteStream) {
        this.byteStream = byteStream;
    }

    @Override
    public synchronized int read() throws IOException {
        if (currentBit == 0) {
            return byteStream.read();
        } else {
            int nextByte = byteStream.read();
            int result = ((currentByte << currentBit) | (nextByte >> (8 - currentBit))) & 0xFF;
            currentByte = nextByte;
            return result;
        }
    }

    public synchronized int readBit() throws IOException {
        if (currentBit == 0) {
            currentByte = byteStream.read();
        }
        currentBit++;
        int result = currentByte >> (8 - currentBit) & 0x1;
        if (currentBit > 7)
            currentBit = 0;
        return result;
    }

    public synchronized int readBits(int nBits) throws IOException {
        int result = 0;
        for (int i = 0; i < nBits && i <= 32; i++) {
            result = ((result << 1) | readBit());
        }
        return result;
    }

    public void skipUnreadedBits() {
        currentBit = 0;
    }
}
