package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.DDateTime.DSecond;
import com.hisense.hiatmp.asn.v2x.basic.DDateTime.MinuteOfTheYear;
import com.hisense.hiatmp.asn.v2x.basic.IntersectionState.IntersectionStatusObject;
import com.hisense.hiatmp.asn.v2x.basic.IntersectionState.PhaseList;
import com.hisense.hiatmp.asn.v2x.basic.NodeReferenceID.NodeID;
import com.hisense.hiatmp.asn.v2x.basic.NodeReferenceID.RoadRegulatorID;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyong
 * @date 2020/12/21  15:54
 */
public class IntersectionStateTest {
    IntersectionState intersectionState;

    @Before
    public void setUp() throws Exception {
        NodeReferenceID intersectionId = new NodeReferenceID(
                new RoadRegulatorID(63335),
                new NodeID(6335));
        List<Boolean> its = Arrays.asList(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
        IntersectionStatusObject intersectionStatusObject = new IntersectionStatusObject(its);
        MinuteOfTheYear moy = new MinuteOfTheYear(52704);
        DSecond timestamp = new DSecond(6620);
        TimeConfidence timeConfidence = TimeConfidence.time_000_000_000_000_01;


        //------------------------------------
        Phase.PhaseID id = new Phase.PhaseID(112);
        PhaseState.LightState light = PhaseState.LightState.flashing_green;
        DDateTime.TimeMark startTime = new DDateTime.TimeMark(3600);
        DDateTime.TimeMark minEndTime = new DDateTime.TimeMark(3312);
        DDateTime.TimeMark maxEndTime = new DDateTime.TimeMark(1230);
        DDateTime.TimeMark likelyEndTime = new DDateTime.TimeMark(3423);
        PathPrediction.Confidence confidence = new PathPrediction.Confidence(36);
        DDateTime.TimeMark nextStartTime = new DDateTime.TimeMark(3600);
        DDateTime.TimeMark nextDuration = new DDateTime.TimeMark(3300);
        TimeCountingDown timeCountingDown = new TimeCountingDown(
                startTime,
                minEndTime,
                maxEndTime,
                likelyEndTime,
                confidence,
                nextStartTime,
                nextDuration);
        final PhaseState.TimeChangeDetails counting = PhaseState.TimeChangeDetails.counting(timeCountingDown);
        PhaseState phaseState = new PhaseState(light, counting);
        Phase.PhaseStateList phaseStates = new Phase.PhaseStateList(phaseState);

        Phase phase = new Phase(id, phaseStates);
        PhaseList phaseList = new PhaseList(phase);

        intersectionState = new IntersectionState(intersectionId,
                intersectionStatusObject,
                moy,
                timestamp,
                timeConfidence,
                phaseList);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(intersectionState);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
        byte[] decodeBytes = new byte[]{127, -69, 56, -59, -8, 0, 0, 102, -16, 12, -18, 78, 14, 0,
                -112, -8, 112, -128, 103, -128, 38, 112, 106, -7, 32, 112, -128, 103, 32};
        final IntersectionState decode = UperEncoder.decode(decodeBytes, IntersectionState.class);
        System.out.println(decode);
    }

}