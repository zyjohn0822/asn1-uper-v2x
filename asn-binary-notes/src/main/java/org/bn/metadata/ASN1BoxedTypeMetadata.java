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

import org.bn.annotations.ASN1BoxedType;
import org.bn.coders.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/**
 * @author zhangyong
 */
public class ASN1BoxedTypeMetadata extends ASN1FieldMetadata {
    private Field valueField;
    private ASN1PreparedElementData valueFieldMeta;

    public ASN1BoxedTypeMetadata(String name) {
        super(name);
    }

    public ASN1BoxedTypeMetadata(Class objClass, ASN1BoxedType annotation) {
        this(annotation.name());
        setupValueField(objClass);
    }

    public void setupValueField(Class objClass) {
        try {
            valueField = objClass.getDeclaredField("value");
            valueFieldMeta = new ASN1PreparedElementData(objClass, valueField);
        } catch (NoSuchFieldException e) {
            // TODO
        }
    }

    public int encode(IASN1TypesEncoder encoder, Object object, OutputStream stream,
                      ElementInfo elementInfo) throws Exception {
        //return encoder.encodeBoxedType(object, stream, elementInfo);
        Object result = null;
        ASN1ElementMetadata saveInfo = elementInfo.getPreparedASN1ElementInfo();
        elementInfo.setPreparedInfo(valueFieldMeta);
        if (!CoderUtils.isNullField(valueField, elementInfo)) {
            result = encoder.invokeGetterMethodForField(valueField, object, elementInfo);
        }
        if (saveInfo != null) {
            if (!saveInfo.hasTag()
                    && elementInfo.hasPreparedASN1ElementInfo()
                    && elementInfo.getPreparedASN1ElementInfo().hasTag()) {
                ASN1ElementMetadata elData = new ASN1ElementMetadata(
                        saveInfo.getName(),
                        saveInfo.isOptional(),
                        elementInfo.getPreparedASN1ElementInfo().hasTag(),
                        elementInfo.getPreparedASN1ElementInfo().isImplicitTag(),
                        elementInfo.getPreparedASN1ElementInfo().getTagClass(),
                        elementInfo.getPreparedASN1ElementInfo().getTag(),
                        saveInfo.hasDefaultValue()
                );
                elementInfo.setPreparedASN1ElementInfo(elData);
            } else {
                elementInfo.setPreparedASN1ElementInfo(saveInfo);
            }
        }
        return valueFieldMeta.getTypeMetadata().encode(encoder, result, stream, elementInfo);
    }

    public DecodedObject decode(IASN1TypesDecoder decoder, DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception {
        //return decoder.decodeBoxedType(decodedTag,objectClass,elementInfo,stream);
        IASN1PreparedElementData saveInfo = elementInfo.getPreparedInfo();
        IASN1PreparedElement instance = (IASN1PreparedElement) elementInfo.getPreparedInstance();
        ASN1ElementMetadata saveElemInfo = elementInfo.getPreparedASN1ElementInfo();
        elementInfo.setPreparedInfo(valueFieldMeta);
        elementInfo.setGenericInfo(valueField.getGenericType());
        if (elementInfo.getPreparedInfo().isMemberClass()) {
            elementInfo.setParentObject(elementInfo.getPreparedInstance());
        }

        if (saveElemInfo != null) {
            if (!saveElemInfo.hasTag()
                    && elementInfo.hasPreparedASN1ElementInfo()
                    && elementInfo.getPreparedASN1ElementInfo().hasTag()) {
                ASN1ElementMetadata elData = new ASN1ElementMetadata(
                        saveElemInfo.getName(),
                        saveElemInfo.isOptional(),
                        elementInfo.getPreparedASN1ElementInfo().hasTag(),
                        elementInfo.getPreparedASN1ElementInfo().isImplicitTag(),
                        elementInfo.getPreparedASN1ElementInfo().getTagClass(),
                        elementInfo.getPreparedASN1ElementInfo().getTag(),
                        saveElemInfo.hasDefaultValue()
                );
                elementInfo.setPreparedASN1ElementInfo(elData);
            } else {
                elementInfo.setPreparedASN1ElementInfo(saveElemInfo);
            }

        }
        DecodedObject decodedResult = valueFieldMeta.getTypeMetadata().decode(decoder, decodedTag, valueField.getType(), elementInfo, stream);
        if (decodedResult != null) {
            if (!CoderUtils.isNullField(valueField, elementInfo)) {
                decoder.invokeSetterMethodForField(valueField, instance, decodedResult.getValue(), elementInfo);
            }
        }
        elementInfo.setPreparedInfo(saveInfo);
        elementInfo.setPreparedInstance(instance);
        elementInfo.setPreparedASN1ElementInfo(saveElemInfo);

        if (decodedResult != null) {
            return new DecodedObject(instance, decodedResult.getSize());
        } else {
            return decodedResult;
        }
    }

}
