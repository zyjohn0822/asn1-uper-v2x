package org.v2x.rsi;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.v2x.position.PositionOffsetLLV;
import org.v2x.vehicle.Confidence;

/**
 * @author zhangyong
 */
@ASN1Sequence(name = "RTEData", isSet = false)
public class RTEData {
    @ASN1Integer(name = "")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 255L
    )
    @ASN1Element(name = "rteId", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Integer rteId = null;

    @ASN1Element(name = "eventType", isOptional = false, hasTag = false, hasDefaultValue = false)
    private EventType eventType = null;

    @ASN1Element(name = "eventSource", isOptional = false, hasTag = false, hasDefaultValue = false)
    private EventSource eventSource = null;

    @ASN1Element(name = "eventPos", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PositionOffsetLLV eventPos = null;

    @ASN1Element(name = "eventRadius", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Radius eventRadius = null;

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

    @ASN1Element(name = "eventConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Confidence eventConfidence = null;


    public Integer getRteId() {
        return this.rteId;
    }


    public void setRteId(Integer value) {
        this.rteId = value;
    }


    public EventType getEventType() {
        return this.eventType;
    }


    public void setEventType(EventType value) {
        this.eventType = value;
    }


    public EventSource getEventSource() {
        return this.eventSource;
    }


    public void setEventSource(EventSource value) {
        this.eventSource = value;
    }


    public PositionOffsetLLV getEventPos() {
        return this.eventPos;
    }

    public void setEventPos(PositionOffsetLLV value) {
        this.eventPos = value;
    }

    public boolean isEventPosPresent() {
        return this.eventPos != null;
    }

    public Radius getEventRadius() {
        return this.eventRadius;
    }

    public void setEventRadius(Radius value) {
        this.eventRadius = value;
    }

    public boolean isEventRadiusPresent() {
        return this.eventRadius != null;
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

    public Confidence getEventConfidence() {
        return this.eventConfidence;
    }

    public void setEventConfidence(Confidence value) {
        this.eventConfidence = value;
    }

    public boolean isEventConfidencePresent() {
        return this.eventConfidence != null;
    }

}
            