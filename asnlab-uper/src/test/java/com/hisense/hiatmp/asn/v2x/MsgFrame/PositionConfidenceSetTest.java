package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  14:07
 */
public class PositionConfidenceSetTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{-1, -128};
        final PositionConfidenceSet positionConfidenceSet = PositionConfidenceSet
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(positionConfidenceSet);
    }

    @Test
    public void per_encode() {
    }
}