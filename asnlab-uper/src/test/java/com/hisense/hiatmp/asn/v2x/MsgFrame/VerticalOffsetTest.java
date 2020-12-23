package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author zhangyong
 * @date 2020/12/16  16:36
 */
public class VerticalOffsetTest {

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
        byte[] decodedBytes = new byte[]{19, -64};
        final VerticalOffset verticalOffset = VerticalOffset.per_decode(false, new ByteArrayInputStream(decodedBytes));
        System.out.println(verticalOffset);
    }
}