package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */

@ASN1BoxedType(name = "SemiMajorAxisOrientation")
public class SemiMajorAxisOrientation {

    @ASN1Integer(name = "SemiMajorAxisOrientation")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 65535L
    )
    private Integer value;

    public SemiMajorAxisOrientation() {
    }

    public SemiMajorAxisOrientation(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            