
package org.v2x.rsi;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.position.PositionOffsetLLV;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "RTSData", isSet = false)
public class RTSData implements IASN1PreparedElement {
    @ASN1Integer(name = "")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 255L
    )
    @ASN1Element(name = "rtsId", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Integer rtsId = null;

    @ASN1Element(name = "signType", isOptional = false, hasTag = false, hasDefaultValue = false)
    private SignType signType = null;

    @ASN1Element(name = "signPos", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PositionOffsetLLV signPos = null;

    @ASN1Element(name = "description", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Description description = null;

    @ASN1Element(name = "timeDetails", isOptional = true, hasTag = false, hasDefaultValue = false)
    private RSITimeDetails timeDetails = null;

    @ASN1Element(name = "priority", isOptional = true, hasTag = false, hasDefaultValue = false)
    private RSIPriority priority = null;

    @ASN1Element(name = "referencePaths", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ReferencePathList referencePaths = null;

    @ASN1Element(name = "referenceLinks", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ReferenceLinkList referenceLinks = null;


    public Integer getRtsId() {
        return this.rtsId;
    }


    public void setRtsId(Integer value) {
        this.rtsId = value;
    }


    public SignType getSignType() {
        return this.signType;
    }


    public void setSignType(SignType value) {
        this.signType = value;
    }


    public PositionOffsetLLV getSignPos() {
        return this.signPos;
    }


    public boolean isSignPosPresent() {
        return this.signPos != null;
    }


    public void setSignPos(PositionOffsetLLV value) {
        this.signPos = value;
    }


    public Description getDescription() {
        return this.description;
    }


    public boolean isDescriptionPresent() {
        return this.description != null;
    }


    public void setDescription(Description value) {
        this.description = value;
    }


    public RSITimeDetails getTimeDetails() {
        return this.timeDetails;
    }


    public boolean isTimeDetailsPresent() {
        return this.timeDetails != null;
    }


    public void setTimeDetails(RSITimeDetails value) {
        this.timeDetails = value;
    }


    public RSIPriority getPriority() {
        return this.priority;
    }


    public boolean isPriorityPresent() {
        return this.priority != null;
    }


    public void setPriority(RSIPriority value) {
        this.priority = value;
    }


    public ReferencePathList getReferencePaths() {
        return this.referencePaths;
    }


    public boolean isReferencePathsPresent() {
        return this.referencePaths != null;
    }


    public void setReferencePaths(ReferencePathList value) {
        this.referencePaths = value;
    }


    public ReferenceLinkList getReferenceLinks() {
        return this.referenceLinks;
    }


    public boolean isReferenceLinksPresent() {
        return this.referenceLinks != null;
    }


    public void setReferenceLinks(ReferenceLinkList value) {
        this.referenceLinks = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(RTSData.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            