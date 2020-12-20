package org.v2x.position;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "Elevation")
public class Elevation {

    @ASN1Integer(name = "Elevation")
    @ASN1ValueRangeConstraint(
            min = -4096L,
            max = 61439L
    )
    private Integer value;

    public Elevation() {
    }

    public Elevation(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            