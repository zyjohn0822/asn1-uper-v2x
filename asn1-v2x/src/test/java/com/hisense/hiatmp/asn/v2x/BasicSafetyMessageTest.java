package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.basic.*;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.hisense.hiatmp.asn.v2x.basic.DDateTime.DSecond;
import static com.hisense.hiatmp.asn.v2x.basic.Position3D.*;
import static com.hisense.hiatmp.asn.v2x.basic.PositionalAccuracy.*;

/**
 * @author zhangyong
 * @date 2020/12/15  16:53
 */
public class BasicSafetyMessageTest {
    BasicSafetyMessage basicSafetyMessage;

    @Before
    public void setUp() throws Exception {
        MsgCount msgCount = new MsgCount(35);
        List<Byte> bs = Arrays.asList((byte) 48, (byte) 48, (byte) 49, (byte) 52, (byte) 51, (byte) 49, (byte) 48, (byte) 49);
        ID id = new ID(bs);
        DSecond secMark = new DSecond(47091);
        TimeConfidence timeConfidence = null;
        Position3D pos = new Position3D(new Latitude(281260343), new Longitude(1128799971), new Elevation(1233));
        PositionalAccuracy posAccuracy = new PositionalAccuracy(
                new SemiMajorAxisAccuracy(48),
                new SemiMinorAxisAccuracy(48),
                new SemiMajorAxisOrientation(12339));
        PositionConfidenceSet posConfidence = null;
        TransmissionState transmission = TransmissionState.neutral;
        Speed speed = new Speed(6);
        Heading heading = new Heading(5944);
        SteeringWheelAngle angle = new SteeringWheelAngle(15);
        MotionConfidenceSet motionCfd = null;
        AccelerationSet4Way accelSet = new AccelerationSet4Way(
                new AccelerationSet4Way.Acceleration(5),
                new AccelerationSet4Way.Acceleration(0),
                new AccelerationSet4Way.VerticalAcceleration(0),
                new AccelerationSet4Way.YawRate(0)
        );
        BrakeSystemStatus brakes = new BrakeSystemStatus(
                BrakeSystemStatus.BrakePedalStatus.off,
                null, null, null, null, null, null
        );
        VehicleSize size = new VehicleSize(
                new VehicleSize.VehicleWidth(180),
                new VehicleSize.VehicleLength(500),
                null);
        VehicleClassification vehicleClass = new VehicleClassification(
                new VehicleClassification.BasicVehicleClass(),
                null);
        List<Boolean> vs = Arrays.asList(false, false, false, false, false, false, false, false, false, false, false, false, false);
        VehicleEventFlags vehicleEventFlags = new VehicleEventFlags(vs);
        List<Boolean> es = Arrays.asList(false, false, false, false, false, false, false, false, false);
        ExteriorLights exteriorLights = new ExteriorLights(es);
        VehicleSafetyExtensions safetyExt = new VehicleSafetyExtensions(vehicleEventFlags, null, null, exteriorLights);
        VehicleEmergencyExtensions emergencyExt = null;
        basicSafetyMessage = new BasicSafetyMessage(
                msgCount,
                id,
                secMark,
                null,
                pos,
                posAccuracy,
                null,
                transmission,
                speed,
                heading,
                angle,
                null,
                accelSet,
                brakes,
                size,
                vehicleClass,
                safetyExt,
                null

        );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(basicSafetyMessage);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
        byte[] bs = new byte[]{42, 70, 96, 96, 98, 104, 102, 98,
                96, 99, 111, -25, -116, -47, 52, 111, 93, 35, -31,
                -60, 41, -94, 96, 96, 96, 102, 0, 12, 92, -30, 53,
                -11, 95, 65, -3, -1, -2, 2, 45, 7, -48, 54, 72, 0, 0, 0};
        final BasicSafetyMessage decode = UperEncoder.decode(bs, BasicSafetyMessage.class);
        System.out.println(decode);
    }
}