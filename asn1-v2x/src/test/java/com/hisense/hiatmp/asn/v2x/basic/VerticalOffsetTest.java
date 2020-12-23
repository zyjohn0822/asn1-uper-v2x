package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:53
 */
public class VerticalOffsetTest {
    VerticalOffset verticalOffset;

    @Before
    public void setUp() throws Exception {
        VerticalOffset.VertOffset_B07 vertOffsetB07 = new VerticalOffset.VertOffset_B07(15);
        verticalOffset = VerticalOffset.offset1(vertOffsetB07);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(verticalOffset);
        System.out.println(Arrays.toString(encode));

    }

    @Test
    public void decode() throws Exception {

    }
}