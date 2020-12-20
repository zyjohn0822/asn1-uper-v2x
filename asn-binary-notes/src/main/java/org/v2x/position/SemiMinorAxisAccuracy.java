package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "SemiMinorAxisAccuracy")
public class SemiMinorAxisAccuracy {

    @ASN1Integer(name = "SemiMinorAxisAccuracy")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 255L
    )
    private Integer value;

    public SemiMinorAxisAccuracy() {
    }

    public SemiMinorAxisAccuracy(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            