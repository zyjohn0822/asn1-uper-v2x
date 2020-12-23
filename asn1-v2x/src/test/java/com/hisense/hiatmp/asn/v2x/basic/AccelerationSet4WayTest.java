package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.Test;

import java.util.Arrays;

import static com.hisense.hiatmp.asn.v2x.basic.AccelerationSet4Way.*;

/**
 * @author zhangyong
 * @date 2020/12/15  16:31
 */
public class AccelerationSet4WayTest {
    @Test
    public void encode() throws Exception {
        Acceleration lon = new Acceleration(5);
        Acceleration lat = new Acceleration(0);
        VerticalAcceleration vert = new VerticalAcceleration(0);
        YawRate yaw = new YawRate(0);
        AccelerationSet4Way accelerationSet4Way = new AccelerationSet4Way(
                lon,
                lat,
                vert,
                yaw
        );
        final byte[] encode = UperEncoder.encode(accelerationSet4Way);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}