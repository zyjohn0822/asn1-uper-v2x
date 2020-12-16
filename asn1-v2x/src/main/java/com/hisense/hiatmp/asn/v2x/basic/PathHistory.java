package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author zhangyong
 * @date 2020/11/5  14:13
 */
@Sequence
@Setter
@Getter
@HasExtensionMarker
public class PathHistory {
    @Asn1Optional
    FullPositionVector initialPosition;
    @Asn1Optional
    GNSSstatus currGNSSstatus;
    PathHistoryPointList crumbData;

    public PathHistory() {
    }

    public PathHistory(FullPositionVector initialPosition, GNSSstatus currGNSSstatus, PathHistoryPointList crumbData) {
        this.initialPosition = initialPosition;
        this.currGNSSstatus = currGNSSstatus;
        this.crumbData = crumbData;
    }

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
