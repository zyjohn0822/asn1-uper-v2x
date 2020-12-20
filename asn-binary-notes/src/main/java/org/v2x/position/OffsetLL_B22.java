package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "OffsetLL_B22")
public class OffsetLL_B22 {

    @ASN1Integer(name = "OffsetLL-B22")
    @ASN1ValueRangeConstraint(
            min = -2097152L,
            max = 2097151L
    )
    private Integer value;

    public OffsetLL_B22() {
    }

    public OffsetLL_B22(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
            