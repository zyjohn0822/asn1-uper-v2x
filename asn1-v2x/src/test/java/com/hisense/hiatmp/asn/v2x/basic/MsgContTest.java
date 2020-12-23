package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/18  14:16
 */
public class MsgContTest {
    @Test
    public void encode() throws Exception {
        MsgCount msgCount = new MsgCount(35);
        final byte[] encode = UperEncoder.encode(msgCount);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}
