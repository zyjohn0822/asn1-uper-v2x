package org.v2x.map.lane;


import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "LaneAttributes_Crosswalk")
public class LaneAttributes_Crosswalk {

    @ASN1BitString(name = "LaneAttributes-Crosswalk")
    @ASN1SizeConstraint(max = 16L)
    private BitString value = null;

    public LaneAttributes_Crosswalk() {
    }

    public LaneAttributes_Crosswalk(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }
}
            