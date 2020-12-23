package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  11:04
 */
public class VehicleClassificationTest {

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{11, 64};
        final VehicleClassification vehicleClassification = VehicleClassification
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(vehicleClassification);
    }

    @Test
    public void per_encode() {
    }
}