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
 * RoadsideSafetyMessage ::= SEQUENCE {<br/>
 * msgCnt MsgCount,<br/>
 * id OCTET STRING (SIZE(8)),<br/>
 * -- RSU ID<br/>
 * refPos Position3D,<br/>
 * -- Reference position of this RSM message<br/>
 * participants ParticipantList,<br/>
 * -- All or part of the participants<br/>
 * -- detected by RSU<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 */
@Getter
@Setter
@Sequence
@HasExtensionMarker
public class RoadSideSafetyMessage implements AsnV2x{
    @Component(0)
    public MsgCount msgCount;
    @Component(1)
    public ID id;
    @Component(2)
    public Position3D refPos;
    @Component(3)
    public ParticipantList participants;

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
