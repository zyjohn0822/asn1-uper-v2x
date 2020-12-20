package org.v2x.map.lane;


import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "LaneAttributes_Vehicle")
public class LaneAttributes_Vehicle {

    @ASN1BitString(name = "LaneAttributes-Vehicle")
    @ASN1SizeConstraint(max = 8L)
    private BitString value = null;

    public LaneAttributes_Vehicle() {
    }

    public LaneAttributes_Vehicle(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }
}
            