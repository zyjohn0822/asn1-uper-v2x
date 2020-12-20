package org.v2x.position;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "PositionConfidenceSet", isSet = false)
public class PositionConfidenceSet {

    @ASN1Element(name = "pos", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PositionConfidence pos = null;

    @ASN1Element(name = "elevation", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ElevationConfidence elevation = null;


    public PositionConfidence getPos() {
        return this.pos;
    }


    public void setPos(PositionConfidence value) {
        this.pos = value;
    }


    public ElevationConfidence getElevation() {
        return this.elevation;
    }

    public void setElevation(ElevationConfidence value) {
        this.elevation = value;
    }

    public boolean isElevationPresent() {
        return this.elevation != null;
    }

}
            