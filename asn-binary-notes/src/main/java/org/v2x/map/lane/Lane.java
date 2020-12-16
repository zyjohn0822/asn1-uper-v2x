
package org.v2x.map.lane;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.map.point.PointList;
import org.v2x.map.speedlimit.SpeedLimitList;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "Lane", isSet = false)
public class Lane implements IASN1PreparedElement {

    @ASN1Element(name = "laneID", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneID laneID = null;

    @ASN1Element(name = "laneWidth", isOptional = true, hasTag = false, hasDefaultValue = false)
    private LaneWidth laneWidth = null;

    @ASN1Element(name = "laneAttributes", isOptional = true, hasTag = false, hasDefaultValue = false)
    private LaneAttributes laneAttributes = null;

    @ASN1Element(name = "maneuvers", isOptional = true, hasTag = false, hasDefaultValue = false)
    private AllowedManeuvers maneuvers = null;

    @ASN1Element(name = "connectsTo", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ConnectsToList connectsTo = null;

    @ASN1Element(name = "speedLimits", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SpeedLimitList speedLimits = null;

    @ASN1Element(name = "points", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PointList points = null;


    public LaneID getLaneID() {
        return this.laneID;
    }


    public void setLaneID(LaneID value) {
        this.laneID = value;
    }


    public LaneWidth getLaneWidth() {
        return this.laneWidth;
    }


    public boolean isLaneWidthPresent() {
        return this.laneWidth != null;
    }


    public void setLaneWidth(LaneWidth value) {
        this.laneWidth = value;
    }


    public LaneAttributes getLaneAttributes() {
        return this.laneAttributes;
    }


    public boolean isLaneAttributesPresent() {
        return this.laneAttributes != null;
    }


    public void setLaneAttributes(LaneAttributes value) {
        this.laneAttributes = value;
    }


    public AllowedManeuvers getManeuvers() {
        return this.maneuvers;
    }


    public boolean isManeuversPresent() {
        return this.maneuvers != null;
    }


    public void setManeuvers(AllowedManeuvers value) {
        this.maneuvers = value;
    }


    public ConnectsToList getConnectsTo() {
        return this.connectsTo;
    }


    public boolean isConnectsToPresent() {
        return this.connectsTo != null;
    }


    public void setConnectsTo(ConnectsToList value) {
        this.connectsTo = value;
    }


    public SpeedLimitList getSpeedLimits() {
        return this.speedLimits;
    }


    public boolean isSpeedLimitsPresent() {
        return this.speedLimits != null;
    }


    public void setSpeedLimits(SpeedLimitList value) {
        this.speedLimits = value;
    }


    public PointList getPoints() {
        return this.points;
    }


    public boolean isPointsPresent() {
        return this.points != null;
    }


    public void setPoints(PointList value) {
        this.points = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Lane.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            