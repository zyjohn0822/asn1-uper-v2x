package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/18  12:49
 */
public class SpeedTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void per_encode() {

    }

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{-1, -8};
        final Integer integer = Speed.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(integer.intValue());
    }
}