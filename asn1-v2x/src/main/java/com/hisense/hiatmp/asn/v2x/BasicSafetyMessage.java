package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.basic.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangyong
 * @date 2020/11/4  19:06
 */
@Sequence
@Getter
@Setter
@Builder
@HasExtensionMarker
public class BasicSafetyMessage {
    /** 0 */
    @Component(0)
    MsgCount msgCnt;
    /** 1 */
    @Component(1)
    ID id;
    /** 2 */
    @Component(2)
    DDateTime.DSecond secMark;
    /** 3 */
    @Component(3)
    @Asn1Optional
    DDateTime.TimeConfidence timeConfidence;
    /** 4 */
    @Component(4)
    Position3D pos;
    /** 5 */
    @Component(5)
    @Asn1Optional
    PositionalAccuracy posAccuracy;
    /** 6 */
    @Component(6)
    @Asn1Optional
    PositionConfidenceSet posConfidence;
    /** 7 */
    @Component(7)
    VehStatus.TransmissionState transmission;
    /** 8 */
    @Component(8)
    Speed speed;
    /** 9 */
    @Component(9)
    Heading heading;
    /** 10 */
    @Component(10)
    @Asn1Optional
    SteeringWheelAngle angle;
    /** 11 */
    @Component(11)
    @Asn1Optional
    MotionConfidenceSet motionCfd;
    /** 12 */
    @Component(12)
    AccelerationSet4Way accelSet;
    /** 13 */
    @Component(13)
    BrakeSystemStatus brakes;
    /** 14 */
    @Component(14)
    VehicleSize size;
    /** 15 */
    @Component(15)
    VehicleClassification vehicleClass;
    /** 16 */
    @Component(16)
    @Asn1Optional
    VehicleSafetyExtensions safetyExt;
    /** 17*/
    @Component(17)
    @Asn1Optional
    VehicleEmergencyExtensions emergencyExt;

    public BasicSafetyMessage(){}
    public BasicSafetyMessage(
            MsgCount msgCnt,
            ID id,
            DDateTime.DSecond secMark,
            DDateTime.TimeConfidence timeConfidence,
            Position3D pos,
            PositionalAccuracy posAccuracy,
            PositionConfidenceSet posConfidence,
            VehStatus.TransmissionState transmission,
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
    @SizeRange(minValue = 8, maxValue = 8)
    public static class ID extends Asn1SequenceOf<Byte> {
        // Two constructors -- choose any, or add more.
        public ID(Byte... coll)          { this(Arrays.asList(coll)); }
        public ID(Collection<Byte> coll) { super(coll); }
    }
}
