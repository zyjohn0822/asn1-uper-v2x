package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author zhangyong
 * @date 2020/12/17  10:09
 */
public class PathPredictionTest {

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
        byte[] decodeBytes = new byte[]{70, 101, -78, 0};
        final PathPrediction pathPrediction = PathPrediction
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        Assert.assertEquals(pathPrediction.radiusOfCurve.intValue(), 3276);
        Assert.assertEquals(pathPrediction.confidence.intValue(), 100);
    }
}