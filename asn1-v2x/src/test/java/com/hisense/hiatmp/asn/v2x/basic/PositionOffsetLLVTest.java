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
public class PositionOffsetLLVTest {
    PositionOffsetLLV positionOffsetLLV;

    @Before
    public void setUp() throws Exception {
        //positionOffsetLL
        PositionOffsetLL.OffsetLLB12 offsetLLB12 = new PositionOffsetLL.OffsetLLB12(22);
        PositionOffsetLL.OffsetLLB12 offsetLLB121 = new PositionOffsetLL.OffsetLLB12(21);
        final PositionOffsetLL.PositionLL24B positionLL24B = new PositionOffsetLL.PositionLL24B(offsetLLB12,
                offsetLLB121);
        PositionOffsetLL positionOffsetLL = PositionOffsetLL.positionLL1(positionLL24B);
        //verticalOffset
        VerticalOffset.VertOffset_B07 vertOffsetB07 = new VerticalOffset.VertOffset_B07(15);
        VerticalOffset verticalOffset = VerticalOffset.offset1(vertOffsetB07);

        //-----------
        positionOffsetLLV = new PositionOffsetLLV(positionOffsetLL, verticalOffset);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(positionOffsetLLV);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}