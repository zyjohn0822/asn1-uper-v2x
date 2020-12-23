package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.hisense.hiatmp.asn.v2x.basic.PositionConfidenceSet.ElevationConfidence;
import static com.hisense.hiatmp.asn.v2x.basic.PositionConfidenceSet.PositionConfidence;

/**
 * @author zhangyong
 * @date 2020/12/15  16:37
 */
public class PositionConfidenceSetTest {
    PositionConfidenceSet positionConfidenceSet;

    @Before
    public void setUp() throws Exception {
        PositionConfidence positionConfidence = PositionConfidence.a1cm;
        ElevationConfidence elevationConfidence = ElevationConfidence.elev_000_01;
        positionConfidenceSet = new PositionConfidenceSet(positionConfidence, elevationConfidence);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(positionConfidenceSet);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {

    }
}