package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  14:21
 */
public class PositionalAccuracyTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{48, 48, 48, 51};
        PositionalAccuracy positionalAccuracy = PositionalAccuracy
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(positionalAccuracy);
    }

    @Test
    public void per_encode() {
    }
}