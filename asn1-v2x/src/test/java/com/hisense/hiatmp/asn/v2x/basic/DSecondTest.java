package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/18  14:06
 */
public class DSecondTest {
    @Test
    public void encode() throws Exception {
        DDateTime.DSecond secMark = new DDateTime.DSecond(47091);
        System.out.println(Arrays.toString(UperEncoder.encode(secMark)));
    }

    @Test
    public void decode() throws Exception {
    }
}
