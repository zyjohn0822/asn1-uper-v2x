package org.v2x.time;

import org.bn.CoderFactory;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/19  22:05
 */
public class TimeConfidenceTest {
    @Test
    public void encode() throws Exception {
        TimeConfidence.EnumType enumType = TimeConfidence.EnumType.time_000_000_000_000_1;
        TimeConfidence timeConfidence = new TimeConfidence();
        timeConfidence.setValue(enumType);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CoderFactory.getInstance().newEncoder("PER/Unaligned").encode(timeConfidence, outputStream);
        System.out.println(Arrays.toString(outputStream.toByteArray()));
    }

    @Test
    public void decode() throws Exception {
        byte[] decode = new byte[]{};
        final TimeConfidence timeConfidence = CoderFactory
                .getInstance()
                .newDecoder("PER/Unaligned")
                .decode(new ByteArrayInputStream(decode), TimeConfidence.class);
        System.out.println(timeConfidence.getValue().ordinal());
    }
}