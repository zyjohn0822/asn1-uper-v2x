package org.v2x.vehicle;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "VehicleWidth")
public class VehicleWidth {

    @ASN1Integer(name = "VehicleWidth")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 1023L
    )
    private Integer value;

    public VehicleWidth() {
    }

    public VehicleWidth(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            