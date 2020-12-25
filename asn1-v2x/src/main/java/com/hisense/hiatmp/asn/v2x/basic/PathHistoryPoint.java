package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.HasExtensionMarker;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * PathHistoryPoint ::= SEQUENCE {<br/>
 * llvOffset PositionOffsetLLV,<br/>
 * timeOffset TimeOffset,<br/>
 * -- Offset backwards in time<br/>
 * speed Speed OPTIONAL,<br/>
 * -- Speed over the reported period<br/>
 * posAccuracy PositionConfidenceSet OPTIONAL,<br/>
 * -- The accuracy of this value<br/>
 * heading CoarseHeading OPTIONAL,<br/>
 * -- overall heading<br/>
 * ...<br/>
 * }
 *
 * @author zhangyong
 * @date 2020/11/5  14:44
 */
@Sequence
@Getter
@Setter
@HasExtensionMarker
public class PathHistoryPoint {
    @Component(0)
    public PositionOffsetLLV llvOffset;
    @Component(1)
    public DDateTime.TimeOffset timeOffset;
    @Component(2)
    @Asn1Optional
    public Speed speed;
    @Component(3)
    @Asn1Optional
    public PositionConfidenceSet posAccuracy;
    @Component(4)
    @Asn1Optional
    public CoarseHeading heading;

    public PathHistoryPoint() {
    }

    public PathHistoryPoint(PositionOffsetLLV llvOffset,
                            DDateTime.TimeOffset timeOffset,
                            Speed speed,
                            PositionConfidenceSet posAccuracy,
                            CoarseHeading heading) {
        this.llvOffset = llvOffset;
        this.timeOffset = timeOffset;
        this.speed = speed;
        this.posAccuracy = posAccuracy;
        this.heading = heading;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"llvOffset\":")
                .append(llvOffset);
        sb.append(",\"timeOffset\":")
                .append(timeOffset);
        sb.append(",\"speed\":")
                .append(speed);
        sb.append(",\"posAccuracy\":")
                .append(posAccuracy);
        sb.append(",\"heading\":")
                .append(heading);
        sb.append('}');
        return sb.toString();
    }
}
