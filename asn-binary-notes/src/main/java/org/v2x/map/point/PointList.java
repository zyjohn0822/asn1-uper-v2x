package org.v2x.map.point;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "PointList")
public class PointList {

    @ASN1SequenceOf(name = "PointList", isSetOf = false)
    private java.util.Collection<RoadPoint> value = null;

    public PointList() {
    }

    public PointList(java.util.Collection<RoadPoint> value) {
        setValue(value);
    }

    public java.util.Collection<RoadPoint> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<RoadPoint> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<RoadPoint>());
    }

    public void add(RoadPoint item) {
        value.add(item);
    }

}
            