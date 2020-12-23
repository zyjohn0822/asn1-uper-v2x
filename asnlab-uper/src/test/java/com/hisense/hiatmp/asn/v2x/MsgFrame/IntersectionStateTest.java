package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/21  20:42
 */
public class IntersectionStateTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{127, -69, 56, -59, -8, 0, 0, 102, -16, 12, -18, 78, 14, 0,
                -112, -8, 112, -128, 103, -128, 38, 112, 106, -7, 32, 112, -128, 103, 32};
        final IntersectionState intersectionState = IntersectionState
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(intersectionState);
    }


    @Test
    public void per_encode() {
    }
}