package org.v2x.vehicle;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "VehicleLength")
public class VehicleLength {

    @ASN1Integer(name = "VehicleLength")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 4095L
    )
    private Integer value;

    public VehicleLength() {
    }

    public VehicleLength(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            