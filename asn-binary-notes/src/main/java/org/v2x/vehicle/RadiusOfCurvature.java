package org.v2x.vehicle;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "RadiusOfCurvature")
public class RadiusOfCurvature {

    @ASN1Integer(name = "RadiusOfCurvature")
    @ASN1ValueRangeConstraint(
            min = -32767L,
            max = 32767L
    )
    private Integer value;

    public RadiusOfCurvature() {
    }

    public RadiusOfCurvature(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            