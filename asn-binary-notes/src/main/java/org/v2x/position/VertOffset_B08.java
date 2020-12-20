package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "VertOffset_B08")
public class VertOffset_B08 {

    @ASN1Integer(name = "VertOffset-B08")
    @ASN1ValueRangeConstraint(
            min = -128L,
            max = 127L
    )
    private Integer value;

    public VertOffset_B08() {
    }

    public VertOffset_B08(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            