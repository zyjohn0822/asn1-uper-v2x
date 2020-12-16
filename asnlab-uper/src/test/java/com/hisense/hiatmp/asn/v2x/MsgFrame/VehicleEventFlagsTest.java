package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author zhangyong
 * @date 2020/12/16  18:19
 */
public class VehicleEventFlagsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
    }
    @Test
    public void decode() throws Exception {
        byte[] decodeBytes = new byte[]{14, 60};
        final VehicleEventFlags vehicleEventFlags =
                VehicleEventFlags.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(vehicleEventFlags);
    }
}