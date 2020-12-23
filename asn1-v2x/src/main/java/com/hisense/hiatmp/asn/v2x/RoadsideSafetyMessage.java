package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.basic.ID;
import com.hisense.hiatmp.asn.v2x.basic.MsgCount;
import com.hisense.hiatmp.asn.v2x.basic.ParticipantData;
import com.hisense.hiatmp.asn.v2x.basic.Position3D;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * RoadsideSafetyMessage ::= SEQUENCE {
 * msgCnt MsgCount,
 * id OCTET STRING (SIZE(8)),
 * -- RSU ID
 * refPos Position3D,
 * -- Reference position of this RSM message
 * participants ParticipantList,
 * -- All or part of the participants
 * -- detected by RSU
 * ...
 * }
 *
 * @author zhangyong
 */
@Getter
@Setter
@Sequence
@HasExtensionMarker
public class RoadsideSafetyMessage {
    @Component(0)
    MsgCount msgCount;
    @Component(1)
    ID id;
    @Component(2)
    Position3D refPos;
    @Component(3)
    ParticipantList participants;

    /**
     * ParticipantList ::= SEQUENCE (SIZE(1..16)) OF ParticipantData
     */
    @SizeRange(minValue = 1, maxValue = 16)
    public static class ParticipantList extends Asn1SequenceOf<ParticipantData> {
        public ParticipantList(ParticipantData... dataList) {
            this(Arrays.asList(dataList));
        }

        public ParticipantList(Collection<ParticipantData> coll) {
            super(coll);
        }
    }
}
