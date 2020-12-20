package org.v2x.position;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "OffsetLL_B12")
public class OffsetLL_B12 {

    @ASN1Integer(name = "OffsetLL-B12")
    @ASN1ValueRangeConstraint(
            min = -2048L,
            max = 2047L
    )
    private Integer value;

    public OffsetLL_B12() {
    }

    public OffsetLL_B12(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            