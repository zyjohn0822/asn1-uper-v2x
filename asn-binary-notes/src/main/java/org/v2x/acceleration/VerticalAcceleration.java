package org.v2x.acceleration;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "VerticalAcceleration")
public class VerticalAcceleration {

    @ASN1Integer(name = "VerticalAcceleration")
    @ASN1ValueRangeConstraint(
            min = -127L,
            max = 127L
    )
    private Integer value;

    public VerticalAcceleration() {
    }

    public VerticalAcceleration(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            