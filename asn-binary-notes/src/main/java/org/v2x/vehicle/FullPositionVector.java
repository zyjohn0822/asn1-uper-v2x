
package org.v2x.vehicle;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
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
@ASN1PreparedElement
@ASN1Sequence(name = "FullPositionVector", isSet = false)
public class FullPositionVector implements IASN1PreparedElement {

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


    public boolean isUtcTimePresent() {
        return this.utcTime != null;
    }


    public void setUtcTime(DDateTime value) {
        this.utcTime = value;
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


    public boolean isHeadingPresent() {
        return this.heading != null;
    }


    public void setHeading(Heading value) {
        this.heading = value;
    }


    public TransmissionState getTransmission() {
        return this.transmission;
    }


    public boolean isTransmissionPresent() {
        return this.transmission != null;
    }


    public void setTransmission(TransmissionState value) {
        this.transmission = value;
    }


    public Speed getSpeed() {
        return this.speed;
    }


    public boolean isSpeedPresent() {
        return this.speed != null;
    }


    public void setSpeed(Speed value) {
        this.speed = value;
    }


    public PositionalAccuracy getPosAccuracy() {
        return this.posAccuracy;
    }


    public boolean isPosAccuracyPresent() {
        return this.posAccuracy != null;
    }


    public void setPosAccuracy(PositionalAccuracy value) {
        this.posAccuracy = value;
    }


    public PositionConfidenceSet getPosConficence() {
        return this.posConficence;
    }


    public boolean isPosConficencePresent() {
        return this.posConficence != null;
    }


    public void setPosConficence(PositionConfidenceSet value) {
        this.posConficence = value;
    }


    public TimeConfidence getTimeConfidence() {
        return this.timeConfidence;
    }


    public boolean isTimeConfidencePresent() {
        return this.timeConfidence != null;
    }


    public void setTimeConfidence(TimeConfidence value) {
        this.timeConfidence = value;
    }


    public MotionConfidenceSet getMotionCfd() {
        return this.motionCfd;
    }


    public boolean isMotionCfdPresent() {
        return this.motionCfd != null;
    }


    public void setMotionCfd(MotionConfidenceSet value) {
        this.motionCfd = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(FullPositionVector.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            