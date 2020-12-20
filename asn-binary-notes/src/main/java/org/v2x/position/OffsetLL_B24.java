package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "OffsetLL_B24")
public class OffsetLL_B24 {

    @ASN1Integer(name = "OffsetLL-B24")
    @ASN1ValueRangeConstraint(
            min = -8388608L,
            max = 8388607L
    )
    private Integer value;

    public OffsetLL_B24() {
    }

    public OffsetLL_B24(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            