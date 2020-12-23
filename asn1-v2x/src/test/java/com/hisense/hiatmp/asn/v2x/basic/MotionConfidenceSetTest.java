package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.hisense.hiatmp.asn.v2x.basic.MotionConfidenceSet.*;

/**
 * @author zhangyong
 * @date 2020/12/15  16:35
 */
public class MotionConfidenceSetTest {
    MotionConfidenceSet motionConfidenceSet;

    @Before
    public void setUp() throws Exception {
        motionConfidenceSet = new MotionConfidenceSet(
                SpeedConfidence.prec0_05deg,
                HeadingConfidence.prec0_01ms,
                SteeringWheelAngleConfidence.prec2deg
        );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(motionConfidenceSet);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}