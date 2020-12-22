package org.v2x.time;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "TimeMark")
public class TimeMark {

    @ASN1Integer(name = "TimeMark")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 36001L
    )
    private Integer value;

    public TimeMark() {
    }

    public TimeMark(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return "" + value;
    }
}
            