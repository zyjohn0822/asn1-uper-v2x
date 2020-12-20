package org.v2x.vehicle;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "FuelType")
public class FuelType {

    @ASN1Integer(name = "FuelType")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 15L
    )
    private Integer value;

    public FuelType() {
    }

    public FuelType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            