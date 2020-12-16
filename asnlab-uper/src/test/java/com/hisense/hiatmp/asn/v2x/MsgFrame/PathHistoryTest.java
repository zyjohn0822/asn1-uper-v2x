package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import static org.junit.Assert.*;

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
    public void encode() throws Exception{
        byte[] decodeBytes = new byte[]{62, 0, 88, -127, 104, 21, 19, -64, -98, 3, -24, 40};
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
    public void decode() throws Exception{
    }
}