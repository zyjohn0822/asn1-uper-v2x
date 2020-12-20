package org.v2x.rsi;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "EventType")
public class EventType {

    @ASN1Integer(name = "EventType")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 65535L
    )
    private Integer value;

    public EventType() {
    }

    public EventType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            