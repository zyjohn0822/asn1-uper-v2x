package org.v2x.map.node;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "RoadRegulatorID")
public class RoadRegulatorID {

    @ASN1Integer(name = "RoadRegulatorID")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 65535L
    )
    private Integer value;

    public RoadRegulatorID() {
    }

    public RoadRegulatorID(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            