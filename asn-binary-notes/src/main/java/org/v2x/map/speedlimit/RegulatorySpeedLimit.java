package org.v2x.map.speedlimit;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.motion.Speed;

/**
 * @author zhangyong
 */
@ASN1Sequence(name = "RegulatorySpeedLimit", isSet = false)
public class RegulatorySpeedLimit {

    @ASN1Element(name = "type", isOptional = false, hasTag = false, hasDefaultValue = false)
    private SpeedLimitType type = null;

    @ASN1Element(name = "speed", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Speed speed = null;


    public SpeedLimitType getType() {
        return this.type;
    }


    public void setType(SpeedLimitType value) {
        this.type = value;
    }


    public Speed getSpeed() {
        return this.speed;
    }


    public void setSpeed(Speed value) {
        this.speed = value;
    }

}
            