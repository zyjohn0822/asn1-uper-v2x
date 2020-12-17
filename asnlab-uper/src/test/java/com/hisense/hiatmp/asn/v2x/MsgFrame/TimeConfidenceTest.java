package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author zhangyong
 * @date 2020/12/17  14:55
 */
public class TimeConfidenceTest {

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{-100};
        final TimeConfidence timeConfidence = TimeConfidence
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(timeConfidence);
    }

    @Test
    public void per_encode() {
    }
}