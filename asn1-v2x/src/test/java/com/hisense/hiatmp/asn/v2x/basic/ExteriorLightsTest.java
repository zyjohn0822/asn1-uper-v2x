package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyong
 * @date 2020/12/15  16:32
 */
public class ExteriorLightsTest {
    @Test
    public void encode() throws Exception {
        final List<Boolean> booleans = Arrays.asList(false, false, false, true, true, true, false, false, false);
        ExteriorLights exteriorLights = new ExteriorLights(booleans);
        final byte[] encode = UperEncoder.encode(exteriorLights);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {

    }
}