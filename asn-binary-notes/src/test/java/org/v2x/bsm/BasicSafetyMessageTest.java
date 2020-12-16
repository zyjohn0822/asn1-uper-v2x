package org.v2x.bsm;

import com.k_int.codec.comp.AsnParser;
import org.bn.CoderFactory;
import org.bn.utils.BitArrayInputStream;
import org.bn.utils.Utils;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * @author zhangyong
 * @date 2020/12/12  16:02
 */
public class BasicSafetyMessageTest {
    @Test
    public void encodeTest(){

    }
    @Test
    public void decodeTest() throws Exception {
        String hex = "2A463030313433313031B7F3E046689A37C0AE91F0E214D13030303300000617388D07D507D07F7FFF808000B401F4003648000000";

        byte[] bytes = new byte[]{42, 70, 48, 48, 49, 52, 51, 49, 48, 49, -73, -13, -32, 70, 104, -102, 55, -64, -82, -111, -16, -30, 20, -47, 48, 48, 48, 51, 0, 0, 6, 23, 56, -115, 7, -43, 7, -48, 127, 127, -1, -128, -128, 0, -76, 1, -12, 0, 54, 72, 0, 0, 0};
        final ByteArrayInputStream in = new ByteArrayInputStream(Utils.bytesFromHexString(hex));
//        BitArrayInputStream bin = new BitArrayInputStream(in);
//        final BasicSafetyMessage decode = CoderFactory
//                .getInstance()
//                .newDecoder("PER/Unaligned")
//                .decode(bin, BasicSafetyMessage.class);
//        System.out.println(decode);
        AsnParser asnParser = new AsnParser(in);
        System.out.println(asnParser);
    }
}