package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/21  17:15
 */
public class PhaseStateTest {
    PhaseState phaseState;

    @Before
    public void setUp() throws Exception {
        phaseState = new PhaseState();
        phaseState.light = LightState.flashing_green;
        TimeCountingDown countingDown = new TimeCountingDown();
        countingDown.startTime = 3600;
        countingDown.minEndTime = 3312;
        countingDown.maxEndTime = 1230;
        countingDown.likelyEndTime = 3423;
        countingDown.timeConfidence = 36;
        countingDown.nextStartTime = 3600;
        countingDown.nextDuration = 3300;
        phaseState.timing = TimeChangeDetails.counting(countingDown);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{72, 124, 56, 64, 51, -64, 19, 56, 53, 124, -112, 56, 64, 51, -112};
        final PhaseState p = PhaseState.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(p);
    }

    @Test
    public void per_encode() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        phaseState.per_encode(false, out);
        System.out.println(Arrays.toString(out.toByteArray()));
    }
}