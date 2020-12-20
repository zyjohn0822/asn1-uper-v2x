package org.v2x.position;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "Longitude")
public class Longitude {

    @ASN1Integer(name = "Longitude")
    @ASN1ValueRangeConstraint(
            min = -1799999999L,
            max = 1800000001L
    )
    private Integer value;

    public Longitude() {
    }

    public Longitude(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            