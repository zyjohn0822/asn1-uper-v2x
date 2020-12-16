
package org.v2x.map.speedlimit;

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
@ASN1BoxedType(name = "SpeedLimitList")
public class SpeedLimitList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "SpeedLimitList", isSetOf = false)
    private java.util.Collection<RegulatorySpeedLimit> value = null;

    public SpeedLimitList() {
    }

    public SpeedLimitList(java.util.Collection<RegulatorySpeedLimit> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<RegulatorySpeedLimit> value) {
        this.value = value;
    }

    public java.util.Collection<RegulatorySpeedLimit> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<RegulatorySpeedLimit>());
    }

    public void add(RegulatorySpeedLimit item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(SpeedLimitList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            