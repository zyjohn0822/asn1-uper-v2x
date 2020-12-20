package org.v2x.spat;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;

/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "PhaseID")
public class PhaseID {

    @ASN1Integer(name = "PhaseID")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 255L
    )
    private Integer value;

    public PhaseID() {
    }

    public PhaseID(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            