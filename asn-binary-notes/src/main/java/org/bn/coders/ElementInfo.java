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

import java.lang.reflect.AnnotatedElement;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.bn.annotations.ASN1Element;
import org.bn.metadata.ASN1ElementMetadata;

public final class ElementInfo {
    private ASN1Element element;
    private AnnotatedElement  annotatedClass, parentAnnotated;
    private Type genericInfo;
    private Object parentObject;
    private IASN1PreparedElementData preparedInfo;
    private Object preparedInstance;
    private ASN1ElementMetadata preparedElementMetadata;
    private int maxAvailableLen = -1;

    public ElementInfo() {            
    }
       
    public ASN1Element getASN1ElementInfo() {
        return element;
    }

    public void setASN1ElementInfo(ASN1Element element) {
        this.element = element;
    }
    
    public void setASN1ElementInfoForClass(AnnotatedElement anElement) {
        this.element = anElement.getAnnotation(ASN1Element.class);
    }

    public AnnotatedElement  getAnnotatedClass() {
        return this.annotatedClass;
    }
    
    public void setAnnotatedClass(AnnotatedElement cls) {
        this.annotatedClass = cls;
    }
        
    public void setGenericInfo(Type info) {
        this.genericInfo = info;
    }
    
    public Type getGenericInfo() {
        return this.genericInfo;
    }

    public AnnotatedElement getParentAnnotated() {
        return parentAnnotated;
    }

    public void setParentAnnotated(AnnotatedElement parentAnnotated) {
        this.parentAnnotated = parentAnnotated;
    }

    public Object getParentObject() {
        return parentObject;
    }

    public void setParentObject(Object parentObject) {
        this.parentObject = parentObject;
    }

    public IASN1PreparedElementData getPreparedInfo() {
        return preparedInfo;
    }

    public void setPreparedInfo(IASN1PreparedElementData preparedInfo) {
        this.preparedInfo = preparedInfo;
        if(preparedInfo!=null) {
            setPreparedASN1ElementInfo(preparedInfo.getASN1ElementInfo());
        }       
    }
    
    public boolean hasPreparedInfo() {
        return this.preparedInfo !=null;
    }

    public Object getPreparedInstance() {
        return preparedInstance;
    }

    public void setPreparedInstance(Object preparedInstance) {
        this.preparedInstance = preparedInstance;
    }
    
    public boolean hasPreparedInstance() {
        return this.preparedInstance!=null;
    }
    
    public Field[] getFields(Class objClass) {
        if(hasPreparedInfo()) {
            return getPreparedInfo().getFields();
        }
        else
            return objClass.getDeclaredFields();
    }

    public ASN1ElementMetadata getPreparedASN1ElementInfo() {
        return preparedElementMetadata;
    }

    public void setPreparedASN1ElementInfo(ASN1ElementMetadata value) {
        this.preparedElementMetadata = value;
    }
    
    public boolean hasPreparedASN1ElementInfo() {
        return this.preparedElementMetadata != null;
    }

    public int getMaxAvailableLen() {
        return maxAvailableLen;
    }

    public void setMaxAvailableLen(int maxAvailableLen) {
        this.maxAvailableLen = maxAvailableLen;
    }
}
