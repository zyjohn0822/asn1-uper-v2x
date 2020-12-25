package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.basic.*;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * RoadSideInformation ::= SEQUENCE {<br/>
 * msgCnt MsgCount,<br/>
 * moy MinuteOfTheYear OPTIONAL,<br/>
 * id OCTET STRING (SIZE(8)),<br/>
 * -- RSU ID<br/>
 * refPos Position3D,<br/>
 * -- Reference position of this RSI message<br/>
 * rtes RTEList OPTIONAL,<br/>
 * -- All the rte data packed in this message<br/>
 * rtss RTSList OPTIONAL,<br/>
 * -- All the rts data packed in this message<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/10  16:21
 */
@Getter
@Setter
@Sequence
@HasExtensionMarker
public class RoadSideInformation implements AsnV2x{
    @Component(0)
    public MsgCount msgCount;
    @Asn1Optional
    @Component(1)
    public DDateTime.MinuteOfTheYear moy;
    @Component(2)
    public ID id;
    @Component(3)
    public Position3D refPos;
    @Component(4)
    @Asn1Optional
    public RTEList rtes;
    @Component(5)
    @Asn1Optional
    public RTSList rtss;

    public RoadSideInformation() {
    }

    public RoadSideInformation(MsgCount msgCount, ID id, Position3D refPos, RTEList rtes, RTSList rtss) {
        this.msgCount = msgCount;
        this.id = id;
        this.refPos = refPos;
        this.rtes = rtes;
        this.rtss = rtss;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"msgCount\":")
                .append(msgCount);
        sb.append(",\"id\":")
                .append(id);
        sb.append(",\"refPos\":")
                .append(refPos);
        sb.append(",\"rtes\":")
                .append(rtes);
        sb.append(",\"rtss\":")
                .append(rtss);
        sb.append('}');
        return sb.toString();
    }

    /**
     * RTEList ::= SEQUENCE (SIZE(1..8)) OF RTEData
     */
    @SizeRange(minValue = 1, maxValue = 8)
    public static class RTEList extends Asn1SequenceOf<RTEData> {
        public RTEList(RTEData... dataList) {
            this(Arrays.asList(dataList));
        }

        public RTEList(Collection<RTEData> coll) {
            super(coll);
        }
    }

    /**
     * RTSList ::= SEQUENCE (SIZE(1..16)) OF RTSData
     */
    @SizeRange(minValue = 1, maxValue = 16)
    public static class RTSList extends Asn1SequenceOf<RTSData> {
        public RTSList(RTSData... dataList) {
            this(Arrays.asList(dataList));
        }

        public RTSList(Collection<RTSData> coll) {
            super(coll);
        }
    }
}
