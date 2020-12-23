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

package org.bn.metadata;

import org.bn.coders.DecodedObject;
import org.bn.coders.ElementInfo;
import org.bn.coders.IASN1TypesDecoder;
import org.bn.coders.IASN1TypesEncoder;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zhangyong
 */
public interface IASN1Metadata {
    /**
     * 功能描述: <br>
     * <p>获取名称</p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     *
     * @param
     * @return: java.lang.String
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/11 15:07
     */
    String getName();

    /**
     * 功能描述: <br>
     * <p>解码方法</p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     *
     * @param encoder     {@link IASN1TypesEncoder}
     * @param object      obj
     * @param stream      out stream
     * @param elementInfo info
     * @return: int
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/11 15:07
     */
    int encode(IASN1TypesEncoder encoder, Object object, OutputStream stream, ElementInfo elementInfo) throws Exception;

    /**
     * 功能描述: <br>
     * <p>编码方法</p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     *
     * @param decoder     {@link IASN1TypesDecoder}
     * @param decodedTag  tag
     * @param objectClass clazz
     * @param elementInfo info
     * @param stream      stream
     * @return: org.bn.coders.DecodedObject
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/11 15:07
     */
    DecodedObject decode(IASN1TypesDecoder decoder, DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;
}
