import com.hisense.hiatmp.asn.v2x.BasicSafetyMessage;
import com.hisense.hiatmp.asn.v2x.basic.*;
import com.hisense.hiatmp.asn.v2x.basic.VehicleSize.VehicleLength;
import com.hisense.hiatmp.asn.v2x.basic.VehicleSize.VehicleWidth;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hisense.hiatmp.asn.v2x.basic.AccelerationSet4Way.*;
import static com.hisense.hiatmp.asn.v2x.basic.BrakeSystemStatus.*;
import static com.hisense.hiatmp.asn.v2x.basic.Position3D.Latitude;
import static com.hisense.hiatmp.asn.v2x.basic.Position3D.Longitude;
import static com.hisense.hiatmp.asn.v2x.basic.PositionConfidenceSet.ElevationConfidence;
import static com.hisense.hiatmp.asn.v2x.basic.PositionConfidenceSet.PositionConfidence;

/**
 * @author zhangyong
 * @date 2020/11/11  20:22
 */
public class BasicSafetyMessageTest {
    static BasicSafetyMessage basicSafetyMessage;

    @BeforeClass
    public static void newInstanceTest() throws Exception {
        List<Byte> bytes = Arrays.asList((byte) 12, (byte) 14, (byte) 67, (byte) 77, (byte) 78, (byte) 100, (byte) 64, (byte) 88);
//        basicSafetyMessage = BasicSafetyMessage.builder()
//                //0
//                .msgCnt(new MsgCount(12))
//                //1
//                //.id(new BasicSafetyMessage.ID(bytes))
//                //2
//                .secMark(new DDateTime.DSecond(665))
//                //3
//                .timeConfidence(TimeConfidence.time_000_000_000_000_1)
//                //4
//                .pos(new Position3D(new Latitude(12), new Longitude(11)))
//                //5
//                .posAccuracy(null)
//                //6
//                .posConfidence(new PositionConfidenceSet(PositionConfidence.a1cm, ElevationConfidence.elev_000_02))
//                //7
//                .transmission(TransmissionState.park)
//                //8
//                .speed(new Speed(60))
//                //9
//                .heading(new Heading(23))
//                //10
//                .angle(new SteeringWheelAngle(11))
//                //11
//                .motionCfd(null)
//                //12
//                .accelSet(new AccelerationSet4Way(new Acceleration(11), new Acceleration(12), new VerticalAcceleration(22), new YawRate(222)))
//                //13
//                .brakes(new BrakeSystemStatus())
//                //14
//                .size(new VehicleSize(new VehicleWidth(50), new VehicleLength(50), null))
//                //15
//                .vehicleClass(new VehicleClassification(new BasicVehicleClass(2), new VehicleClassification.FuelType(11)))
//                //16
//                .safetyExt(null)
//                //17
//                .emergencyExt(null)
//                .build();
    }

    /**
     * 功能描述: <br>
     * <p>将16进制字符串转换成byte[]数组</p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     *
     * @param s 16进制字符串
     * @return: byte[] byte[]数组
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/10/30 14:02
     */
    public static byte[] bytesFromHexString(String s) {
        if ((s.length() % 2) != 0) {
            throw new IllegalArgumentException(
                    "Converting to bytes requires even number of characters, got " + s.length());
        }
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    @Test
    public void encodeBasicSafetyMessageTest() {
        final byte[] encode = UperEncoder.encode(basicSafetyMessage);
        byte[] actual = new byte[]{-96, 99, 22, 76, -38, 53, 108, -35, -64, 20, -52, -122, -76, -99, 33, -115, 105, 58, 65, 95, -30, 3, -64, 2, -15, 47, -74, -5, -110, -80, 27, -96, 1, -112, 25, 0, -128};
        System.out.println(Arrays.toString(encode));
        Assert.assertArrayEquals(encode, actual);

    }

    @Test
    public void decodeMsgCountTest() {
        MsgCount msgCount = new MsgCount(35);
        final byte[] encode = UperEncoder.encode(msgCount);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decodeDSecondTest() {
        DDateTime.DSecond dSecond = new DDateTime.DSecond(655);
        final byte[] encode = UperEncoder.encode(dSecond);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodePosition3DTest() {
        final Position3D position3D = new Position3D(new Latitude(12), new Longitude(11));
        final byte[] encode = UperEncoder.encode(position3D);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeTimeConfidenceTest() {
        final TimeConfidence time_000_000_000_000_1 = TimeConfidence.time_000_000_000_000_1;
        final byte[] encode = UperEncoder.encode(time_000_000_000_000_1);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeBrakeSystemStatus() {
        BrakePedalStatus brakePedalStatus = BrakePedalStatus.off;
        BrakeAppliedStatus brakeAppliedStatus = new BrakeAppliedStatus(Arrays.asList(true, true, true, true, true));
        TractionControlStatus tractionControlStatus = TractionControlStatus.off;
        AntiLockBrakeStatus antiLockBrakeStatus = AntiLockBrakeStatus.off;
        StabilityControlStatus stabilityControlStatus = StabilityControlStatus.off;
        BrakeBoostApplied brakeBoostApplied = BrakeBoostApplied.off;
        AuxiliaryBrakeStatus auxiliaryBrakeStatus = AuxiliaryBrakeStatus.off;
        BrakeSystemStatus brakeSystemStatus = new BrakeSystemStatus(
                brakePedalStatus, brakeAppliedStatus, tractionControlStatus, antiLockBrakeStatus,
                stabilityControlStatus, brakeBoostApplied, auxiliaryBrakeStatus
        );
        final byte[] encode = UperEncoder.encode(brakeSystemStatus);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeBrakeAppliedStatusTest() {

        BrakeAppliedStatus brakeAppliedStatus = new BrakeAppliedStatus(Arrays.asList(true, true, true, true, true));
        final byte[] encode = UperEncoder.encode(brakeAppliedStatus);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeVehicleSizeTest() {
        VehicleSize vehicleSize = new VehicleSize(new VehicleWidth(10), new VehicleLength(11));
        final byte[] encode = UperEncoder.encode(vehicleSize);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodePositionalAccuracyTest() {
        PositionalAccuracy positionalAccuracy = new PositionalAccuracy(new PositionalAccuracy.SemiMajorAxisAccuracy(100),
                new PositionalAccuracy.SemiMinorAxisAccuracy(200),
                new PositionalAccuracy.SemiMajorAxisOrientation(500));
        final byte[] encode = UperEncoder.encode(positionalAccuracy);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodePositionConfidenceSetTest() {
        PositionConfidenceSet positionConfidenceSet = new PositionConfidenceSet(PositionConfidence.a1cm, ElevationConfidence.elev_000_01);
        final byte[] encode = UperEncoder.encode(positionConfidenceSet);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeTransmissionStateTest() {
        TransmissionState transmissionState = TransmissionState.park;
        final byte[] encode = UperEncoder.encode(transmissionState);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeSpeedTest() {
        Speed speed = new Speed(700);
        final byte[] encode = UperEncoder.encode(speed);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeHeadingTest() {
        Heading heading = new Heading(700);
        final byte[] encode = UperEncoder.encode(heading);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeSteeringWheelAngleTest() {
        SteeringWheelAngle steeringWheelAngle = new SteeringWheelAngle(50);
        final byte[] encode = UperEncoder.encode(steeringWheelAngle);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeMotionConfidenceSetTest() {
        MotionConfidenceSet motionConfidenceSet = new MotionConfidenceSet(MotionConfidenceSet.SpeedConfidence.prec0_1deg,
                MotionConfidenceSet.HeadingConfidence.prec0_01ms,
                MotionConfidenceSet.SteeringWheelAngleConfidence.prec1deg);
        final byte[] encode = UperEncoder.encode(motionConfidenceSet);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeAccelerationSet4WayTest() {
        final AccelerationSet4Way accelerationSet4Way = new AccelerationSet4Way(new Acceleration(11), new Acceleration(12), new VerticalAcceleration(20), new YawRate(30));
        final byte[] encode = UperEncoder.encode(accelerationSet4Way);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeBrakeSystemStatusTest() {
        List<Boolean> b1 = new ArrayList<>(5);
        b1.add(true);
        b1.add(false);
        b1.add(false);
        b1.add(true);
        b1.add(true);
        BrakeSystemStatus brakeSystemStatus = new BrakeSystemStatus(
                BrakePedalStatus.off,
                null,
                TractionControlStatus.on,
                AntiLockBrakeStatus.engaged,
                StabilityControlStatus.on,
                BrakeBoostApplied.off,
                AuxiliaryBrakeStatus.on
        );
        final byte[] encode = UperEncoder.encode(brakeSystemStatus);
        System.out.println(Arrays.toString(encode));

    }

    /**
     * cause --1
     */
    @Test
    public void encodeVehicleClassificationTest() {
        VehicleClassification vehicleClassification = new VehicleClassification(
                new VehicleClassification.BasicVehicleClass(54),
                null
        );
        final byte[] encode = UperEncoder.encode(vehicleClassification);
        //byte[] de = new byte[]{13, -128};
        //final VehicleClassification decode = UperEncoder.decode(de, VehicleClassification.class);
        System.out.println(Arrays.toString(encode));
    }

    /**
     * cause--
     */
    @Test
    public void encodeVehicleSafetyExtensionsTest() {
        List<Boolean> event = new ArrayList<>(13);
        for (int i = 0; i < 13; i++) {
            event.add(true);
        }
        List<Boolean> exteriorLights = new ArrayList<>(13);
        for (int i = 0; i < 9; i++) {
            exteriorLights.add(true);
        }

        VehicleSafetyExtensions vehicleSafetyExtensions = new VehicleSafetyExtensions(
                new VehicleEventFlags(event),
                null,
                null,
                new ExteriorLights(exteriorLights)
        );
        VehicleSafetyExtensions vehicleSafetyExtensions1 = new VehicleSafetyExtensions(
                null,
                null,
                null,
                null
        );
        final byte[] encode = UperEncoder.encode(vehicleSafetyExtensions);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void encodeVehicleEmergencyExtensionsTest() {
        VehicleEmergencyExtensions vehicleEmergencyExtensions = new VehicleEmergencyExtensions(
                ResponseType.nonEmergency,
                SirenInUse.inUse,
                LightbarInUse.inUse
        );
        final byte[] encode = UperEncoder.encode(vehicleEmergencyExtensions);
        System.out.println(Arrays.toString(encode));

    }

    @Test
    public void decodeBsmFrame() {
        String hex = "07A4660606268666260636FE6063344D1BD748F8710A68800000004018018B9C46BEABE83FBFFFE07E2D07D03648000000";
        String hex2 = "2A463030313433313031B7F3E046689A37C0AE91F0E214D13030303300000617388D07D507D07F7FFF808000B401F4003648000000";
        byte[] bytes1 = new byte[]{
                42, 70, 48, 48, 49,
                52, 51, 49, 48, 49,
                -73, -13, -32, 70,
                104, -102, 55, -64,
                -82, -111, -16, -30,
                20, -47, 48, 48, 48,
                51, 0, 0, 6, 23, 56,
                -115, 7, -43, 7, -48,
                127, 127, -1, -128,
                -128, 0, -76, 1, -12,
                0, 54, 72, 0, 0, 0};
        BasicSafetyMessage basicSafetyMessage = UperEncoder.decode(bytes1, BasicSafetyMessage.class);
        System.out.println(Arrays.toString(bytes1));
        System.out.println(basicSafetyMessage);
    }
}
