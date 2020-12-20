package org.v2x.spat;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.map.node.NodeReferenceID;
import org.v2x.time.DSecond;
import org.v2x.time.MinuteOfTheYear;
import org.v2x.time.TimeConfidence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "IntersectionState", isSet = false)
public class IntersectionState {

    @ASN1Element(name = "intersectionId", isOptional = false, hasTag = false, hasDefaultValue = false)
    private NodeReferenceID intersectionId = null;

    @ASN1Element(name = "status", isOptional = false, hasTag = false, hasDefaultValue = false)
    private IntersectionStatusObject status = null;

    @ASN1Element(name = "moy", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MinuteOfTheYear moy = null;

    @ASN1Element(name = "timeStamp", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DSecond timeStamp = null;

    @ASN1Element(name = "timeConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeConfidence timeConfidence = null;

    @ASN1Element(name = "phases", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PhaseList phases = null;


    public NodeReferenceID getIntersectionId() {
        return this.intersectionId;
    }


    public void setIntersectionId(NodeReferenceID value) {
        this.intersectionId = value;
    }


    public IntersectionStatusObject getStatus() {
        return this.status;
    }


    public void setStatus(IntersectionStatusObject value) {
        this.status = value;
    }


    public MinuteOfTheYear getMoy() {
        return this.moy;
    }

    public void setMoy(MinuteOfTheYear value) {
        this.moy = value;
    }

    public boolean isMoyPresent() {
        return this.moy != null;
    }

    public DSecond getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(DSecond value) {
        this.timeStamp = value;
    }

    public boolean isTimeStampPresent() {
        return this.timeStamp != null;
    }

    public TimeConfidence getTimeConfidence() {
        return this.timeConfidence;
    }

    public void setTimeConfidence(TimeConfidence value) {
        this.timeConfidence = value;
    }

    public boolean isTimeConfidencePresent() {
        return this.timeConfidence != null;
    }

    public PhaseList getPhases() {
        return this.phases;
    }


    public void setPhases(PhaseList value) {
        this.phases = value;
    }


}
            