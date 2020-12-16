
package org.v2x.map.lane;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "ConnectingLane", isSet = false)
public class ConnectingLane implements IASN1PreparedElement {

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


    public boolean isManeuverPresent() {
        return this.maneuver != null;
    }


    public void setManeuver(AllowedManeuvers value) {
        this.maneuver = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ConnectingLane.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            