package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  14:55
 */
public class TimeConfidenceTest {

    @Test
    public void per_decode() throws IOException {
        //-112  -100
        byte[] decodeBytes = new byte[]{-112};
        final TimeConfidence timeConfidence = TimeConfidence
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(timeConfidence);
    }

    @Test
    public void per_encode() {
    }
}