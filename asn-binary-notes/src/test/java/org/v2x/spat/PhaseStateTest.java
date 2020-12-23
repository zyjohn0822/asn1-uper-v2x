package org.v2x.spat;

import org.bn.CoderFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author zhangyong
 * @date 2020/12/21  17:09
 */
public class PhaseStateTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
    }

    @Test
    public void decode() throws Exception {
        byte[] decodeBytes = new byte[]{72, -8, 112, -128, 103, -128, 38, 112, 106, -7, 32, 112, -128, 103, 32};
        final PhaseState decode = CoderFactory
                .getInstance()
                .newDecoder("PER/Unaligned")
                .decode(new ByteArrayInputStream(decodeBytes), PhaseState.class);
        System.out.println(decode);
    }
}