package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.DDateTime.TimeMark;
import com.hisense.hiatmp.asn.v2x.basic.PathPrediction.Confidence;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/21  15:56
 */
public class TimeCountingDownTest {
    TimeCountingDown timeCountingDown;

    @Before
    public void setUp() throws Exception {
        TimeMark startTime = new TimeMark(3600);
        TimeMark minEndTime = new TimeMark(3312);
        TimeMark maxEndTime = new TimeMark(1230);
        TimeMark likelyEndTime = new TimeMark(3423);
        Confidence timeConfidence = new Confidence(36);
        TimeMark nextStartTime = new TimeMark(3600);
        TimeMark nextDuration = new TimeMark(3300);
        timeCountingDown = new TimeCountingDown(
                startTime,
                minEndTime,
                maxEndTime,
                likelyEndTime,
                timeConfidence,
                nextStartTime,
                nextDuration);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(timeCountingDown);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
        byte[] decodeBytes = new byte[]{-8, 112, -128, 103, -128, 38, 112, 106, -7, 32, 112, -128, 103, 32};
        final TimeCountingDown decode = UperEncoder.decode(decodeBytes, TimeCountingDown.class);
        System.out.println(decode);
    }
}