package org.v2x.acceleration;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "YawRate")
public class YawRate {

    @ASN1Integer(name = "YawRate")
    @ASN1ValueRangeConstraint(
            min = -32767L,
            max = 32767L
    )
    private Integer value;

    public YawRate() {
    }

    public YawRate(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            