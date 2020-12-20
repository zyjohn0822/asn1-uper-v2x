package org.v2x.map.lane;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "ConnectingLane", isSet = false)
public class ConnectingLane {

    @ASN1Element(name = "lane", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneID lane = null;

    @ASN1Element(name = "maneuver", isOptional = true, hasTag = false, hasDefaultValue = false)
    private AllowedManeuvers maneuver = null;


    public LaneID getLane() {
        return this.lane;
    }


    public void setLane(LaneID value) {
        this.lane = value;
    }


    public AllowedManeuvers getManeuver() {
        return this.maneuver;
    }

    public void setManeuver(AllowedManeuvers value) {
        this.maneuver = value;
    }

    public boolean isManeuverPresent() {
        return this.maneuver != null;
    }

}
            