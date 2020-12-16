
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
@ASN1Sequence(name = "LaneAttributes", isSet = false)
public class LaneAttributes implements IASN1PreparedElement {

    @ASN1Element(name = "shareWith", isOptional = true, hasTag = false, hasDefaultValue = false)
    private LaneSharing shareWith = null;

    @ASN1Element(name = "laneType", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneTypeAttributes laneType = null;


    public LaneSharing getShareWith() {
        return this.shareWith;
    }


    public boolean isShareWithPresent() {
        return this.shareWith != null;
    }


    public void setShareWith(LaneSharing value) {
        this.shareWith = value;
    }


    public LaneTypeAttributes getLaneType() {
        return this.laneType;
    }


    public void setLaneType(LaneTypeAttributes value) {
        this.laneType = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(LaneAttributes.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            