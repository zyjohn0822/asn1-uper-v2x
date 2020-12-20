package org.v2x.map.lane;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "LaneList")
public class LaneList {

    @ASN1SequenceOf(name = "LaneList", isSetOf = false)
    private java.util.Collection<Lane> value = null;

    public LaneList() {
    }

    public LaneList(java.util.Collection<Lane> value) {
        setValue(value);
    }

    public java.util.Collection<Lane> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<Lane> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Lane>());
    }

    public void add(Lane item) {
        value.add(item);
    }

}
            