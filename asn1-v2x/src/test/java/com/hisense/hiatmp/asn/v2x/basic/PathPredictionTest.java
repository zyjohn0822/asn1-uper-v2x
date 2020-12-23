package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:36
 */
public class PathPredictionTest {
    PathPrediction pathPrediction;

    @Before
    public void setUp() throws Exception {
        pathPrediction = new PathPrediction(new PathPrediction.RadiusOfCurvature(3276),
                new PathPrediction.Confidence(100));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(pathPrediction);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}