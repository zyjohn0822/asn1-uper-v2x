
package org.v2x.map.point;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1SequenceOf;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1BoxedType(name = "PointList")
public class PointList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "PointList", isSetOf = false)
    private java.util.Collection<RoadPoint> value = null;

    public PointList() {
    }

    public PointList(java.util.Collection<RoadPoint> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<RoadPoint> value) {
        this.value = value;
    }

    public java.util.Collection<RoadPoint> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<RoadPoint>());
    }

    public void add(RoadPoint item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PointList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            