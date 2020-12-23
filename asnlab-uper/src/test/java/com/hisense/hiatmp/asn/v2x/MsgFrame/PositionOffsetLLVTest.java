package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author zhangyong
 * @date 2020/12/16  16:52
 */
public class PositionOffsetLLVTest {

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
        byte[] decodeBytes = new byte[]{-120, 22, -127, 81, 60};
        final PositionOffsetLLV positionOffsetLLV = PositionOffsetLLV.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(positionOffsetLLV);
    }
}