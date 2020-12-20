package org.v2x.map.lane;

import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "LaneSharing")
public class LaneSharing {

    @ASN1BitString(name = "LaneSharing")
    @ASN1SizeConstraint(max = 10L)
    private BitString value = null;

    public LaneSharing() {
    }

    public LaneSharing(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }
}
            