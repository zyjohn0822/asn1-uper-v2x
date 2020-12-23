package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.PositionalAccuracy.SemiMajorAxisAccuracy;
import com.hisense.hiatmp.asn.v2x.basic.PositionalAccuracy.SemiMajorAxisOrientation;
import com.hisense.hiatmp.asn.v2x.basic.PositionalAccuracy.SemiMinorAxisAccuracy;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:37
 */
public class PositionalAccuracyTest {
    PositionalAccuracy positionalAccuracy;

    @Before
    public void setUp() throws Exception {
        SemiMajorAxisAccuracy semMajor = new SemiMajorAxisAccuracy(48);
        SemiMinorAxisAccuracy semiMinor = new SemiMinorAxisAccuracy(48);
        SemiMajorAxisOrientation orientation = new SemiMajorAxisOrientation(12339);
        positionalAccuracy = new PositionalAccuracy(semMajor, semiMinor, orientation);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(positionalAccuracy);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}