package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * @author zhangyong
 * @date 2020/12/16  17:15
 */
public class LightbarInUseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void encode() throws Exception{
    }
    @Test
    public void decode() throws Exception{
        byte[] decodeBytes = new byte[]{-96};
        LightbarInUse lightbarInUse = LightbarInUse.per_decode(false, new ByteArrayInputStream(decodeBytes));
        Assert.assertEquals(lightbarInUse.value(), 5);
    }
}