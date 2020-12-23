package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/21  15:55
 */
public class PhaseTest {
    Phase phase;

    @Before
    public void setUp() throws Exception {
        Phase.PhaseID id = new Phase.PhaseID(112);
        PhaseState.LightState light = PhaseState.LightState.flashing_green;
        DDateTime.TimeMark startTime = new DDateTime.TimeMark(3600);
        DDateTime.TimeMark minEndTime = new DDateTime.TimeMark(3312);
        DDateTime.TimeMark maxEndTime = new DDateTime.TimeMark(1230);
        DDateTime.TimeMark likelyEndTime = new DDateTime.TimeMark(3423);
        PathPrediction.Confidence timeConfidence = new PathPrediction.Confidence(36);
        DDateTime.TimeMark nextStartTime = new DDateTime.TimeMark(3600);
        DDateTime.TimeMark nextDuration = new DDateTime.TimeMark(3300);
        TimeCountingDown timeCountingDown = new TimeCountingDown(
                startTime,
                minEndTime,
                maxEndTime,
                likelyEndTime,
                timeConfidence,
                nextStartTime,
                nextDuration);
        final PhaseState.TimeChangeDetails counting = PhaseState.TimeChangeDetails.counting(timeCountingDown);
        PhaseState phaseState = new PhaseState(light, counting);
        Phase.PhaseStateList phaseStates = new Phase.PhaseStateList(phaseState);

        phase = new Phase(id, phaseStates);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(phase);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}