package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.basic.ID;
import com.hisense.hiatmp.asn.v2x.basic.MsgCount;
import com.hisense.hiatmp.asn.v2x.basic.Position3D;
import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.Sequence;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author zhangyong
 * @date 2020/11/10  16:21
 */
@Sequence
public class RoadsideSafetyMessage {
    MsgCount msgCount;
    ID id;
    Position3D refPos;
    RTEList rtes;


    private class RTEList {
    }
}
