package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  13:49
 */
public class MotionConfidenceSetTest {

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{-9, -96};
        final MotionConfidenceSet motionConfidenceSet = MotionConfidenceSet
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(motionConfidenceSet);
    }

    @Test
    public void per_encode() {
    }
}