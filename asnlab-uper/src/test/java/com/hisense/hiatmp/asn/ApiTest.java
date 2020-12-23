package com.hisense.hiatmp.asn;

import com.hisense.hiatmp.asn.api.UperAsnProcess;
import com.hisense.hiatmp.asn.uper.UperDecoder;
import com.hisense.hiatmp.asn.v2x.AsnV2x;
import com.hisense.hiatmp.asn.v2x.MsgFrame.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author zhangyong
 * @date 2020/11/6  19:38
 */
public class ApiTest {
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    static String HEX_BSM_TEST1 = "02a4660606268666260636fe78cd1346f5d23e1c429a260606066000c5ce235f55f41fdfffe022d07d036480000000";

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

    /**
     * 功能描述: <br>
     * <p>将byte[]转换为16进制字符串</p >
     * 修改描述: <br>
     * <p>修改人:</p >
     * <p>修改原因:</p >
     *
     * @param bytes byte[]
     * @return: java.lang.String
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/10/30 14:00
     */
    public static String hexStringFromBytes(byte[] bytes) {

        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");

    }

    @Test
    public void basicSafetyMessageDecodeTest() throws IOException {
        MessageFrame bsmFrame = MessageFrame.per_decode(false, new ByteArrayInputStream(bytesFromHexString(HEX_BSM_TEST1)));
        final byte[] bytes = bytesFromHexString(HEX_BSM_TEST1);
        System.out.println(Arrays.toString(bytes));
        System.out.println("bsm" + bsmFrame.bsmFrame);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bsmFrame.bsmFrame.per_encode(false, out);
        byte[] bytes1 = out.toByteArray();
        System.out.println(Arrays.toString(bytes1));
        //byte 转 hex
        String s = hexStringFromBytes(bytes1);
        System.out.println(s);
    }

    @Test
    public void uperAsnProcessTest() throws IOException {
        UperAsnProcess asnProcess = new UperDecoder();
        final BasicSafetyMessage basicSafetyMessage = (BasicSafetyMessage) asnProcess.decode(
                new ByteArrayInputStream(bytesFromHexString(HEX_BSM_TEST1)),
                AsnV2x.Type.BSM,
                true);
        System.out.println(basicSafetyMessage);
    }

    @Test
    public void decodeMsgCountTest() throws IOException {
        byte[] bytes = new byte[]{70};
        int msgCount = MsgCount.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(msgCount);
    }

    @Test
    public void decodeDDateTimeTest() throws IOException {
        byte[] bytes = new byte[]{2, -113};
        int msgCount = DSecond.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(msgCount);
    }

    @Test
    public void encodeBasicSafetyMessageDecodeTest2() throws IOException {
        byte[] bytes = new byte[]{42, 70, 96, 96, 98, 104, 102, 98, 96, 99, 111, -25, -116, -47, 52, 111, 93, 35, -31, -60, 41, -94, 96, 96, 96, 102, 0, 12, 92, -30, 53, -11, 95, 65, -3, -1, -2, 2, 45, 7, -48, 54, 72, 0, 0, 0};
        final BasicSafetyMessage basicSafetyMessage = BasicSafetyMessage.per_decode(false, new ByteArrayInputStream(bytes));
    }

    @Test
    public void position3DDecodeTest() throws IOException {
        byte[] actual = new byte[]{-58, 85, 95, 0, -79, -97, 48, -1, 32, 1};
        final Position3D position3D = Position3D.per_decode(false, new ByteArrayInputStream(actual));
        System.out.println(position3D);
    }

    @Test
    public void decodeTimeConfidenceTest() throws IOException {
        byte[] bytes = new byte[]{64};
        TimeConfidence timeConfidence = TimeConfidence.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(timeConfidence);
    }

    @Test
    public void decodeBrakeAppliedStatusTest() throws IOException {
        byte[] bytes = new byte[]{124};
        BrakeAppliedStatus brakeAppliedStatus = BrakeAppliedStatus.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(brakeAppliedStatus);
    }

    @Test
    public void decodeVehicleSizeTest() throws IOException {
        byte[] bytes = new byte[]{1, 64, 22};
        VehicleSize vehicleSize = VehicleSize.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(vehicleSize);
    }

    @Test
    public void decodePositionalAccuracyTest() throws IOException {
        byte[] bytes = new byte[]{100, -56, 1, -12};
        PositionalAccuracy positionalAccuracy = PositionalAccuracy.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(positionalAccuracy);
    }

    @Test
    public void decodePositionConfidenceSetTest() throws IOException {
        byte[] bytes = new byte[]{-1, -128};
        PositionConfidenceSet positionConfidenceSet = PositionConfidenceSet.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(positionConfidenceSet);
    }

    @Test
    public void decodeTransmissionStateTest() throws IOException {
        byte[] bytes = new byte[]{32};
        TransmissionState transmissionState = TransmissionState.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(transmissionState);
    }

    @Test
    public void decodeSpeedTest() throws IOException {
        byte[] bytes = new byte[]{21, -32};
        Integer speed = Speed.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(speed);
    }

    @Test
    public void decodeHeadingTest() throws IOException {
        byte[] bytes = new byte[]{5, 120};
        Integer heading = Heading.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(heading);
    }

    @Test
    public void decodeSteeringWheelAngleTest() throws IOException {
        byte[] bytes = new byte[]{-80};
        Integer steeringWheelAngle = SteeringWheelAngle.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(steeringWheelAngle);
    }

    @Test
    public void decodeMotionConfidenceSetTest() throws IOException {
        byte[] bytes = new byte[]{-13, -64};
        MotionConfidenceSet motionConfidenceSet = MotionConfidenceSet.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(motionConfidenceSet);
    }

    @Test
    public void decodeAccelerationSet4WayDecodeTest() throws IOException {
        byte[] bytes = new byte[]{125, -73, -36, -109, -128, 29};
        final AccelerationSet4Way accelerationSet4Way = AccelerationSet4Way.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(accelerationSet4Way);
    }

    @Test
    public void decodeBrakeSystemStatusTest() throws IOException {
        //all - -2, -89, 115, 0
        byte[] bytes = new byte[]{-2, -66, -86, -128};
        final BrakeSystemStatus brakeSystemStatus = BrakeSystemStatus.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(brakeSystemStatus);

        //
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BrakeSystemStatus brakeSystemStatus1 = new BrakeSystemStatus();
        brakeSystemStatus1.brakePadel = BrakePedalStatus.off;
        brakeSystemStatus1.wheelBrakes = null;
        brakeSystemStatus1.traction = TractionControlStatus.on;
        brakeSystemStatus1.abs = AntiLockBrakeStatus.engaged;
        brakeSystemStatus1.scs = StabilityControlStatus.on;
        brakeSystemStatus1.brakeBoost = BrakeBoostApplied.off;
        brakeSystemStatus1.auxBrakes = AuxiliaryBrakeStatus.on;
        brakeSystemStatus1.per_encode(false, out);
        System.out.println(Arrays.toString(out.toByteArray()));
    }

    /**
     * 问题 已解决
     */
    @Test
    public void decodeVehicleClassificationTest() throws IOException {
        byte[] bytes = new byte[]{13, -128};
        VehicleClassification vehicleClassification = VehicleClassification.per_decode(true, new ByteArrayInputStream(bytes));
        System.out.println(vehicleClassification);
    }

    /**
     * org.asnlab.asndt.runtime.error.BufferUnderflowException: at 0: at pathPrediction
     *
     * @throws IOException
     */
    @Test
    public void decodeVehicleSafetyExtensionsTest() throws IOException {
        byte[] bytes = new byte[]{75, -1, -17, -8};
        VehicleSafetyExtensions vehicleSafetyExtensions = VehicleSafetyExtensions.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(vehicleSafetyExtensions);
    }

    @Test
    public void decodeVehicleEmergencyExtensionsTest() throws IOException {
        byte[] bytes = new byte[]{114, -112};
        final VehicleEmergencyExtensions vehicleEmergencyExtensions = VehicleEmergencyExtensions.per_decode(false, new ByteArrayInputStream(bytes));
        System.out.println(vehicleEmergencyExtensions);
        VehicleEmergencyExtensions ve = new VehicleEmergencyExtensions();
        ve.responseType = ResponseType.nonEmergency;
        ve.sirenUse = SirenInUse.inUse;
        ve.lightsUse = LightbarInUse.inUse;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ve.per_encode(false, out);
        System.out.println(Arrays.toString(out.toByteArray()));
    }
}
