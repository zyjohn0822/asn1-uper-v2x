package org.v2x.map.lane;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "LaneWidth")
public class LaneWidth {

    @ASN1Integer(name = "LaneWidth")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 32767L
    )
    private Integer value;

    public LaneWidth() {
    }

    public LaneWidth(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            