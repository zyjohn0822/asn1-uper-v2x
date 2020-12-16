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

import java.lang.reflect.Field;

import org.bn.metadata.ASN1ElementMetadata;
import org.bn.metadata.ASN1Metadata;
import org.bn.metadata.constraints.IASN1ConstraintMetadata;

public interface IASN1PreparedElementData {
    ASN1Metadata getTypeMetadata();
    
    IASN1ConstraintMetadata getConstraint();    
    boolean hasConstraint();
    
    
    Field[] getFields();
    Field getField(int index);
    ASN1PreparedElementData getFieldMetadata(int index);
    
    Field getValueField();
    ASN1PreparedElementData getValueMetadata();    
    
    ASN1ElementMetadata getASN1ElementInfo();
    boolean hasASN1ElementInfo();
    
    Object invokeSetterMethod(Object object, Object param) throws Exception;
    Object invokeDoSelectMethod(Object object, Object param) throws Exception;
    Object invokeGetterMethod(Object object, Object param) throws Exception;
    Object invokeIsSelectedMethod(Object object, Object param) throws Exception;
    
    boolean isMemberClass();
    Object newInstance() throws Exception;
}
