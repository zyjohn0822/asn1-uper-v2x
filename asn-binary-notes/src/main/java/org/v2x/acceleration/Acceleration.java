package org.v2x.acceleration;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "Acceleration")
public class Acceleration {

    @ASN1Integer(name = "Acceleration")
    @ASN1ValueRangeConstraint(
            min = -2000L,
            max = 2001L
    )
    private Integer value;

    public Acceleration() {
    }

    public Acceleration(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            