package org.v2x.vehicle;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "Confidence")
public class Confidence {

    @ASN1Integer(name = "Confidence")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 200L
    )
    private Integer value;

    public Confidence() {
    }

    public Confidence(Integer value) {
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
            