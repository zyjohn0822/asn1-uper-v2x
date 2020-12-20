package org.v2x.map.lane;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "LaneAttributes", isSet = false)
public class LaneAttributes {

    @ASN1Element(name = "shareWith", isOptional = true, hasTag = false, hasDefaultValue = false)
    private LaneSharing shareWith = null;

    @ASN1Element(name = "laneType", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneTypeAttributes laneType = null;


    public LaneSharing getShareWith() {
        return this.shareWith;
    }

    public void setShareWith(LaneSharing value) {
        this.shareWith = value;
    }

    public boolean isShareWithPresent() {
        return this.shareWith != null;
    }

    public LaneTypeAttributes getLaneType() {
        return this.laneType;
    }


    public void setLaneType(LaneTypeAttributes value) {
        this.laneType = value;
    }

}
            