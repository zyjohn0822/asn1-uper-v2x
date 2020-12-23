package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:38
 */
public class PositionOffsetLLTest {
    PositionOffsetLL positionOffsetLL;

    @Before
    public void setUp() throws Exception {
        PositionOffsetLL.OffsetLLB12 offsetLLB12 = new PositionOffsetLL.OffsetLLB12(22);
        PositionOffsetLL.OffsetLLB12 offsetLLB121 = new PositionOffsetLL.OffsetLLB12(21);
        final PositionOffsetLL.PositionLL24B positionLL24B = new PositionOffsetLL.PositionLL24B(offsetLLB12, offsetLLB121);
        positionOffsetLL = PositionOffsetLL.positionLL1(positionLL24B);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() {
        final byte[] encode = UperEncoder.encode(positionOffsetLL);
        System.out.println(Arrays.toString(encode));
    }
}