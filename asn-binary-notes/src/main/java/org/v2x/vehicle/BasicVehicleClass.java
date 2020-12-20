package org.v2x.vehicle;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "BasicVehicleClass")
public class BasicVehicleClass {

    @ASN1Integer(name = "BasicVehicleClass")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 255L
    )
    private Integer value;

    public BasicVehicleClass() {
    }

    public BasicVehicleClass(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            