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
package org.bn;

import java.io.OutputStream;

/**
 * The ASN.1 encoder interface
 *
 * @author zhangyong
 */
public interface IEncoder<T> {
    /**
     * Encode object
     *
     * @param object User object
     * @param stream Stream to encoding
     * @throws Exception
     * @see CoderFactory
     */
    public void encode(T object, OutputStream stream) throws Exception;
}
