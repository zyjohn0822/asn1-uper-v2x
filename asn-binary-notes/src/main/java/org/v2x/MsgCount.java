package org.v2x;

import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;


@ASN1BoxedType(name = "MsgCount")
public class MsgCount {

    @ASN1Integer(name = "MsgCount")
    @ASN1ValueRangeConstraint(

            min = 0L,

            max = 127L

    )

    private Integer value;

    public MsgCount() {
    }

    public MsgCount(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
            