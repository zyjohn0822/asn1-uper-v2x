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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import java.lang.reflect.Method;

import java.lang.reflect.Modifier;

import java.util.SortedMap;

import org.bn.annotations.*;
import org.bn.annotations.constraints.*;
import org.bn.metadata.*;
import org.bn.metadata.constraints.*;
import org.bn.types.*;

public final class ASN1PreparedElementData implements IASN1PreparedElementData {
    private ASN1Metadata typeMeta;
    private ASN1ElementMetadata elementInfo;
    
    private Field[] fields;
    private ASN1PreparedElementData[] fieldsMetadata;
    
    private Field valueField;
    private ASN1PreparedElementData valueFieldMetadata;
    private IASN1ConstraintMetadata constraint;
    
    private Method getterMethod = null;
    private Method setterMethod = null;
    private Method doSelectedMethod = null;
    private Method isSelectedMethod = null;
    private boolean memberClassFlag = false;
    private Constructor<?> newInstanceConstructor = null;
    private Class<?> newInstanceClass = null;
    
    public ASN1PreparedElementData(Class<?> objectClass) {
        setupMetadata(objectClass, objectClass);
        setupConstructed(objectClass);
        setupMemberFlag(objectClass);
        setInstanceFactoryInfo(objectClass);
    }
    
    public ASN1PreparedElementData(Class<?> parentClass, Field field) {
        setupMetadata(field, field.getType());
        setupAccessors(parentClass, field);
        setupMemberFlag(field.getType());
    }
        
    private void setupMetadata(AnnotatedElement annotated, Class<?> objectClass) {
        if( annotated.isAnnotationPresent(ASN1SequenceOf.class) ) {
            typeMeta = new ASN1SequenceOfMetadata( annotated.getAnnotation( ASN1SequenceOf.class), ((Field)annotated).getGenericType(), annotated ) ;
        }        
        else
        if( annotated.isAnnotationPresent(ASN1Sequence.class) ) {
            typeMeta = new ASN1SequenceMetadata( annotated.getAnnotation( ASN1Sequence.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1Choice.class) ) {
            typeMeta = new ASN1ChoiceMetadata( annotated.getAnnotation( ASN1Choice.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1Enum.class) ) {
            typeMeta = new ASN1EnumMetadata( annotated.getAnnotation( ASN1Enum.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1Boolean.class) ) {            
            typeMeta = new ASN1BooleanMetadata( annotated.getAnnotation( ASN1Boolean.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1Any.class) ) {
            typeMeta = new ASN1AnyMetadata( annotated.getAnnotation( ASN1Any.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1Integer.class) ) {
            typeMeta = new ASN1IntegerMetadata( annotated.getAnnotation( ASN1Integer.class) ) ;
        }        
        else
        if( annotated.isAnnotationPresent(ASN1Real.class) ) {
            typeMeta = new ASN1RealMetadata( annotated.getAnnotation( ASN1Real.class) ) ;
        }        
        else
        if( annotated.isAnnotationPresent(ASN1OctetString.class) ) {
            typeMeta = new ASN1OctetStringMetadata( annotated.getAnnotation( ASN1OctetString.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1BitString.class) || objectClass.equals(BitString.class) ) {
            typeMeta = new ASN1BitStringMetadata( annotated.getAnnotation( ASN1BitString.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1ObjectIdentifier.class) || objectClass.equals(ObjectIdentifier.class) ) {
            typeMeta = new ASN1ObjectIdentifierMetadata ( annotated.getAnnotation( ASN1ObjectIdentifier.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1String.class) ) {
            typeMeta = new ASN1StringMetadata( annotated.getAnnotation( ASN1String.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1Null.class) ) {
            typeMeta = new ASN1NullMetadata( annotated.getAnnotation( ASN1Null.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1BoxedType.class) ) {
            typeMeta = new ASN1BoxedTypeMetadata( objectClass, annotated.getAnnotation(ASN1BoxedType.class) ) ;
        }        
        else
        if( annotated.isAnnotationPresent(ASN1Element.class) ) {
            typeMeta = new ASN1ElementMetadata( annotated.getAnnotation( ASN1Element.class) ) ;
        }
        else
        if(objectClass.equals(String.class)) {
            typeMeta = new ASN1StringMetadata( ) ;
        }
        else
        if(objectClass.equals(Integer.class)) {
            typeMeta = new ASN1IntegerMetadata( ) ;
        }
        else
        if(objectClass.equals(Long.class)) {
            typeMeta = new ASN1IntegerMetadata( ) ;
        }
        else
        if(objectClass.equals(Double.class)) {
            typeMeta = new ASN1RealMetadata( ) ;
        }
        else        
        if(objectClass.equals(Boolean.class)) {
            typeMeta = new ASN1BooleanMetadata( ) ;
        }        
        else
        if(objectClass.equals(byte[].class)) {
            typeMeta = new ASN1OctetStringMetadata( ) ;
        }
        
        if ( annotated.isAnnotationPresent(ASN1Element.class) ) {
            elementInfo = new ASN1ElementMetadata( annotated.getAnnotation( ASN1Element.class) ) ;
        }
        
        setupConstrint(annotated);
    }

    public ASN1Metadata getTypeMetadata() {
        return typeMeta;
    }

    public ASN1ElementMetadata getASN1ElementInfo() {
        return elementInfo;
    }
    
    public void setASN1ElementInfo(ASN1ElementMetadata elementData) {
        this.elementInfo = elementData;
    }
    
    public boolean hasASN1ElementInfo() {
        return this.elementInfo != null;
    }

    public Field[] getFields() {
        return fields;
    }

    public Field getField(int index) {
        return fields[index];
    }

    public ASN1PreparedElementData getFieldMetadata(int index) {
        return fieldsMetadata[index];
    }

    private void setupConstructed(Class<?> objectClass) {
        int count = 0;
        Field srcFields[] = null;
        if(typeMeta !=null && typeMeta instanceof ASN1SequenceMetadata && ((ASN1SequenceMetadata)typeMeta).isSet()) {
            SortedMap<Integer,Field> fieldOrder = CoderUtils.getSetOrder(objectClass);            
            srcFields = new Field[0];
            srcFields = fieldOrder.values().toArray(srcFields);
            count = srcFields.length;
        }        
        else {
            srcFields = objectClass.getDeclaredFields();
            for(Field field: objectClass.getDeclaredFields()) {
                if(!field.getType().equals(IASN1PreparedElementData.class) && !field.isSynthetic() ) {                
                    count++;
                }
            }
        }
        fields = new Field[count];
        fieldsMetadata = new ASN1PreparedElementData[count];
        int idx=0;
        for(Field field: srcFields) {
            if(!field.getType().equals(IASN1PreparedElementData.class) && !field.isSynthetic()) {
                fields[idx] = field;
                fieldsMetadata[idx] = new ASN1PreparedElementData(objectClass, field);
                
                if(fields[idx].getName().equalsIgnoreCase("value")) {
                    setValueField(field, fieldsMetadata[idx]);
                }
                idx++;
            }            
        }
    }

    public void setValueField(Field valueField, ASN1PreparedElementData valueFieldMeta) {
        this.valueField = valueField;
        this.valueFieldMetadata = valueFieldMeta;
    }

    public Field getValueField() {
        return this.valueField;
    }
    
    public ASN1PreparedElementData getValueMetadata() {
        return this.valueFieldMetadata;
    }

    private void setupConstrint(AnnotatedElement annotated) {
        if( annotated.isAnnotationPresent(ASN1SizeConstraint.class) ) {
            constraint = new ASN1SizeConstraintMetadata( annotated.getAnnotation( ASN1SizeConstraint.class) ) ;
        }
        else
        if( annotated.isAnnotationPresent(ASN1ValueRangeConstraint.class) ) {
            constraint = new ASN1ValueRangeConstraintMetadata( annotated.getAnnotation( ASN1ValueRangeConstraint.class) ) ;
        }        
    }
    
    public IASN1ConstraintMetadata getConstraint() {
        return this.constraint;
    }
    
    
    public boolean hasConstraint() {
        return this.constraint != null;
    }

    private void setupAccessors(Class<?> objectClass, Field field) {
        try {
            doSelectedMethod = CoderUtils.findDoSelectMethodForField(field, objectClass, field.getType());
            doSelectedMethod.setAccessible(true);
        }
        catch (NoSuchMethodException e) {  e = null; }
        catch (SecurityException ex) { ex = null; }
        
        try {
            isSelectedMethod = CoderUtils.findIsSelectedMethodForField(field, objectClass);
            isSelectedMethod.setAccessible(true);
        }
        catch (NoSuchMethodException e) {  e = null; }
        catch (SecurityException ex) { ex = null; }

        try {
            getterMethod = CoderUtils.findGetterMethodForField(field, objectClass);
            getterMethod.setAccessible(true);
        }
        catch (NoSuchMethodException e) { e = null; }
        catch (SecurityException ex) { ex = null; }

        try {
            setterMethod = CoderUtils.findSetterMethodForField(field, objectClass, field.getType());
            setterMethod.setAccessible(true);
        }
        catch (NoSuchMethodException e) { e = null; }
        catch (SecurityException ex) { ex = null; }
        setInstanceFactoryInfo(field.getType());
    }
    
    public void setInstanceFactoryInfo(Class<?> objClass) {
        try {
            newInstanceClass = objClass;
            newInstanceConstructor = objClass.getDeclaredConstructor();
            newInstanceConstructor.setAccessible(true);            
        }
        catch (NoSuchMethodException e) { e = null; }
        catch (SecurityException ex) { ex = null; }        
    }

    public Object invokeSetterMethod(Object object, Object param) throws Exception {
        return setterMethod.invoke(object,param);
    }

    public Object invokeDoSelectMethod(Object object, Object param) throws Exception {
        return doSelectedMethod.invoke(object, param);
    }

    public Object invokeGetterMethod(Object object,Object param)  throws Exception {
        return getterMethod.invoke(object);
    }

    public Object invokeIsSelectedMethod(Object object, Object param) throws Exception {
        return isSelectedMethod.invoke(object);
    }

    public boolean isMemberClass() {
        return this.memberClassFlag;
    }

    protected void setupMemberFlag(Class<?> cls) {
        memberClassFlag = cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers());
    }
    
    public Object newInstance() throws Exception {
        if(newInstanceConstructor!=null)
            return newInstanceConstructor.newInstance();        
        else
            return newInstanceClass.newInstance();
    }
}
