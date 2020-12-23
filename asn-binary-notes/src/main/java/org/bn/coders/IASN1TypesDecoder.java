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
package org.bn.coders;

import java.io.InputStream;
import java.lang.reflect.Field;

public interface IASN1TypesDecoder {
    DecodedObject decodeTag(InputStream stream) throws Exception;

    DecodedObject decodeClassType(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeSequence(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeChoice(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeBoolean(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeAny(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeNull(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeInteger(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeReal(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeOctetString(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeBitString(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeObjectIdentifier(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeString(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeSequenceOf(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeEnum(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeEnumItem(DecodedObject decodedTag, Class objectClass, Class enumClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeBoxedType(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodeElement(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    DecodedObject decodePreparedElement(DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception;

    void invokeSetterMethodForField(Field field, Object object, Object param, ElementInfo elementInfo) throws Exception;

    void invokeSelectMethodForField(Field field, Object object, Object param, ElementInfo elementInfo) throws Exception;
}
