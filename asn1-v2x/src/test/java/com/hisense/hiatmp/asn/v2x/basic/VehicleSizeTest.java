package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:52
 */
public class VehicleSizeTest {
    VehicleSize vehicleSize;

    @Before
    public void setUp() throws Exception {
        vehicleSize = new VehicleSize(new VehicleSize.VehicleWidth(10),
                new VehicleSize.VehicleLength(50),
                new VehicleSize.VehicleHeight(50));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(vehicleSize);
        System.out.println(Arrays.toString(encode));

    }

    @Test
    public void decode() throws Exception {
    }
}