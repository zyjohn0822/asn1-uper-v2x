package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.HasExtensionMarker;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/5  14:44
 */
@Sequence
@Getter
@Setter
@HasExtensionMarker
public class PathHistoryPoint {
    PositionOffsetLLV llvOffset;
    DDateTime.TimeOffset timeOffset;
    @Asn1Optional
    Speed speed;
    @Asn1Optional
    PositionConfidenceSet posAccuracy;
    @Asn1Optional
    CoarseHeading heading;

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
}
