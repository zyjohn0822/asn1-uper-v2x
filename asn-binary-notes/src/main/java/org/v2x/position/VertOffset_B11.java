package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */

@ASN1BoxedType(name = "VertOffset_B11")
public class VertOffset_B11 {

    @ASN1Integer(name = "VertOffset-B11")
    @ASN1ValueRangeConstraint(
            min = -1024L,
            max = 1023L
    )
    private Integer value;

    public VertOffset_B11() {
    }

    public VertOffset_B11(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            