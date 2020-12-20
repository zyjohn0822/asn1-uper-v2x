package org.v2x.position;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "OffsetLL_B14")
public class OffsetLL_B14 {

    @ASN1Integer(name = "OffsetLL-B14")
    @ASN1ValueRangeConstraint(
            min = -8192L,
            max = 8191L
    )
    private Integer value;

    public OffsetLL_B14() {
    }

    public OffsetLL_B14(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            