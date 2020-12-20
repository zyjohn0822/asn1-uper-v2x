package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "Latitude")
public class Latitude {

    @ASN1Integer(name = "Latitude")
    @ASN1ValueRangeConstraint(
            min = -900000000L,
            max = 900000001L
    )
    private Integer value;

    public Latitude() {
    }

    public Latitude(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            