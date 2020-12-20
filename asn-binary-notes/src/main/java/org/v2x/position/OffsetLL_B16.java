package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "OffsetLL_B16")
public class OffsetLL_B16 {

    @ASN1Integer(name = "OffsetLL-B16")
    @ASN1ValueRangeConstraint(
            min = -32768L,
            max = 32767L
    )
    private Integer value;

    public OffsetLL_B16() {
    }

    public OffsetLL_B16(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            