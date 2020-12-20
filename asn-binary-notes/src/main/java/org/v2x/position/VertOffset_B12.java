package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "VertOffset_B12")
public class VertOffset_B12 {

    @ASN1Integer(name = "VertOffset-B12")
    @ASN1ValueRangeConstraint(
            min = -2048L,
            max = 2047L
    )
    private Integer value;

    public VertOffset_B12() {
    }

    public VertOffset_B12(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            