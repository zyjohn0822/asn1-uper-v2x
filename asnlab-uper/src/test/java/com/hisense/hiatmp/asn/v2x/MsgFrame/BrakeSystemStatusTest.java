package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  11:27
 */
public class BrakeSystemStatusTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void per_decode() throws IOException {
        //-128, -128
        byte[] decodeBytes = new byte[]{-2, -14, -107};
        final BrakeSystemStatus brakeSystemStatus = BrakeSystemStatus
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(brakeSystemStatus);
    }

    @Test
    public void per_encode() {
    }
}