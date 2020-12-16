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
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * This class implements an output stream in which the data is
 * written into a reverse byte array. The buffer automatically grows as data
 * is written to it.
 * The data can be retrieved using <code>toByteArray()</code> and
 * <code>toString()</code>.
 * <p>
 * Closing a <tt>ByteArrayOutputStream</tt> has no effect. The methods in
 * this class can be called after the stream has been closed without
 * generating an <tt>IOException</tt>.
 *
 * @author zhangyong
 */
public class ReverseByteArrayOutputStream extends ByteArrayOutputStream {
    public ReverseByteArrayOutputStream() {
        super(1024);
    }

    @Override
    public synchronized void writeTo(OutputStream out) throws IOException {
        byte[] bufTmp = toByteArray();
        out.write(bufTmp, 0, bufTmp.length);
    }

    @Override
    public synchronized byte toByteArray()[] {
        byte newbuf[] = new byte[count];
        System.arraycopy(buf, buf.length - count, newbuf, 0, count);
        return newbuf;
    }

    @Override
    public String toString() {
        return new String(toByteArray());
    }

    @Override
    public String toString(String enc) throws UnsupportedEncodingException {
        return new String(toByteArray(), enc);
    }

    @Override
    public synchronized void write(int b) {
        int newcount = count + 1;
        resizeBuffer(newcount);
        buf[buf.length - 1 - count] = (byte) b;
        count = newcount;
    }

    protected void resizeBuffer(int newcount) {
        if (newcount > buf.length) {
            byte newbuf[] = new byte[Math.max(buf.length << 1, newcount)];
            //System.arraycopy(buf, 0, newbuf, 0, count);
            // Memory corruption bug fix. Thanks to John Finley.
            System.arraycopy(buf, buf.length - count, newbuf, newbuf.length - count, count);
            buf = newbuf;
        }
    }

    @Override
    public synchronized void write(byte b[], int off, int len) {
        if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
        int newcount = count + len;
        resizeBuffer(newcount);
        System.arraycopy(b, off, buf, buf.length - count - len, len);
        count = newcount;
    }

}
