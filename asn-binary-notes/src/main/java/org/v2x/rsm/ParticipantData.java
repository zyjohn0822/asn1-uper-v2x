package org.v2x.rsm;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.ASN1OctetString;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.v2x.acceleration.AccelerationSet4Way;
import org.v2x.motion.Heading;
import org.v2x.motion.MotionConfidenceSet;
import org.v2x.motion.Speed;
import org.v2x.motion.SteeringWheelAngle;
import org.v2x.position.PositionConfidenceSet;
import org.v2x.position.PositionOffsetLLV;
import org.v2x.time.DSecond;
import org.v2x.vehicle.TransmissionState;
import org.v2x.vehicle.VehicleClassification;
import org.v2x.vehicle.VehicleSize;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "ParticipantData", isSet = false)
public class ParticipantData {

    @ASN1Element(name = "ptcType", isOptional = false, hasTag = false, hasDefaultValue = false)
    private ParticipantType ptcType = null;

    @ASN1Integer(name = "")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 65535L
    )
    @ASN1Element(name = "ptcId", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Integer ptcId = null;

    @ASN1Element(name = "source", isOptional = false, hasTag = false, hasDefaultValue = false)
    private SourceType source = null;

    @ASN1OctetString(name = "")
    @ASN1SizeConstraint(max = 8L)
    @ASN1Element(name = "id", isOptional = true, hasTag = false, hasDefaultValue = false)
    private byte[] id = null;

    @ASN1Element(name = "secMark", isOptional = false, hasTag = false, hasDefaultValue = false)
    private DSecond secMark = null;

    @ASN1Element(name = "pos", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PositionOffsetLLV pos = null;

    @ASN1Element(name = "posConfidence", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PositionConfidenceSet posConfidence = null;

    @ASN1Element(name = "transmission", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TransmissionState transmission = null;

    @ASN1Element(name = "speed", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Speed speed = null;

    @ASN1Element(name = "heading", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Heading heading = null;

    @ASN1Element(name = "angle", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SteeringWheelAngle angle = null;

    @ASN1Element(name = "motionCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MotionConfidenceSet motionCfd = null;

    @ASN1Element(name = "accelSet", isOptional = true, hasTag = false, hasDefaultValue = false)
    private AccelerationSet4Way accelSet = null;

    @ASN1Element(name = "size", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VehicleSize size = null;

    @ASN1Element(name = "vehicleClass", isOptional = true, hasTag = false, hasDefaultValue = false)
    private VehicleClassification vehicleClass = null;


    public ParticipantType getPtcType() {
        return this.ptcType;
    }


    public void setPtcType(ParticipantType value) {
        this.ptcType = value;
    }


    public Integer getPtcId() {
        return this.ptcId;
    }


    public void setPtcId(Integer value) {
        this.ptcId = value;
    }


    public SourceType getSource() {
        return this.source;
    }


    public void setSource(SourceType value) {
        this.source = value;
    }


    public byte[] getId() {
        return this.id;
    }

    public void setId(byte[] value) {
        this.id = value;
    }

    public boolean isIdPresent() {
        return this.id != null;
    }

    public DSecond getSecMark() {
        return this.secMark;
    }


    public void setSecMark(DSecond value) {
        this.secMark = value;
    }


    public PositionOffsetLLV getPos() {
        return this.pos;
    }


    public void setPos(PositionOffsetLLV value) {
        this.pos = value;
    }


    public PositionConfidenceSet getPosConfidence() {
        return this.posConfidence;
    }


    public void setPosConfidence(PositionConfidenceSet value) {
        this.posConfidence = value;
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


    public Heading getHeading() {
        return this.heading;
    }


    public void setHeading(Heading value) {
        this.heading = value;
    }


    public SteeringWheelAngle getAngle() {
        return this.angle;
    }

    public void setAngle(SteeringWheelAngle value) {
        this.angle = value;
    }

    public boolean isAnglePresent() {
        return this.angle != null;
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

    public AccelerationSet4Way getAccelSet() {
        return this.accelSet;
    }

    public void setAccelSet(AccelerationSet4Way value) {
        this.accelSet = value;
    }

    public boolean isAccelSetPresent() {
        return this.accelSet != null;
    }

    public VehicleSize getSize() {
        return this.size;
    }


    public void setSize(VehicleSize value) {
        this.size = value;
    }


    public VehicleClassification getVehicleClass() {
        return this.vehicleClass;
    }

    public void setVehicleClass(VehicleClassification value) {
        this.vehicleClass = value;
    }

    public boolean isVehicleClassPresent() {
        return this.vehicleClass != null;
    }


}
            