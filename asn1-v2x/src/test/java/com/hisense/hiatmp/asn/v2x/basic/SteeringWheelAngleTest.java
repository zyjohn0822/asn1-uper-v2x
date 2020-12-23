package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:51
 */
public class SteeringWheelAngleTest {
    SteeringWheelAngle steeringWheelAngle;

    @Before
    public void setUp() throws Exception {
        steeringWheelAngle = new SteeringWheelAngle(15);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(steeringWheelAngle);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}