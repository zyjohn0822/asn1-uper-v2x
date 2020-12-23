package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author zhangyong
 * @date 2020/12/17  10:21
 */
public class ExteriorLightsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        byte[] decodeBytes = new byte[]{14, 0};
        final ExteriorLights exteriorLights = ExteriorLights.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(exteriorLights);
        Assert.assertEquals(exteriorLights.toString(), "\"000111000\"");
    }

    @Test
    public void decode() throws Exception {
    }
}