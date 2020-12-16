
package org.v2x.rsi;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1SequenceOf;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.position.PositionOffsetLLV;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1BoxedType(name = "PathPointList")
public class PathPointList implements IASN1PreparedElement {


    @ASN1SequenceOf(name = "PathPointList", isSetOf = false)
    private java.util.Collection<PositionOffsetLLV> value = null;

    public PathPointList() {
    }

    public PathPointList(java.util.Collection<PositionOffsetLLV> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<PositionOffsetLLV> value) {
        this.value = value;
    }

    public java.util.Collection<PositionOffsetLLV> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<PositionOffsetLLV>());
    }

    public void add(PositionOffsetLLV item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PathPointList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            