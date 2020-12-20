package org.v2x.time;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "DTimeOffset")
public class DTimeOffset {

    @ASN1Integer(name = "DTimeOffset")
    @ASN1ValueRangeConstraint(
            min = -720L,
            max = 721L
    )
    private Integer value;

    public DTimeOffset() {
    }

    public DTimeOffset(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            