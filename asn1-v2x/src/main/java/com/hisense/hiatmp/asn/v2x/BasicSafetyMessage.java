package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.basic.*;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * BSM DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p>
 * -- imports and exports<br/>
 * <p>
 * EXPORTS BasicSafetyMessage;<br/>
 * IMPORTS AccelerationSet4Way FROM DefAcceleration<br/>
 * BrakeSystemStatus FROM VehBrake<br/>
 * VehicleSize FROM VehSize<br/>
 * Position3D, PositionConfidenceSet, PositionalAccuracy FROM DefPosition<br/>
 * DSecond, TimeConfidence FROM DefTime<br/>
 * TransmissionState FROM VehStatus<br/>
 * Speed, Heading, SteeringWheelAngle, MotionConfidenceSet FROM DefMotion<br/>
 * MsgCount FROM MsgFrame<br/>
 * VehicleClassification FROM VehClass<br/>
 * VehicleSafetyExtensions FROM VehSafetyExt<br/>
 * VehicleEmergencyExtensions FROM VehEmgExt;<br/>
 * <p>
 * BasicSafetyMessage ::= SEQUENCE {<br/>
 * msgCnt MsgCount,<br/>
 * id OCTET STRING (SIZE(8)),<br/>
 * -- temperary vehicle ID<br/>
 * secMark DSecond,<br/>
 * timeConfidence TimeConfidence OPTIONAL,<br/>
 * pos Position3D,<br/>
 * posAccuracy PositionalAccuracy OPTIONAL,<br/>
 * -- Accuracy for GNSS system<br/>
 * posConfidence PositionConfidenceSet OPTIONAL,<br/>
 * -- Realtime position confidence<br/>
 * transmission TransmissionState,<br/>
 * speed Speed,<br/>
 * heading Heading,<br/>
 * angle SteeringWheelAngle OPTIONAL,<br/>
 * motionCfd MotionConfidenceSet OPTIONAL,<br/>
 * accelSet AccelerationSet4Way,<br/>
 * brakes BrakeSystemStatus,<br/>
 * size VehicleSize,<br/>
 * vehicleClass VehicleClassification,<br/>
 * -- VehicleClassification includes BasicVehicleClass and other extendible type<br/>
 * safetyExt VehicleSafetyExtensions OPTIONAL,<br/>
 * emergencyExt VehicleEmergencyExtensions OPTIONAL,<br/>
 * ...<br/>
 * }<br/>
 * <p>
 * END<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:06
 */
@Sequence
@Getter
@Setter
@HasExtensionMarker
public class BasicSafetyMessage {

    @Component(0)
    MsgCount msgCnt;

    @Component(1)
    ID id;

    @Component(2)
    DDateTime.DSecond secMark;

    @Component(3)
    @Asn1Optional
    TimeConfidence timeConfidence;

    @Component(4)
    Position3D pos;

    @Component(5)
    @Asn1Optional
    PositionalAccuracy posAccuracy;

    @Component(6)
    @Asn1Optional
    PositionConfidenceSet posConfidence;

    @Component(7)
    TransmissionState transmission;

    @Component(8)
    Speed speed;

    @Component(9)
    Heading heading;

    @Component(10)
    @Asn1Optional
    SteeringWheelAngle angle;

    @Component(11)
    @Asn1Optional
    MotionConfidenceSet motionCfd;

    @Component(12)
    AccelerationSet4Way accelSet;

    @Component(13)
    BrakeSystemStatus brakes;

    @Component(14)
    VehicleSize size;

    @Component(15)
    VehicleClassification vehicleClass;

    @Component(16)
    @Asn1Optional
    VehicleSafetyExtensions safetyExt;

    @Component(17)
    @Asn1Optional
    VehicleEmergencyExtensions emergencyExt;

    public BasicSafetyMessage() {
    }

    public BasicSafetyMessage(
            MsgCount msgCnt,
            ID id,
            DDateTime.DSecond secMark,
            TimeConfidence timeConfidence,
            Position3D pos,
            PositionalAccuracy posAccuracy,
            PositionConfidenceSet posConfidence,
            TransmissionState transmission,
            Speed speed,
            Heading heading,
            SteeringWheelAngle angle,
            MotionConfidenceSet motionCfd,
            AccelerationSet4Way accelSet,
            BrakeSystemStatus brakes,
            VehicleSize size,
            VehicleClassification vehicleClass,
            VehicleSafetyExtensions safetyExt,
            VehicleEmergencyExtensions emergencyExt
    ) {
        this.msgCnt = msgCnt;
        this.id = id;
        this.secMark = secMark;
        this.timeConfidence = timeConfidence;
        this.pos = pos;
        this.posAccuracy = posAccuracy;
        this.posConfidence = posConfidence;
        this.transmission = transmission;
        this.speed = speed;
        this.heading = heading;
        this.angle = angle;
        this.motionCfd = motionCfd;
        this.accelSet = accelSet;
        this.brakes = brakes;
        this.size = size;
        this.vehicleClass = vehicleClass;
        this.safetyExt = safetyExt;
        this.emergencyExt = emergencyExt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"msgCnt\":")
                .append(msgCnt);
        sb.append(",\"id\":")
                .append(id);
        sb.append(",\"secMark\":")
                .append(secMark);
        sb.append(",\"timeConfidence\":")
                .append(timeConfidence);
        sb.append(",\"pos\":")
                .append(pos);
        sb.append(",\"posAccuracy\":")
                .append(posAccuracy);
        sb.append(",\"posConfidence\":")
                .append(posConfidence);
        sb.append(",\"transmission\":")
                .append(transmission);
        sb.append(",\"speed\":")
                .append(speed);
        sb.append(",\"heading\":")
                .append(heading);
        sb.append(",\"angle\":")
                .append(angle);
        sb.append(",\"motionCfd\":")
                .append(motionCfd);
        sb.append(",\"accelSet\":")
                .append(accelSet);
        sb.append(",\"brakes\":")
                .append(brakes);
        sb.append(",\"size\":")
                .append(size);
        sb.append(",\"vehicleClass\":")
                .append(vehicleClass);
        sb.append(",\"safetyExt\":")
                .append(safetyExt);
        sb.append(",\"emergencyExt\":")
                .append(emergencyExt);
        sb.append('}');
        return sb.toString();
    }

    @SizeRange(minValue = 8, maxValue = 8)
    public static class ID extends Asn1SequenceOf<Byte> {
        // Two constructors -- choose any, or add more.
        public ID(Byte... coll) {
            this(Arrays.asList(coll));
        }

        public ID(Collection<Byte> coll) {
            super(coll);
        }
    }
}
