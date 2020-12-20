package org.v2x.time;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "TimeOffset")
public class TimeOffset {

    @ASN1Integer(name = "TimeOffset")
    @ASN1ValueRangeConstraint(
            min = 1L,
            max = 65535L
    )
    private Integer value;

    public TimeOffset() {
    }

    public TimeOffset(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            