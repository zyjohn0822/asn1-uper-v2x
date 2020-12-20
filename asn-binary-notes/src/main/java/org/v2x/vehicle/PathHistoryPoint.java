package org.v2x.vehicle;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.motion.CoarseHeading;
import org.v2x.motion.Speed;
import org.v2x.position.PositionConfidenceSet;
import org.v2x.position.PositionOffsetLLV;
import org.v2x.time.TimeOffset;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "PathHistoryPoint", isSet = false)
public class PathHistoryPoint {

    @ASN1Element(name = "llvOffset", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PositionOffsetLLV llvOffset = null;

    @ASN1Element(name = "timeOffset", isOptional = false, hasTag = false, hasDefaultValue = false)
    private TimeOffset timeOffset = null;

    @ASN1Element(name = "speed", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Speed speed = null;

    @ASN1Element(name = "posAccuracy", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PositionConfidenceSet posAccuracy = null;

    @ASN1Element(name = "heading", isOptional = true, hasTag = false, hasDefaultValue = false)
    private CoarseHeading heading = null;


    public PositionOffsetLLV getLlvOffset() {
        return this.llvOffset;
    }


    public void setLlvOffset(PositionOffsetLLV value) {
        this.llvOffset = value;
    }


    public TimeOffset getTimeOffset() {
        return this.timeOffset;
    }


    public void setTimeOffset(TimeOffset value) {
        this.timeOffset = value;
    }


    public Speed getSpeed() {
        return this.speed;
    }

    public void setSpeed(Speed value) {
        this.speed = value;
    }

    public boolean isSpeedPresent() {
        return this.speed != null;
    }

    public PositionConfidenceSet getPosAccuracy() {
        return this.posAccuracy;
    }

    public void setPosAccuracy(PositionConfidenceSet value) {
        this.posAccuracy = value;
    }

    public boolean isPosAccuracyPresent() {
        return this.posAccuracy != null;
    }

    public CoarseHeading getHeading() {
        return this.heading;
    }

    public void setHeading(CoarseHeading value) {
        this.heading = value;
    }

    public boolean isHeadingPresent() {
        return this.heading != null;
    }


}
            