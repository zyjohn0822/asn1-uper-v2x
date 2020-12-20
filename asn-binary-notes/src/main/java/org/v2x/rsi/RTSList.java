package org.v2x.rsi;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "RTSList")
public class RTSList {

    @ASN1SequenceOf(name = "RTSList", isSetOf = false)
    private java.util.Collection<RTSData> value = null;

    public RTSList() {
    }

    public RTSList(java.util.Collection<RTSData> value) {
        setValue(value);
    }

    public java.util.Collection<RTSData> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<RTSData> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<RTSData>());
    }

    public void add(RTSData item) {
        value.add(item);
    }


}
            