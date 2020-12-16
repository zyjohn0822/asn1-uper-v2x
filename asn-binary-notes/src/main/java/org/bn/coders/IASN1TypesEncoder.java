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

import java.io.OutputStream;

import java.lang.reflect.Field;

public interface IASN1TypesEncoder {
    int encodeClassType(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception;
    int encodeSequence(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception;
    int encodeChoice(Object object, OutputStream stream, ElementInfo elementInfo)  throws Exception;
    int encodeEnum(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception;
    int encodeEnumItem(Object enumConstant, Class enumClass, OutputStream stream, ElementInfo elementInfo) throws Exception ;
    int encodeBoolean(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception;
    int encodeAny(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception ;
    int encodeNull(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception ;
    int encodeInteger(Object object, OutputStream steam, ElementInfo elementInfo) throws Exception ;
    int encodeReal(Object object, OutputStream steam, ElementInfo elementInfo) throws Exception ;
    int encodeOctetString(Object object, OutputStream steam, ElementInfo elementInfo) throws Exception ;
    int encodeBitString(Object object, OutputStream steam, ElementInfo elementInfo) throws Exception ;
    int encodeObjectIdentifier(Object object, OutputStream steam, ElementInfo elementInfo) throws Exception ;
    int encodeString(Object object, OutputStream steam, ElementInfo elementInfo) throws Exception ;
    int encodeSequenceOf(Object object, OutputStream steam, ElementInfo elementInfo) throws Exception ;   
    int encodeElement(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception;
    int encodeBoxedType(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception;
    int encodePreparedElement(Object object, OutputStream stream, ElementInfo elementInfo) throws Exception;
    Object invokeGetterMethodForField(Field field, Object object, ElementInfo elementInfo) throws Exception;
    boolean invokeSelectedMethodForField(Field field, Object object, ElementInfo elementInfo) throws Exception;
}
