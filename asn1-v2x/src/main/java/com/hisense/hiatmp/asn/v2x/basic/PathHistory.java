package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * PathHistory ::= SEQUENCE {<br/>
 * initialPosition FullPositionVector OPTIONAL,<br/>
 * currGNSSstatus GNSSstatus OPTIONAL,<br/>
 * crumbData PathHistoryPointList,<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/5  14:13
 */
@Sequence
@Setter
@Getter
@HasExtensionMarker
public class PathHistory {
    @Component(0)
    @Asn1Optional
    public FullPositionVector initialPosition;
    @Component(1)
    @Asn1Optional
    public GNSSstatus currGNSSstatus;
    @Component(2)
    public PathHistoryPointList crumbData;

    public PathHistory() {
    }

    public PathHistory(FullPositionVector initialPosition, GNSSstatus currGNSSstatus, PathHistoryPointList crumbData) {
        this.initialPosition = initialPosition;
        this.currGNSSstatus = currGNSSstatus;
        this.crumbData = crumbData;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"initialPosition\":")
                .append(initialPosition);
        sb.append(",\"currGNSSstatus\":")
                .append(currGNSSstatus);
        sb.append(",\"crumbData\":")
                .append(crumbData);
        sb.append('}');
        return sb.toString();
    }

    /**
     * PathHistoryPointList ::= SEQUENCE (SIZE(1..23)) OF PathHistoryPoint<br/>
     *
     * @author zhangyong
     * @date 2020-12-19 12:10
     */
    @SizeRange(minValue = 1, maxValue = 23)
    public static class PathHistoryPointList extends Asn1SequenceOf<PathHistoryPoint> {
        public PathHistoryPointList(PathHistoryPoint... pathHistoryPoints) {
            this(Arrays.asList(pathHistoryPoints));
        }

        public PathHistoryPointList(Collection<PathHistoryPoint> coll) {
            super(coll);
        }
    }
}
