package org.v2x.bsm;


import org.bn.annotations.*;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.v2x.MsgCount;
import org.v2x.acceleration.AccelerationSet4Way;
import org.v2x.motion.Heading;
import org.v2x.motion.MotionConfidenceSet;
import org.v2x.motion.Speed;
import org.v2x.motion.SteeringWheelAngle;
import org.v2x.position.Position3D;
import org.v2x.position.PositionConfidenceSet;
import org.v2x.position.PositionalAccuracy;
import org.v2x.time.DSecond;
import org.v2x.time.TimeConfidence;
import org.v2x.vehicle.*;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "BasicSafetyMessage", isSet = false)
public class BasicSafetyMessage {
    @Component(1)
    @ASN1Element(name = "msgCnt", isOptional = false, hasTag = false, hasDefaultValue = false)
    private MsgCount msgCnt = null;
    @Component(2)
    @ASN1OctetString(name = "id")
    @ASN1SizeConstraint(max = 8L)
    @ASN1Element(name = "id", isOptional = false, hasTag = false, hasDefaultValue = false)
    private byte[] id = null;

    @Component(3)
    @ASN1Element(name = "secMark", isOptional = false, hasTag = false, hasDefaultValue = false)
    private DSecond secMark = null;

    @Component(4)
    @ASN1Null
    @ASN1Element(name = "timeConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeConfidence timeConfidence = null;

    @Component(5)
    @ASN1Element(name = "pos", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position3D pos = null;

    @Component(6)
    @ASN1Element(name = "posAccuracy", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PositionalAccuracy posAccuracy = null;

    @Component(7)
    @ASN1Element(name = "posConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PositionConfidenceSet posConfidence = null;

    @Component(8)
    @ASN1Element(name = "transmission", isOptional = false, hasTag = false, hasDefaultValue = false)
    private TransmissionState transmission = null;

    @Component(9)
    @ASN1Element(name = "speed", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Speed speed = null;

    @Component(10)
    @ASN1Element(name = "heading", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Heading heading = null;

    @Component(11)
    @ASN1Element(name = "angle", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SteeringWheelAngle angle;

    @Component(12)
    @ASN1Element(name = "motionCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MotionConfidenceSet motionCfd = null;

    @Component(13)
    @ASN1Element(name = "accelSet", isOptional = false, hasTag = false, hasDefaultValue = false)
    private AccelerationSet4Way accelSet = null;

    @Component(14)
    @ASN1Element(name = "brakes", isOptional = false, hasTag = false, hasDefaultValue = false)
    private BrakeSystemStatus brakes = null;

    @Component(15)
    @ASN1Element(name = "size", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VehicleSize size = null;

    @Component(16)
    @ASN1Element(name = "vehicleClass", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VehicleClassification vehicleClass = null;

    @Component(17)
    @ASN1Element(name = "safetyExt", isOptional = true, hasTag = false, hasDefaultValue = false)
    private VehicleSafetyExtensions safetyExt = null;

    @Component(18)
    @ASN1Element(name = "emergencyExt", isOptional = true, hasTag = false, hasDefaultValue = false)
    private VehicleEmergencyExtensions emergencyExt = null;


    public MsgCount getMsgCnt() {
        return this.msgCnt;
    }


    public void setMsgCnt(MsgCount value) {
        this.msgCnt = value;
    }


    public byte[] getId() {
        return this.id;
    }


    public void setId(byte[] value) {
        this.id = value;
    }


    public DSecond getSecMark() {
        return this.secMark;
    }


    public void setSecMark(DSecond value) {
        this.secMark = value;
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

    public Position3D getPos() {
        return this.pos;
    }


    public void setPos(Position3D value) {
        this.pos = value;
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

    public PositionConfidenceSet getPosConfidence() {
        return this.posConfidence;
    }

    public void setPosConfidence(PositionConfidenceSet value) {
        this.posConfidence = value;
    }

    public boolean isPosConfidencePresent() {
        return this.posConfidence != null;
    }

    public TransmissionState getTransmission() {
        return this.transmission;
    }


    public void setTransmission(TransmissionState value) {
        this.transmission = value;
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


    public BrakeSystemStatus getBrakes() {
        return this.brakes;
    }


    public void setBrakes(BrakeSystemStatus value) {
        this.brakes = value;
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


    public VehicleSafetyExtensions getSafetyExt() {
        return this.safetyExt;
    }

    public void setSafetyExt(VehicleSafetyExtensions value) {
        this.safetyExt = value;
    }

    public boolean isSafetyExtPresent() {
        return this.safetyExt != null;
    }

    public VehicleEmergencyExtensions getEmergencyExt() {
        return this.emergencyExt;
    }

    public void setEmergencyExt(VehicleEmergencyExtensions value) {
        this.emergencyExt = value;
    }

    public boolean isEmergencyExtPresent() {
        return this.emergencyExt != null;
    }


}
            