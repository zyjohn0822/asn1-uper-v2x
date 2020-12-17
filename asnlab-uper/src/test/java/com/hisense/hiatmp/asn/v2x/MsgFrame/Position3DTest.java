package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zhangyong
 * @date 2020/12/17  14:37
 */
public class Position3DTest {

    @Test
    public void per_decode() throws IOException {
        //-58, 104, -102, 55, -82, -111, -16, -30, 20, -47
        //has marker 99, 52, 77, 27, -41, 72, -8, 113, 10, 104, -128
        byte[] decodeBytes = new byte[]{99, 52, 77, 27, -41, 72, -8, 113, 10, 104, -128};
        Position3D position3D = Position3D.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(position3D);
    }

    @Test
    public void per_encode() throws IOException {
        Position3D position3D = new Position3D();
        position3D.lat = 281260343;
        position3D.long_ = 1128799971;
        position3D.elevation = 1233;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        position3D.per_encode(false, out);
        //-58, 104, -102, 55, -82, -111, -16, -30, 20, -47
        System.out.println(Arrays.toString(out.toByteArray()));
    }

}