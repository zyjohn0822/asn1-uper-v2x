package com.hisense.hiatmp.asn.v2x;

import com.hisense.hiatmp.asn.v2x.basic.DDateTime.DSecond;
import com.hisense.hiatmp.asn.v2x.basic.DDateTime.MinuteOfTheYear;
import com.hisense.hiatmp.asn.v2x.basic.DescriptiveName;
import com.hisense.hiatmp.asn.v2x.basic.IntersectionState;
import com.hisense.hiatmp.asn.v2x.basic.MsgCount;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * SignalPhaseAndTiming DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p>
 * -- imports and exports<br/>
 * </p>
 * EXPORTS SPAT;<br/>
 * IMPORTS MinuteOfTheYear FROM DefTime<br/>
 * DescriptiveName FROM MapNode<br/>
 * IntersectionStateList FROM SPATIntersectionState<br/>
 * MsgCount FROM MsgFrame<br/>
 * DSecond FROM DefTime;<br/>
 * <p>
 * SPAT ::= SEQUENCE {<br/>
 * msgCnt MsgCount,<br/>
 * moy MinuteOfTheYear OPTIONAL,<br/>
 * timeStamp DSecond OPTIONAL,<br/>
 * -- Time stamp when this message is formed<br/>
 * name DescriptiveName OPTIONAL,<br/>
 * -- human readable name for this collection<br/>
 * -- to be used only in debug mode<br/>
 * intersections IntersectionStateList,<br/>
 * -- sets of SPAT data (one per intersection)<br/>
 * ...<br/>
 * }<br/>
 * <p>
 * END<br/>
 *
 * @author zhangyong
 * @date 2020/11/10  16:21
 */
@Getter
@Setter
@Sequence
@HasExtensionMarker
public class SPAT implements AsnV2x{
    @Component(0)
    public MsgCount msgCount;
    @Component(1)
    @Asn1Optional
    public MinuteOfTheYear moy;
    @Component(2)
    @Asn1Optional
    public DSecond timestamp;
    @Component(3)
    @Asn1Optional
    public DescriptiveName name;
    @Component(4)
    public IntersectionStateList intersections;

    public SPAT() {
    }

    public SPAT(MsgCount msgCount,
                MinuteOfTheYear moy,
                DSecond timestamp,
                DescriptiveName name,
                IntersectionStateList intersections) {
        this.msgCount = msgCount;
        this.moy = moy;
        this.timestamp = timestamp;
        this.name = name;
        this.intersections = intersections;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"msgCount\":")
                .append(msgCount);
        sb.append(",\"moy\":")
                .append(moy);
        sb.append(",\"timestamp\":")
                .append(timestamp);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"intersections\":")
                .append(intersections);
        sb.append('}');
        return sb.toString();
    }

    /**
     * IntersectionStateList ::= SEQUENCE (SIZE(1..32)) OF IntersectionState
     */
    @SizeRange(minValue = 1, maxValue = 32)
    public static class IntersectionStateList extends Asn1SequenceOf<IntersectionState> {
        public IntersectionStateList(IntersectionState... intersectionStates) {
            this(Arrays.asList(intersectionStates));
        }

        public IntersectionStateList(Collection<IntersectionState> coll) {
            super(coll);
        }
    }
}
