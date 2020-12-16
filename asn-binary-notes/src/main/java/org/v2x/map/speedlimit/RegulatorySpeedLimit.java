
package org.v2x.map.speedlimit;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.motion.Speed;

/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "RegulatorySpeedLimit", isSet = false)
public class RegulatorySpeedLimit implements IASN1PreparedElement {

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


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(RegulatorySpeedLimit.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            