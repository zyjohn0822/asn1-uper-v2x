package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/21  16:37
 */
public class UTCTimingTest {

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{-8, 112, -128, 103, -128, 38, 112, 106, -7, 32, 112, -128, 103, 32};
        final UTCTiming utcTiming = UTCTiming.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(utcTiming);
    }

    @Test
    public void per_encode() {
    }
}