package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.DDateTime.DSecond;
import com.hisense.hiatmp.asn.v2x.basic.DDateTime.MinuteOfTheYear;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * IntersectionState ::= SEQUENCE {<br/>
 * intersectionId NodeReferenceID,<br/>
 * -- A globally unique value set, consisting of a<br/>
 * -- regionID and intersection ID assignment<br/>
 * -- provides a unique mapping to the MAP Node<br/>
 * status IntersectionStatusObject,<br/>
 * -- general status of the controller(s)<br/>
 * moy MinuteOfTheYear OPTIONAL,<br/>
 * -- Minute of current UTC year<br/>
 * -- used only with messages to be archived<br/>
 * timeStamp DSecond OPTIONAL,<br/>
 * -- the mSec point in the current UTC minute that<br/>
 * -- this message was constructed<br/>
 * timeConfidence TimeConfidence OPTIONAL,<br/>
 * -- indicate the time confidence of the above UTC time<br/>
 * phases PhaseList,<br/>
 * -- Each Movement is given in turn<br/>
 * -- and contains its signal phase state,<br/>
 * -- mapping to the lanes it applies to, and<br/>
 * -- point in time it will end, and it<br/>
 * -- may contain both active and future states<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/21  9:35
 */
@Getter
@Setter
@Sequence
@HasExtensionMarker
public class IntersectionState {
    @Component(0)
    public NodeReferenceID intersectionId;
    @Component(1)
    public IntersectionStatusObject status;
    @Asn1Optional
    @Component(2)
    public MinuteOfTheYear moy;
    @Asn1Optional
    @Component(3)
    public DSecond timestamp;
    @Asn1Optional
    @Component(4)
    public TimeConfidence timeConfidence;
    @Component(5)
    public PhaseList phases;

    public IntersectionState() {
    }

    public IntersectionState(NodeReferenceID intersectionId,
                             IntersectionStatusObject status,
                             MinuteOfTheYear moy,
                             DSecond timestamp,
                             TimeConfidence timeConfidence,
                             PhaseList phases) {
        this.intersectionId = intersectionId;
        this.status = status;
        this.moy = moy;
        this.timestamp = timestamp;
        this.timeConfidence = timeConfidence;
        this.phases = phases;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"intersectionId\":")
                .append(intersectionId);
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"moy\":")
                .append(moy);
        sb.append(",\"timestamp\":")
                .append(timestamp);
        sb.append(",\"timeConfidence\":")
                .append(timeConfidence);
        sb.append(",\"phases\":")
                .append(phases);
        sb.append('}');
        return sb.toString();
    }

    /**
     * IntersectionStatusObject ::= BIT STRING {<br/>
     * manualControlIsEnabled (0),<br/>
     * -- Timing reported is per programmed values, etc. but person<br/>
     * -- at cabinet can manually request that certain intervals are<br/>
     * -- terminated early (e.g. green).<br/>
     * stopTimeIsActivated (1),<br/>
     * -- And all counting/timing has stopped.<br/>
     * failureFlash (2),<br/>
     * -- Above to be used for any detected hardware failures,<br/>
     * -- e.g. conflict monitor as well as for police flash<br/>
     * preemptIsActive (3),<br/>
     * signalPriorityIsActive (4),<br/>
     * -- Additional states<br/>
     * fixedTimeOperation (5),<br/>
     * -- Schedule of signals is based on time only<br/>
     * -- (i.e. the state can be calculated)<br/>
     * trafficDependentOperation (6),<br/>
     * -- Operation is based on different levels of traffic parameters<br/>
     * -- (requests, duration of gaps or more complex parameters)<br/>
     * standbyOperation (7),<br/>
     * -- Controller: partially switched off or partially amber flashing<br/>
     * failureMode (8),<br/>
     * -- Controller has a problem or failure in operation<br/>
     * off (9),<br/>
     * -- Controller is switched off<br/>
     * -- Related to MAP and SPAT bindings<br/>
     * recentMAPmessageUpdate (10),<br/>
     * -- Map revision with content changes<br/>
     * recentChangeInMAPassignedLanesIDsUsed (11),<br/>
     * -- Change in MAP's assigned lanes used (lane changes)<br/>
     * -- Changes in the active lane list description<br/>
     * noValidMAPisAvailableAtThisTime (12),<br/>
     * -- MAP (and various lanes indexes) not available<br/>
     * noValidSPATisAvailableAtThisTime (13)<br/>
     * -- SPAT system is not working at this time<br/>
     * -- Bits 14,15 reserved at this time and shall be zero<br/>
     * } (SIZE(16))<br/>
     */
    @SizeRange(minValue = 16, maxValue = 16)
    public static class IntersectionStatusObject extends Asn1SequenceOf<Boolean> {
        public IntersectionStatusObject() {
            this(new ArrayList<Boolean>());
        }

        public IntersectionStatusObject(Collection<Boolean> coll) {
            super(coll);
        }

        public boolean getOrFalse(int i) {
            return (i < size()) ? get(i) : false;
        }

        public boolean manualControlIsEnabled() {
            return getOrFalse(0);
        }

        public boolean stopTimeIsActivated() {
            return getOrFalse(1);
        }

        public boolean failureFlash() {
            return getOrFalse(2);
        }

        public boolean preemptIsActive() {
            return getOrFalse(3);
        }

        public boolean signalPriorityIsActive() {
            return getOrFalse(4);
        }

        public boolean fixedTimeOperation() {
            return getOrFalse(5);
        }

        public boolean trafficDependentOperation() {
            return getOrFalse(6);
        }

        public boolean standbyOperation() {
            return getOrFalse(7);
        }

        public boolean failureMode() {
            return getOrFalse(8);
        }

        public boolean off() {
            return getOrFalse(9);
        }

        public boolean recentMAPmessageUpdate() {
            return getOrFalse(10);
        }

        public boolean recentChangeInMAPassignedLanesIDsUsed() {
            return getOrFalse(11);
        }

        public boolean noValidMAPisAvailableAtThisTime() {
            return getOrFalse(12);
        }

        public boolean noValidSPATisAvailableAtThisTime() {
            return getOrFalse(13);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("\"");
            for (boolean s : bakingList) {
                if (s) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            sb.append("\"");
            return sb.toString();
        }
    }

    /**
     * PhaseList ::= SEQUENCE (SIZE(1..16)) OF Phase<br/>
     * -- List of phases in one traffic signal
     */
    @SizeRange(minValue = 1, maxValue = 16)
    public static class PhaseList extends Asn1SequenceOf<Phase> {
        public PhaseList(Phase... phases) {
            this(Arrays.asList(phases));
        }

        public PhaseList(Collection<Phase> coll) {
            super(coll);
        }
    }
}
