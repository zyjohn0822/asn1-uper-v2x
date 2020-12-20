package org.v2x.map.lane;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "LaneID")
public class LaneID {

    @ASN1Integer(name = "LaneID")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 255L
    )
    private Integer value;

    public LaneID() {
    }

    public LaneID(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            