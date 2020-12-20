package org.v2x.time;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */

@ASN1BoxedType(name = "DHour")
public class DHour {

    @ASN1Integer(name = "DHour")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 24L
    )
    private Integer value;

    public DHour() {
    }

    public DHour(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
            