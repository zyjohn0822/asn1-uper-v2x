package org.v2x.map.speedlimit;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "SpeedLimitList")
public class SpeedLimitList {

    @ASN1SequenceOf(name = "SpeedLimitList", isSetOf = false)
    private java.util.Collection<RegulatorySpeedLimit> value = null;

    public SpeedLimitList() {
    }

    public SpeedLimitList(java.util.Collection<RegulatorySpeedLimit> value) {
        setValue(value);
    }

    public java.util.Collection<RegulatorySpeedLimit> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<RegulatorySpeedLimit> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<RegulatorySpeedLimit>());
    }

    public void add(RegulatorySpeedLimit item) {
        value.add(item);
    }


}
            