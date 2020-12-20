package org.v2x.vehicle;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.motion.Heading;
import org.v2x.motion.MotionConfidenceSet;
import org.v2x.motion.Speed;
import org.v2x.position.Position3D;
import org.v2x.position.PositionConfidenceSet;
import org.v2x.position.PositionalAccuracy;
import org.v2x.time.DDateTime;
import org.v2x.time.TimeConfidence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "FullPositionVector", isSet = false)
public class FullPositionVector {

    @ASN1Element(name = "utcTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DDateTime utcTime = null;

    @ASN1Element(name = "pos", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position3D pos = null;

    @ASN1Element(name = "heading", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Heading heading = null;

    @ASN1Element(name = "transmission", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TransmissionState transmission = null;

    @ASN1Element(name = "speed", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Speed speed = null;

    @ASN1Element(name = "posAccuracy", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PositionalAccuracy posAccuracy = null;

    @ASN1Element(name = "posConficence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PositionConfidenceSet posConficence = null;

    @ASN1Element(name = "timeConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeConfidence timeConfidence = null;

    @ASN1Element(name = "motionCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MotionConfidenceSet motionCfd = null;


    public DDateTime getUtcTime() {
        return this.utcTime;
    }

    public void setUtcTime(DDateTime value) {
        this.utcTime = value;
    }

    public boolean isUtcTimePresent() {
        return this.utcTime != null;
    }

    public Position3D getPos() {
        return this.pos;
    }


    public void setPos(Position3D value) {
        this.pos = value;
    }


    public Heading getHeading() {
        return this.heading;
    }

    public void setHeading(Heading value) {
        this.heading = value;
    }

    public boolean isHeadingPresent() {
        return this.heading != null;
    }

    public TransmissionState getTransmission() {
        return this.transmission;
    }

    public void setTransmission(TransmissionState value) {
        this.transmission = value;
    }

    public boolean isTransmissionPresent() {
        return this.transmission != null;
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

    public PositionalAccuracy getPosAccuracy() {
        return this.posAccuracy;
    }

    public void setPosAccuracy(PositionalAccuracy value) {
        this.posAccuracy = value;
    }

    public boolean isPosAccuracyPresent() {
        return this.posAccuracy != null;
    }

    public PositionConfidenceSet getPosConficence() {
        return this.posConficence;
    }

    public void setPosConficence(PositionConfidenceSet value) {
        this.posConficence = value;
    }

    public boolean isPosConficencePresent() {
        return this.posConficence != null;
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

    public MotionConfidenceSet getMotionCfd() {
        return this.motionCfd;
    }

    public void setMotionCfd(MotionConfidenceSet value) {
        this.motionCfd = value;
    }

    public boolean isMotionCfdPresent() {
        return this.motionCfd != null;
    }


}
            