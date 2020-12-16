package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.HasExtensionMarker;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/5  14:28
 */
@Sequence
@Setter
@Getter
@HasExtensionMarker
public class FullPositionVector {
    @Asn1Optional
    DDateTime utcTime;
    Position3D pos;
    @Asn1Optional
    Heading heading;
    @Asn1Optional
    VehStatus.TransmissionState transmission;
    @Asn1Optional
    Speed speed;
    @Asn1Optional
    PositionalAccuracy posAccuracy;
    @Asn1Optional
    PositionConfidenceSet posConficence;
    @Asn1Optional
    DDateTime.TimeConfidence timeConfidence;
    @Asn1Optional
    MotionConfidenceSet motionCfd;

    public FullPositionVector() {
    }

    public FullPositionVector(Position3D pos) {
        this.pos = pos;
    }

    public FullPositionVector(
            DDateTime utcTime,
            Position3D pos,
            Heading heading,
            VehStatus.TransmissionState transmission,
            Speed speed,
            PositionalAccuracy posAccuracy,
            PositionConfidenceSet posConficence,
            DDateTime.TimeConfidence timeConfidence,
            MotionConfidenceSet motionCfd
    ) {
        this.utcTime = utcTime;
        this.pos = pos;
        this.heading = heading;
        this.transmission = transmission;
        this.speed = speed;
        this.posAccuracy = posAccuracy;
        this.posConficence = posConficence;
        this.timeConfidence = timeConfidence;
        this.motionCfd = motionCfd;
    }
}
