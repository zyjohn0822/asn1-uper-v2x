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
package org.bn.coders.ber;

import org.bn.annotations.ASN1Element;
import org.bn.coders.DecodedObject;
import org.bn.coders.ElementInfo;
import org.bn.coders.UniversalTag;
import org.bn.metadata.ASN1ElementMetadata;

/**
 * @author zhangyong
 */
public class BERCoderUtils {

    public static DecodedObject<Integer> getTagValueForElement(ElementInfo info, int tagClass, int elemenType, int universalTag) {
        DecodedObject<Integer> result = new DecodedObject<Integer>();
        result.setSize(1);
        // result.setValue(tagClass | elemenType | universalTag);
        if (universalTag < UniversalTag.LastUniversal) {
            result.setValue(tagClass | elemenType | universalTag);
        } else {
            result = getTagValue(tagClass, elemenType, universalTag, universalTag, tagClass);
        }

        if (info.hasPreparedInfo()) {
            ASN1ElementMetadata meta = info.getPreparedASN1ElementInfo();
            if (meta != null && meta.hasTag()) {
                result = getTagValue(tagClass, elemenType, universalTag,
                        meta.getTag(),
                        meta.getTagClass()
                );
            }
        } else {
            ASN1Element elementInfo = null;
            if (info.getASN1ElementInfo() != null) {
                elementInfo = info.getASN1ElementInfo();
            } else if (info.getAnnotatedClass().isAnnotationPresent(ASN1Element.class)) {
                elementInfo = info.getAnnotatedClass().getAnnotation(ASN1Element.class);
            }

            if (elementInfo != null) {
                if (elementInfo.hasTag()) {
                    result = getTagValue(tagClass, elemenType, universalTag, elementInfo.tag(), elementInfo.tagClass());
                }
            }
        }
        return result;
    }

    public static DecodedObject<Integer> getTagValue(int tagClass, int elemenType, int universalTag, int userTag, int userTagClass) {
        DecodedObject<Integer> resultObj = new DecodedObject<Integer>();
        int result = tagClass | elemenType | universalTag;

        tagClass = userTagClass;
        if (userTag < 31) {
            result = tagClass | elemenType | userTag;
            resultObj.setSize(1);
        } else {
            result = tagClass | elemenType | 0x1F;
            if (userTag < 0x80) {
                result <<= 8;
                result |= userTag & 0x7F;
                resultObj.setSize(2);
            } else if (userTag < 0x3FFF) {
                result <<= 16;
                result |= (((userTag & 0x3fff) >> 7) | 0x80) << 8;
                result |= ((userTag & 0x3fff) & 0x7f);
                resultObj.setSize(3);
            } else if (userTag < 0x3FFFF) {
                result <<= 24;
                result |= (((userTag & 0x3FFFF) >> 15) | 0x80) << 16;
                result |= (((userTag & 0x3FFFF) >> 7) | 0x80) << 8;
                result |= ((userTag & 0x3FFFF) & 0x3f);
                resultObj.setSize(4);
            }
        }
        resultObj.setValue(result);
        return resultObj;
    }
}
