package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author zhangyong
 * @date 2020/12/16  17:05
 */
public class ResponseTypeTest {

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
        byte[] decodeBytes = new byte[]{32};
        final ResponseType responseType = ResponseType.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(responseType);
    }
}