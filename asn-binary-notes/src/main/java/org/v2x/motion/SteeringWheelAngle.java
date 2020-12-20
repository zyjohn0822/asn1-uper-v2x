package org.v2x.motion;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "SteeringWheelAngle")
public class SteeringWheelAngle {

    @ASN1Integer(name = "SteeringWheelAngle")
    @ASN1ValueRangeConstraint(
            min = -126L,
            max = 127L
    )
    private Integer value;

    public SteeringWheelAngle() {
    }

    public SteeringWheelAngle(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
            