package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.PathPrediction.Confidence;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * RTEData ::= SEQUENCE {<br/>
 * rteId INTEGER (0..255),<br/>
 * -- local ID of this rte information set by RSU<br/>
 * eventType EventType,<br/>
 * -- Type of event, according to China GB/T 29100-2012<br/>
 * eventSource EventSource,<br/>
 * eventPos PositionOffsetLLV OPTIONAL,<br/>
 * -- Position of this event, if exists<br/>
 * eventRadius Radius OPTIONAL,<br/>
 * -- Radius of this event, if exists<br/>
 * description Description OPTIONAL,<br/>
 * -- Additional description to this event<br/>
 * timeDetails RSITimeDetails OPTIONAL,<br/>
 * -- Start time or end time when this event is active<br/>
 * priority RSIPriority OPTIONAL,<br/>
 * -- the urgency of this RSI data, a relative<br/>
 * -- degree of merit compared with other RSI data<br/>
 * referencePaths ReferencePathList OPTIONAL,<br/>
 * -- Related paths of this traffic event<br/>
 * referenceLinks ReferenceLinkList OPTIONAL,<br/>
 * -- Related links of this traffic event<br/>
 * eventConfidence Confidence OPTIONAL,<br/>
 * -- indicate the event confidence set by event source<br/>
 * -- the probability/confidence of the detected event<br/>
 * -- being truly extent at a certain place,<br/>
 * -- to help vehicle determine whether to trust the received information.<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/22  19:03
 */
@Getter
@Setter
@Sequence
@HasExtensionMarker
public class RTEData {
    @Component(0)
    public RteId id;
    @Component(1)
    public EventType eventType;
    @Component(2)
    public EventSource eventSource;
    @Component(3)
    @Asn1Optional
    public PositionOffsetLLV eventPos;
    @Component(4)
    @Asn1Optional
    public Radius eventRadius;
    @Component(5)
    @Asn1Optional
    public Description description;
    @Component(6)
    @Asn1Optional
    public RSITimeDetails timeDetails;
    @Component(7)
    @Asn1Optional
    public RSIPriority priority;
    @Component(8)
    @Asn1Optional
    public ReferencePathList referencePaths;
    @Component(9)
    @Asn1Optional
    public ReferenceLinkList referenceLinks;
    @Component(10)
    @Asn1Optional
    public Confidence eventConfidence;

    public RTEData() {
    }

    public RTEData(RteId id,
                   EventType eventType,
                   EventSource eventSource,
                   PositionOffsetLLV eventPos,
                   Radius eventRadius,
                   Description description,
                   RSITimeDetails timeDetails,
                   RSIPriority priority,
                   ReferencePathList referencePaths,
                   ReferenceLinkList referenceLinks,
                   Confidence eventConfidence) {
        this.id = id;
        this.eventType = eventType;
        this.eventSource = eventSource;
        this.eventPos = eventPos;
        this.eventRadius = eventRadius;
        this.description = description;
        this.timeDetails = timeDetails;
        this.priority = priority;
        this.referencePaths = referencePaths;
        this.referenceLinks = referenceLinks;
        this.eventConfidence = eventConfidence;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"eventType\":")
                .append(eventType);
        sb.append(",\"eventSource\":")
                .append(eventSource);
        sb.append(",\"eventPos\":")
                .append(eventPos);
        sb.append(",\"eventRadius\":")
                .append(eventRadius);
        sb.append(",\"description\":")
                .append(description);
        sb.append(",\"timeDetails\":")
                .append(timeDetails);
        sb.append(",\"priority\":")
                .append(priority);
        sb.append(",\"referencePaths\":")
                .append(referencePaths);
        sb.append(",\"referenceLinks\":")
                .append(referenceLinks);
        sb.append(",\"eventConfidence\":")
                .append(eventConfidence);
        sb.append('}');
        return sb.toString();
    }

    /**
     * EventSource ::= ENUMERATED {<br/>
     * unknown(0),	-- 0 Unknown<br/>
     * police(1),	-- 1 traffic police<br/>
     * government(2),	-- 2 govenment<br/>
     * meteorological(3), -- 3 meteorological department<br/>
     * internet(4),	-- 4 internet services<br/>
     * detection(5),	-- 5 local detection<br/>
     * ...<br/>
     * }<br/>
     */
    @HasExtensionMarker
    public enum EventSource {
        unknown(0),
        police(1),
        government(2),
        meteorological(3),
        internet(4),
        detection(5);

        private final int value;

        EventSource(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * rteId INTEGER (0..255)
     */
    @IntRange(minValue = 0, maxValue = 255)
    public static class RteId extends Asn1Integer {
        public RteId() {
            this(0);
        }

        public RteId(int value) {
            super(value);
        }
    }

    /**
     * EventType ::= INTEGER (0..65535)<br/>
     * -- Traffic event type according to China GB/T 29100-2012<br/>
     */
    @IntRange(minValue = 0, maxValue = 65535)
    public static class EventType extends Asn1Integer {
        public EventType() {
            this(0);
        }

        public EventType(int value) {
            super(value);
        }
    }
}
