package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.common.Utils;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhangyong
 * @date 2020/12/15  16:54
 */
public class MessageFrameTest {

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
        String bsmFrameHex = "02a4660606268666260636fe78cd1346f5d23e1c429a260606066000c5ce235f55f41fdfffe022d07d036480000000";
        String spatFrameHex = "36B6FA9DB8E6C0080008010828058082300000006CC0408C0000001B30182500000000000A08C0000001090302300000004240E094000000000048250000000118140940000000460582500000000001A08C0000000550702300000001541E09400000000000";
        String spatFrameH = "3716FC899099A53060C183060C183060C001000100B8040070424604000004D80001001013601360000400404D804D800001491810000008C00004004023002300001001008C008C00000624A04000001B80001001006E006E0000400401B801B80000249181000001360000400404D804D800010010136013600000C24604000004D80001001013601360000400404D804D800003491810000008C00004004023002300001001008C008C00000E24A04000001B80001001006E006E0000400401B801B8000040928100000050000040040140014000010010050005000000";
        final MessageFrame bsmDecode = UperEncoder.decode(Utils.bytesFromHexString(bsmFrameHex), MessageFrame.class);
        final MessageFrame spatDecode = UperEncoder.decode(Utils.bytesFromHexString(spatFrameH), MessageFrame.class);
        System.out.println(bsmDecode);
        System.out.println(spatDecode);
    }
}