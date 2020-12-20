package org.v2x.rsi;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;

/**
 * @author zhangyong
 */

@ASN1BoxedType(name = "RTEList")
public class RTEList {

    @ASN1SequenceOf(name = "RTEList", isSetOf = false)
    private java.util.Collection<RTEData> value = null;

    public RTEList() {
    }

    public RTEList(java.util.Collection<RTEData> value) {
        setValue(value);
    }

    public java.util.Collection<RTEData> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<RTEData> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<RTEData>());
    }

    public void add(RTEData item) {
        value.add(item);
    }

}
            