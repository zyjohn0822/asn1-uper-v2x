package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.HasExtensionMarker;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * FullPositionVector ::= SEQUENCE {<br/>
 * utcTime DDateTime OPTIONAL, -- time with mSec precision<br/>
 * pos Position3D,<br/>
 * heading Heading OPTIONAL,<br/>
 * transmission TransmissionState OPTIONAL,<br/>
 * speed Speed OPTIONAL,<br/>
 * posAccuracy PositionalAccuracy OPTIONAL,<br/>
 * posConficence PositionConfidenceSet OPTIONAL,<br/>
 * timeConfidence TimeConfidence OPTIONAL,<br/>
 * motionCfd MotionConfidenceSet OPTIONAL,<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/5  14:28
 */
@Sequence
@Setter
@Getter
@HasExtensionMarker
public class FullPositionVector {
    @Component(0)
    @Asn1Optional
    public DDateTime utcTime;
    @Component(1)
    public Position3D pos;
    @Component(2)
    @Asn1Optional
    public Heading heading;
    @Component(3)
    @Asn1Optional
    public TransmissionState transmission;
    @Component(4)
    @Asn1Optional
    public Speed speed;
    @Component(5)
    @Asn1Optional
    public PositionalAccuracy posAccuracy;
    @Component(6)
    @Asn1Optional
    public PositionConfidenceSet posConficence;
    @Component(7)
    @Asn1Optional
    public TimeConfidence timeConfidence;
    @Component(8)
    @Asn1Optional
    public MotionConfidenceSet motionCfd;

    public FullPositionVector() {
    }

    public FullPositionVector(Position3D pos) {
        this.pos = pos;
    }

    public FullPositionVector(
            DDateTime utcTime,
            Position3D pos,
            Heading heading,
            TransmissionState transmission,
            Speed speed,
            PositionalAccuracy posAccuracy,
            PositionConfidenceSet posConficence,
            TimeConfidence timeConfidence,
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"utcTime\":")
                .append(utcTime);
        sb.append(",\"pos\":")
                .append(pos);
        sb.append(",\"heading\":")
                .append(heading);
        sb.append(",\"transmission\":")
                .append(transmission);
        sb.append(",\"speed\":")
                .append(speed);
        sb.append(",\"posAccuracy\":")
                .append(posAccuracy);
        sb.append(",\"posConficence\":")
                .append(posConficence);
        sb.append(",\"timeConfidence\":")
                .append(timeConfidence);
        sb.append(",\"motionCfd\":")
                .append(motionCfd);
        sb.append('}');
        return sb.toString();
    }
}
