package org.v2x.vehicle;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "VehicleHeight")
public class VehicleHeight {

    @ASN1Integer(name = "VehicleHeight")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 127L
    )
    private Integer value;

    public VehicleHeight() {
    }

    public VehicleHeight(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            