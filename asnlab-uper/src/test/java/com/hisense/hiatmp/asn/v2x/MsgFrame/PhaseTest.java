package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/21  17:45
 */
public class PhaseTest {

    @Test
    public void per_decode() {
    }

    @Test
    public void per_encode() throws IOException {
        byte[] decodeBytes = new byte[]{112, 4, -121, -61, -124, 3, 60, 1, 51, -125, 87, -55, 3, -124, 3, 57, 0};
        final Phase phase = Phase.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(phase);
    }
}