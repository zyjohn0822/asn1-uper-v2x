package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:46
 */
public class ResponseTypeTest {
    ResponseType responseType = ResponseType.nonEmergency;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(responseType);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
        final ResponseType decode = UperEncoder.decode(new byte[]{32}, ResponseType.class);
        System.out.println(decode);
    }
}