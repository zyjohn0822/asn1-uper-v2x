
package org.v2x.map.lane;


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
@ASN1BoxedType(name = "LaneList")
public class LaneList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "LaneList", isSetOf = false)
    private java.util.Collection<Lane> value = null;

    public LaneList() {
    }

    public LaneList(java.util.Collection<Lane> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<Lane> value) {
        this.value = value;
    }

    public java.util.Collection<Lane> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Lane>());
    }

    public void add(Lane item) {
        value.add(item);
    }
    @Override
    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(LaneList.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            