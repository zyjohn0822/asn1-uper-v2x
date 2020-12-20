package org.v2x.rsi;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "ReferencePathList")
public class ReferencePathList {

    @ASN1SequenceOf(name = "ReferencePathList", isSetOf = false)
    private java.util.Collection<ReferencePath> value = null;

    public ReferencePathList() {
    }

    public ReferencePathList(java.util.Collection<ReferencePath> value) {
        setValue(value);
    }

    public java.util.Collection<ReferencePath> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<ReferencePath> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<ReferencePath>());
    }

    public void add(ReferencePath item) {
        value.add(item);
    }

}
            