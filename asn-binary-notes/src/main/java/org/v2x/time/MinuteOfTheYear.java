package org.v2x.time;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "MinuteOfTheYear")
public class MinuteOfTheYear {

    @ASN1Integer(name = "MinuteOfTheYear")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 527040L
    )
    private Integer value;

    public MinuteOfTheYear() {
    }

    public MinuteOfTheYear(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            