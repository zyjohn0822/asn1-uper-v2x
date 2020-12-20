package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "OffsetLL_B18")
public class OffsetLL_B18 {

    @ASN1Integer(name = "OffsetLL-B18")
    @ASN1ValueRangeConstraint(
            min = -131072L,
            max = 131071L
    )
    private Integer value;

    public OffsetLL_B18() {
    }

    public OffsetLL_B18(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            