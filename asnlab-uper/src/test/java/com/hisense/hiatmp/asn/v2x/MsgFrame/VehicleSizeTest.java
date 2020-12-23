package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  11:11
 */
public class VehicleSizeTest {

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{-127, 64, 100, -56};
        final VehicleSize vehicleSize = VehicleSize.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(vehicleSize);
    }

    @Test
    public void per_encode() {
    }
}