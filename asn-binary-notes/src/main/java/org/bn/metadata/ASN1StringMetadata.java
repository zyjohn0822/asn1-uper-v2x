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

import org.bn.annotations.ASN1String;
import org.bn.coders.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.AnnotatedElement;

/**
 * @author zhangyong
 */
public class ASN1StringMetadata
        extends ASN1FieldMetadata {
    private boolean isUCS = false;
    private int stringType = UniversalTag.PrintableString;
    private boolean hasDefaults = false;

    public ASN1StringMetadata() {
        hasDefaults = true;
    }

    public ASN1StringMetadata(ASN1String annotation) {
        this(annotation.name(), annotation.isUCS(), annotation.stringType());
    }

    public ASN1StringMetadata(String name,
                              boolean isUCS,
                              int stringType) {
        super(name);
        this.isUCS = isUCS;
        this.stringType = stringType;
    }

    public boolean isUCS() {
        return isUCS;
    }

    public int getStringType() {
        return stringType;
    }

    @Override
    public void setParentAnnotated(AnnotatedElement parent) {
        if (parent != null) {
            if (parent.isAnnotationPresent(ASN1String.class)) {
                ASN1String value = parent.getAnnotation(ASN1String.class);
                stringType = value.stringType();
            }
        }
    }

    public int encode(IASN1TypesEncoder encoder, Object object, OutputStream stream,
                      ElementInfo elementInfo) throws Exception {
        return encoder.encodeString(object, stream, elementInfo);
    }

    public DecodedObject decode(IASN1TypesDecoder decoder, DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception {
        return decoder.decodeString(decodedTag, objectClass, elementInfo, stream);
    }
}
