package org.v2x.time;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "DDay")
public class DDay {

    @ASN1Integer(name = "DDay")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 31L
    )
    private Integer value;

    public DDay() {
    }

    public DDay(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            