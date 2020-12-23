package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/17  0:28
 */
public class PathHistoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void name() {
    }

    @Test
    public void encode() throws Exception {
        byte[] decodeBytes = new byte[]{96, 4, 104, -100, 39, 91, 47, 61, 17, -1, 0, 44, 64, -76, 10, -119, -32, 79, 1, -12, 20};
        final PathHistory pathHistory = PathHistory.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(pathHistory);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        pathHistory.per_encode(false, outputStream);
        final byte[] bytes = outputStream.toByteArray();
        System.out.println(Arrays.toString(decodeBytes));
        System.out.println(Arrays.toString(bytes));
        Assert.assertArrayEquals(decodeBytes, bytes);
    }

    @Test
    public void decode() throws Exception {
    }
}