package org.v2x.motion;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "Speed")
public class Speed {

    @ASN1Integer(name = "Speed")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 8191L
    )

    private Integer value;

    public Speed() {
    }

    public Speed(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            