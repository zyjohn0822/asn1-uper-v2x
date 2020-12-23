package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.basic.*;
import com.hisense.hiatmp.asn.v2x.common.Utils;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyong
 * @date 2020/12/15  16:55
 */
public class SPATTest {
    SPAT spat;

    @Before
    public void setUp() throws Exception {
        MsgCount msgCount = new MsgCount(91);
        DDateTime.MinuteOfTheYear moy0 = new DDateTime.MinuteOfTheYear(513261);
        DDateTime.DSecond timestamp0 = new DDateTime.DSecond(50998);
        DescriptiveName name = null;
        //-----------------------------------------
        NodeReferenceID intersectionId = new NodeReferenceID(
                new NodeReferenceID.RoadRegulatorID(1),
                new NodeReferenceID.NodeID(33));
        List<Boolean> its = Arrays.asList(false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false);
        IntersectionState.IntersectionStatusObject intersectionStatusObject = new IntersectionState.IntersectionStatusObject(its);
        DDateTime.MinuteOfTheYear moy = null;
        DDateTime.DSecond timestamp = null;
        TimeConfidence timeConfidence = null;


        //------------------------------------
        Phase.PhaseID id1 = new Phase.PhaseID(1);
        PhaseState.LightState light1 = PhaseState.LightState.red;
        DDateTime.TimeMark startTime1 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime1 = new DDateTime.TimeMark(870);
        TimeCountingDown timeCountingDown1 = new TimeCountingDown(
                startTime1,
                null,
                null,
                likelyEndTime1,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting1 = PhaseState.TimeChangeDetails.counting(timeCountingDown1);
        PhaseState phaseState1 = new PhaseState(light1, counting1);


        Phase.PhaseID id2 = new Phase.PhaseID(2);
        PhaseState.LightState light2 = PhaseState.LightState.red;
        DDateTime.TimeMark startTime2 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime2 = new DDateTime.TimeMark(870);
        TimeCountingDown timeCountingDown2 = new TimeCountingDown(
                startTime2,
                null,
                null,
                likelyEndTime2,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting2 = PhaseState.TimeChangeDetails.counting(timeCountingDown2);
        PhaseState phaseState2 = new PhaseState(light2, counting2);

        Phase.PhaseID id3 = new Phase.PhaseID(3);
        PhaseState.LightState light3 = PhaseState.LightState.permissive_green;
        DDateTime.TimeMark startTime3 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime3 = new DDateTime.TimeMark(0);
        TimeCountingDown timeCountingDown3 = new TimeCountingDown(
                startTime3,
                null,
                null,
                likelyEndTime3,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting3 = PhaseState.TimeChangeDetails.counting(timeCountingDown3);
        PhaseState phaseState3 = new PhaseState(light3, counting3);

        Phase.PhaseID id4 = new Phase.PhaseID(5);
        PhaseState.LightState light4 = PhaseState.LightState.red;
        DDateTime.TimeMark startTime4 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime4 = new DDateTime.TimeMark(530);
        TimeCountingDown timeCountingDown4 = new TimeCountingDown(
                startTime4,
                null,
                null,
                likelyEndTime4,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting4 = PhaseState.TimeChangeDetails.counting(timeCountingDown4);
        PhaseState phaseState4 = new PhaseState(light4, counting4);

        Phase.PhaseID id5 = new Phase.PhaseID(6);
        PhaseState.LightState light5 = PhaseState.LightState.red;
        DDateTime.TimeMark startTime5 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime5 = new DDateTime.TimeMark(530);
        TimeCountingDown timeCountingDown5 = new TimeCountingDown(
                startTime5,
                null,
                null,
                likelyEndTime5,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting5 = PhaseState.TimeChangeDetails.counting(timeCountingDown5);
        PhaseState phaseState5 = new PhaseState(light5, counting5);

        Phase.PhaseID id6 = new Phase.PhaseID(7);
        PhaseState.LightState light6 = PhaseState.LightState.permissive_green;
        DDateTime.TimeMark startTime6 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime6 = new DDateTime.TimeMark(0);
        TimeCountingDown timeCountingDown6 = new TimeCountingDown(
                startTime6,
                null,
                null,
                likelyEndTime6,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting6 = PhaseState.TimeChangeDetails.counting(timeCountingDown6);
        PhaseState phaseState6 = new PhaseState(light6, counting6);


        Phase.PhaseID id7 = new Phase.PhaseID(9);
        PhaseState.LightState light7 = PhaseState.LightState.permissive_green;
        DDateTime.TimeMark startTime7 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime7 = new DDateTime.TimeMark(140);
        TimeCountingDown timeCountingDown7 = new TimeCountingDown(
                startTime7,
                null,
                null,
                likelyEndTime7,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting7 = PhaseState.TimeChangeDetails.counting(timeCountingDown7);
        PhaseState phaseState7 = new PhaseState(light7, counting7);


        Phase.PhaseID id8 = new Phase.PhaseID(10);
        PhaseState.LightState light8 = PhaseState.LightState.permissive_green;
        DDateTime.TimeMark startTime8 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime8 = new DDateTime.TimeMark(140);
        TimeCountingDown timeCountingDown8 = new TimeCountingDown(
                startTime8,
                null,
                null,
                likelyEndTime8,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting8 = PhaseState.TimeChangeDetails.counting(timeCountingDown8);
        PhaseState phaseState8 = new PhaseState(light8, counting8);

        Phase.PhaseID id9 = new Phase.PhaseID(11);
        PhaseState.LightState light9 = PhaseState.LightState.permissive_green;
        DDateTime.TimeMark startTime9 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime9 = new DDateTime.TimeMark(0);
        TimeCountingDown timeCountingDown9 = new TimeCountingDown(
                startTime9,
                null,
                null,
                likelyEndTime9,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting9 = PhaseState.TimeChangeDetails.counting(timeCountingDown9);
        PhaseState phaseState9 = new PhaseState(light9, counting9);

        Phase.PhaseID id10 = new Phase.PhaseID(13);
        PhaseState.LightState light10 = PhaseState.LightState.red;
        DDateTime.TimeMark startTime10 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime10 = new DDateTime.TimeMark(170);
        TimeCountingDown timeCountingDown10 = new TimeCountingDown(
                startTime10,
                null,
                null,
                likelyEndTime10,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting10 = PhaseState.TimeChangeDetails.counting(timeCountingDown10);
        PhaseState phaseState10 = new PhaseState(light10, counting10);


        Phase.PhaseID id11 = new Phase.PhaseID(14);
        PhaseState.LightState light11 = PhaseState.LightState.red;
        DDateTime.TimeMark startTime11 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime11 = new DDateTime.TimeMark(170);
        TimeCountingDown timeCountingDown11 = new TimeCountingDown(
                startTime11,
                null,
                null,
                likelyEndTime11,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting11 = PhaseState.TimeChangeDetails.counting(timeCountingDown11);
        PhaseState phaseState11 = new PhaseState(light11, counting11);

        Phase.PhaseID id12 = new Phase.PhaseID(15);
        PhaseState.LightState light12 = PhaseState.LightState.red;
        DDateTime.TimeMark startTime12 = new DDateTime.TimeMark(0);
        DDateTime.TimeMark likelyEndTime12 = new DDateTime.TimeMark(0);
        TimeCountingDown timeCountingDown12 = new TimeCountingDown(
                startTime12,
                null,
                null,
                likelyEndTime12,
                null,
                null,
                null);
        final PhaseState.TimeChangeDetails counting12 = PhaseState.TimeChangeDetails.counting(timeCountingDown12);
        PhaseState phaseState12 = new PhaseState(light12, counting12);


        Phase.PhaseStateList phaseStates1 = new Phase.PhaseStateList(phaseState1);
        Phase phase1 = new Phase(id1, phaseStates1);

        Phase.PhaseStateList phaseStates2 = new Phase.PhaseStateList(phaseState2);
        Phase phase2 = new Phase(id2, phaseStates2);

        Phase.PhaseStateList phaseStates3 = new Phase.PhaseStateList(phaseState3);
        Phase phase3 = new Phase(id3, phaseStates3);

        Phase.PhaseStateList phaseStates4 = new Phase.PhaseStateList(phaseState4);
        Phase phase4 = new Phase(id4, phaseStates4);

        Phase.PhaseStateList phaseStates5 = new Phase.PhaseStateList(phaseState5);
        Phase phase5 = new Phase(id5, phaseStates5);

        Phase.PhaseStateList phaseStates6 = new Phase.PhaseStateList(phaseState6);
        Phase phase6 = new Phase(id6, phaseStates6);

        Phase.PhaseStateList phaseStates7 = new Phase.PhaseStateList(phaseState7);
        Phase phase7 = new Phase(id7, phaseStates7);

        Phase.PhaseStateList phaseStates8 = new Phase.PhaseStateList(phaseState8);
        Phase phase8 = new Phase(id8, phaseStates8);

        Phase.PhaseStateList phaseStates9 = new Phase.PhaseStateList(phaseState9);
        Phase phase9 = new Phase(id9, phaseStates9);

        Phase.PhaseStateList phaseStates10 = new Phase.PhaseStateList(phaseState10);
        Phase phase10 = new Phase(id10, phaseStates10);

        Phase.PhaseStateList phaseStates11 = new Phase.PhaseStateList(phaseState11);
        Phase phase11 = new Phase(id11, phaseStates11);

        Phase.PhaseStateList phaseStates12 = new Phase.PhaseStateList(phaseState12);
        Phase phase12 = new Phase(id12, phaseStates12);


        IntersectionState.PhaseList phaseList = new IntersectionState.PhaseList(phase1, phase2, phase3, phase4, phase5, phase6, phase7, phase8, phase9, phase10, phase11, phase12);

        IntersectionState intersectionState = new IntersectionState(intersectionId,
                intersectionStatusObject,
                null,
                null,
                null,
                phaseList);
        SPAT.IntersectionStateList intersectionStates = new SPAT.IntersectionStateList(intersectionState);
        spat = new SPAT(
                msgCount,
                moy0,
                timestamp0,
                null,
                intersectionStates
        );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(spat);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
        String hex = "";
        final byte[] bytes = Utils.bytesFromHexString(hex);
        byte[] decodeBytes = new byte[]{107, 111, -87, -37, -114, 108, 0, -128, 0, -128, 16, -126, -128, 88, 8, 35, 0, 0, 0, 6, -52, 4, 8, -64, 0, 0, 1, -77, 1, -126, 80, 0, 0, 0, 0, 0, -96, -116, 0, 0, 0, 16, -112, 48, 35, 0, 0, 0, 4, 36, 14, 9, 64, 0, 0, 0, 0, 4, -126, 80, 0, 0, 0, 17, -127, 64, -108, 0, 0, 0, 4, 96, 88, 37, 0, 0, 0, 0, 0, 26, 8, -64, 0, 0, 0, 85, 7, 2, 48, 0, 0, 0, 21, 65, -32, -108, 0, 0, 0, 0, 0};
        final SPAT decode = UperEncoder.decode(decodeBytes, SPAT.class);
        System.out.println(decode);
    }

}