package org.v2x.motion;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "CoarseHeading")
public class CoarseHeading {

    @ASN1Integer(name = "CoarseHeading")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 240L
    )
    private Integer value;

    public CoarseHeading() {
    }

    public CoarseHeading(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            