
package org.v2x.map.link;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.map.lane.LaneList;
import org.v2x.map.lane.LaneWidth;
import org.v2x.map.node.DescriptiveName;
import org.v2x.map.node.NodeReferenceID;
import org.v2x.map.point.PointList;
import org.v2x.map.speedlimit.SpeedLimitList;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "Link", isSet = false)
public class Link implements IASN1PreparedElement {

    @ASN1Element(name = "name", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DescriptiveName name = null;

    @ASN1Element(name = "upstreamNodeId", isOptional = false, hasTag = false, hasDefaultValue = false)
    private NodeReferenceID upstreamNodeId = null;

    @ASN1Element(name = "speedLimits", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SpeedLimitList speedLimits = null;

    @ASN1Element(name = "linkWidth", isOptional = true, hasTag = false, hasDefaultValue = false)
    private LaneWidth linkWidth = null;

    @ASN1Element(name = "points", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PointList points = null;

    @ASN1Element(name = "movements", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MovementList movements = null;

    @ASN1Element(name = "lanes", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneList lanes = null;


    public DescriptiveName getName() {
        return this.name;
    }


    public boolean isNamePresent() {
        return this.name != null;
    }


    public void setName(DescriptiveName value) {
        this.name = value;
    }


    public NodeReferenceID getUpstreamNodeId() {
        return this.upstreamNodeId;
    }


    public void setUpstreamNodeId(NodeReferenceID value) {
        this.upstreamNodeId = value;
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


    public LaneWidth getLinkWidth() {
        return this.linkWidth;
    }


    public boolean isLinkWidthPresent() {
        return this.linkWidth != null;
    }


    public void setLinkWidth(LaneWidth value) {
        this.linkWidth = value;
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


    public MovementList getMovements() {
        return this.movements;
    }


    public boolean isMovementsPresent() {
        return this.movements != null;
    }


    public void setMovements(MovementList value) {
        this.movements = value;
    }


    public LaneList getLanes() {
        return this.lanes;
    }


    public void setLanes(LaneList value) {
        this.lanes = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Link.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            