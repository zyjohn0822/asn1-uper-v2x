package org.v2x.rsi;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.v2x.position.PositionOffsetLLV;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "RTSData", isSet = false)
public class RTSData {
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

    public void setSignPos(PositionOffsetLLV value) {
        this.signPos = value;
    }

    public boolean isSignPosPresent() {
        return this.signPos != null;
    }

    public Description getDescription() {
        return this.description;
    }

    public void setDescription(Description value) {
        this.description = value;
    }

    public boolean isDescriptionPresent() {
        return this.description != null;
    }

    public RSITimeDetails getTimeDetails() {
        return this.timeDetails;
    }

    public void setTimeDetails(RSITimeDetails value) {
        this.timeDetails = value;
    }

    public boolean isTimeDetailsPresent() {
        return this.timeDetails != null;
    }

    public RSIPriority getPriority() {
        return this.priority;
    }

    public void setPriority(RSIPriority value) {
        this.priority = value;
    }

    public boolean isPriorityPresent() {
        return this.priority != null;
    }

    public ReferencePathList getReferencePaths() {
        return this.referencePaths;
    }

    public void setReferencePaths(ReferencePathList value) {
        this.referencePaths = value;
    }

    public boolean isReferencePathsPresent() {
        return this.referencePaths != null;
    }

    public ReferenceLinkList getReferenceLinks() {
        return this.referenceLinks;
    }

    public void setReferenceLinks(ReferenceLinkList value) {
        this.referenceLinks = value;
    }

    public boolean isReferenceLinksPresent() {
        return this.referenceLinks != null;
    }

}
            