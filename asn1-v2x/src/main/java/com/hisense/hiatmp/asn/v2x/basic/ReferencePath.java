package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.Sequence;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.Arrays;
import java.util.Collection;

/**
 * ReferencePath ::= SEQUENCE {<br/>
 * activePath PathPointList,<br/>
 * -- RSI is active for vehicles within this path<br/>
 * -- Points are listed from upstream to downstream<br/>
 * -- along the vehicle drive direction.<br/>
 * -- One path includes at least 1 points.<br/>
 * -- A path with only 1 point means a round alert area<br/>
 * pathRadius Radius<br/>
 * -- The biggest distance away from the alert path<br/>
 * -- within which the warning is active.<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/23  11:23
 */
@Getter
@Setter
@Sequence
public class ReferencePath {
    public PathPointList activePath;
    public Radius radius;

    public ReferencePath() {
    }

    public ReferencePath(PathPointList activePath, Radius radius) {
        this.activePath = activePath;
        this.radius = radius;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"activePath\":")
                .append(activePath);
        sb.append(",\"radius\":")
                .append(radius);
        sb.append('}');
        return sb.toString();
    }

    /**
     * PathPointList ::= SEQUENCE (SIZE(1..32)) OF PositionOffsetLLV<br/>
     * -- Path point list for RTS message<br/>
     */
    @SizeRange(minValue = 1, maxValue = 32)
    public static class PathPointList extends Asn1SequenceOf<PositionOffsetLLV> {
        public PathPointList(PositionOffsetLLV... positionOffsetLLVS) {
            this(Arrays.asList(positionOffsetLLVS));
        }

        public PathPointList(Collection<PositionOffsetLLV> coll) {
            super(coll);
        }
    }
}
