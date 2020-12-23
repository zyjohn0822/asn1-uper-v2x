package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyong
 * @date 2020/12/17  15:07
 */
public class IDTest {
    @Test
    public void encode() throws Exception {
        List<Byte> bs = Arrays.asList(
                (byte) 48,
                (byte) 48,
                (byte) 49,
                (byte) 52,
                (byte) 51,
                (byte) 49,
                (byte) 48,
                (byte) 49);
        ID id = new ID(bs);
        final byte[] encode = UperEncoder.encode(id);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
        byte[] decs = new byte[]{24, 24, 24, -102, 25, -104, -104, 24, -128};
        final ID decode = UperEncoder.decode(decs, ID.class);
        System.out.println(decode);
    }
}
