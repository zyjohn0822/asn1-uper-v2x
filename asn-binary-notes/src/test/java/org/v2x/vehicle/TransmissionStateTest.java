package org.v2x.vehicle;

import org.bn.CoderFactory;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/12  18:20
 */
public class TransmissionStateTest {
    @Test
    public void encodeTest() throws Exception {
        TransmissionState transmissionState = new TransmissionState();
        transmissionState.setValue(TransmissionState.EnumType.forwardGears);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CoderFactory.getInstance().newEncoder("PER/Unaligned").encode(transmissionState, out);
        System.out.println(Arrays.toString(out.toByteArray()));
        final TransmissionState decode = CoderFactory.getInstance().newDecoder("PER/Unaligned")
                .decode(new ByteArrayInputStream(out.toByteArray()), TransmissionState.class);
        System.out.println(decode);
    }
}