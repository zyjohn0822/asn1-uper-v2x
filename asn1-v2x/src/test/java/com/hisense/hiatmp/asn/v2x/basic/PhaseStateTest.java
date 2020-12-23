package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.DDateTime.TimeMark;
import com.hisense.hiatmp.asn.v2x.basic.PathPrediction.Confidence;
import com.hisense.hiatmp.asn.v2x.basic.PhaseState.LightState;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/21  15:55
 */
public class PhaseStateTest {
    PhaseState phaseState;

    @Before
    public void setUp() throws Exception {
        LightState light = LightState.flashing_green;

        TimeMark startTime = new TimeMark(3600);
        TimeMark minEndTime = new TimeMark(3312);
        TimeMark maxEndTime = new TimeMark(1230);
        TimeMark likelyEndTime = new TimeMark(3423);
        Confidence timeConfidence = new Confidence(36);
        TimeMark nextStartTime = new TimeMark(3600);
        TimeMark nextDuration = new TimeMark(3300);
        TimeCountingDown timeCountingDown = new TimeCountingDown(
                startTime,
                minEndTime,
                maxEndTime,
                likelyEndTime,
                timeConfidence,
                nextStartTime,
                nextDuration);
        final PhaseState.TimeChangeDetails counting = PhaseState.TimeChangeDetails.counting(timeCountingDown);
        phaseState = new PhaseState(light, counting);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(phaseState);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
        //72, 124, 56, 64, 51, -64, 19, 56, 53, 124, -112, 56, 64, 51, -112
        //72, -8, 112, -128, 103, -128, 38, 112, 106, -7, 32, 112, -128, 103, 32
        byte[] decodeBytes = new byte[]{72, 124, 56, 64, 51, -64, 19, 56, 53, 124, -112, 56, 64, 51, -112};
        final PhaseState decode = UperEncoder.decode(decodeBytes, PhaseState.class);
        System.out.println(decode);
    }
}