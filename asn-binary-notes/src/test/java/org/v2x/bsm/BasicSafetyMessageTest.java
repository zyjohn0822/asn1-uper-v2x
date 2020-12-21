package org.v2x.bsm;

import org.bn.CoderFactory;
import org.bn.utils.BitArrayInputStream;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author zhangyong
 * @date 2020/12/12  16:02
 */
public class BasicSafetyMessageTest {
    @Test
    public void encodeTest() {

    }

    @Test
    public void decodeTest() throws Exception {
        String hex = "2A463030313433313031B7F3E046689A37C0AE91F0E214D13030303300000617388D07D507D07F7FFF808000B401F4003648000000";

        byte[] bs = new byte[]{42, 70, 96, 96, 98, 104, 102, 98, 96, 99, 111, -25, -116, -47,
                52, 111, 93, 35, -31, -60, 41, -94, 96, 96, 96, 102, 0, 12, 92, -30, 53, -11,
                95, 65, -3, -1, -2, 2, 45, 7, -48, 54, 72, 0, 0, 0};
        final ByteArrayInputStream in = new ByteArrayInputStream(bs);
        BitArrayInputStream bin = new BitArrayInputStream(in);
        final BasicSafetyMessage decode = CoderFactory
                .getInstance()
                .newDecoder("PER/Unaligned")
                .decode(bin, BasicSafetyMessage.class);
        System.out.println(decode);
    }
}