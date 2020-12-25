package com.hisense.hiatmp.asn.v2x.MsgFrame;

import com.hisense.hiatmp.asn.common.Utils;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/21  21:36
 */
public class SPATTest {

    @Test
    public void per_decode() throws IOException {
        byte[] decodeBytes = new byte[]{107, 111, -87, -37, -114, 108, 0, -128, 0, -128, 16, -126, -128, 96, 8, 35, 0, 0, 0, 6, -52, 4, 8, -64, 0, 0, 1, -77, 1, -126, 80, 0, 0, 0, 0, 0, -96, -116, 0, 0, 0, 16, -112, 48, 35, 0, 0, 0, 6, -52, 14, 9, 64, 0, 0, 0, 0, 4, -126, 80, 0, 0, 0, 17, -127, 64, -108, 0, 0, 0, 4, 96, 88, 37, 0, 0, 0, 0, 0, 26, 8, -64, 0, 0, 0, 85, 7, 2, 48, 0, 0, 0, 21, 65, -64, -116, 0, 0, 0, 5, 80, 120, 37, 0, 0, 0, 0, 0
        };
        final SPAT spat = SPAT.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(spat);

    }

    @Test
    public void per_encode() throws IOException {
        String hex = "36B6FA9DB8E6C0080008010828058082300000006CC0408C0000001B30182500000000000A08C0000001090302300000004240E094000000000048250000000118140940000000460582500000000001A08C0000000550702300000001541E09400000000000";
        String hex2 = "3706FC04CDEF853060C183060C183060C001000100C1040030224604000002D0000100100B400B40000400402D002D00000209281000000B40000400402D002D0000100100B400B400000A24604000002D0000100100B400B40000400402D002D00000409281000000B40000400402D002D0000100100B400B400000";
        final byte[] bytes = Utils.bytesFromHexString(hex2);
        final MessageFrame messageFrame = MessageFrame.per_decode(false, new ByteArrayInputStream(bytes));
        final SPAT spat = messageFrame.spatFrame;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        messageFrame.spatFrame.per_encode(false, outputStream);
        System.out.println(messageFrame.spatFrame);
        //System.out.println(Arrays.toString(outputStream.toByteArray()));
    }

}