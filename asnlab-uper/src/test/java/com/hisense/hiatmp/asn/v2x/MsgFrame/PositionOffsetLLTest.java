package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/16  16:27
 */
public class PositionOffsetLLTest {
    PositionOffsetLL positionOffsetLL;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() {

    }

    @Test
    public void decode() throws IOException {
        byte[] encode = new byte[]{16, 45, 2, -96};
        positionOffsetLL = PositionOffsetLL.per_decode(false, new ByteArrayInputStream(encode));
        System.out.println(positionOffsetLL);
    }
}