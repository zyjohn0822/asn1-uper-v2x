package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/18  14:07
 */
public class BasicSafetyMessageTest {

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{42, 70, 48, 48, 49, 52, 51, 49, 48, 49, -73, -13,
                -58, 104, -102, 55, -82, -111, -16, -30, 20, -47, 48, 48, 48, 51,
                0, 6, 46, 113, 26, -6, -81, -96, -2, -1, -1, 1,
                22, -125, -24, 0, 36, 0, 0, 0};
        final BasicSafetyMessage basicSafetyMessage = BasicSafetyMessage
                .per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(basicSafetyMessage);
    }

    @Test
    public void per_encode() {
    }
}