package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:47
 */
public class SpeedTest {
    Speed speed;

    @Before
    public void setUp() throws Exception {
        speed = new Speed(8191);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(speed);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}