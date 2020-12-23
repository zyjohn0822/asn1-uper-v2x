package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  13:36
 */
public class AccelerationSet4WayTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void per_decode() throws IOException {
        //error 125, 87, -48, 127, 127, -1
        byte[] decodeBytes = new byte[]{125, 87, -48, 127, 127, -1};
        final AccelerationSet4Way accelerationSet4Way = AccelerationSet4Way
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(accelerationSet4Way);
    }

    @Test
    public void per_encode() {
    }
}