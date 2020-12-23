package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  13:54
 */
public class SteeringWheelAngleTest {

    @Test
    public void per_encode() {
    }

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{-115};
        final Integer integer = SteeringWheelAngle
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        Assert.assertEquals(integer.intValue(), 15);
    }
}