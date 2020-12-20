package org.v2x.rsi;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;
import org.v2x.position.PositionOffsetLLV;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "PathPointList")
public class PathPointList {


    @ASN1SequenceOf(name = "PathPointList", isSetOf = false)
    private java.util.Collection<PositionOffsetLLV> value = null;

    public PathPointList() {
    }

    public PathPointList(java.util.Collection<PositionOffsetLLV> value) {
        setValue(value);
    }

    public java.util.Collection<PositionOffsetLLV> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<PositionOffsetLLV> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<PositionOffsetLLV>());
    }

    public void add(PositionOffsetLLV item) {
        value.add(item);
    }

}
            