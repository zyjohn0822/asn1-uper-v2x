package org.v2x.map.point;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.position.PositionOffsetLLV;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "RoadPoint", isSet = false)
public class RoadPoint {

    @ASN1Element(name = "posOffset", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PositionOffsetLLV posOffset = null;


    public PositionOffsetLLV getPosOffset() {
        return this.posOffset;
    }


    public void setPosOffset(PositionOffsetLLV value) {
        this.posOffset = value;
    }

}
            