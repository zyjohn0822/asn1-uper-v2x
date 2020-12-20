package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */

@ASN1BoxedType(name = "VertOffset_B07")
public class VertOffset_B07 {

    @ASN1Integer(name = "VertOffset-B07")
    @ASN1ValueRangeConstraint(
            min = -64L,
            max = 63L
    )
    private Integer value;

    public VertOffset_B07() {
    }

    public VertOffset_B07(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            