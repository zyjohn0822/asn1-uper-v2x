package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyong
 * @date 2020/12/15  16:52
 */
public class VehicleEventFlagsTest {
    VehicleEventFlags vehicleEventFlags;

    @Before
    public void setUp() throws Exception {
        final List<Boolean> eventFlags = Arrays.asList(false, false, false, false, false, false, false, false, false, false, false, false, false);
        vehicleEventFlags = new VehicleEventFlags(eventFlags);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(vehicleEventFlags);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}