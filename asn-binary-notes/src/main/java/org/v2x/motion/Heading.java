package org.v2x.motion;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;

/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "Heading")
public class Heading {

    @ASN1Integer(name = "Heading")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 28800L
    )
    private Integer value;

    public Heading() {
    }

    public Heading(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            