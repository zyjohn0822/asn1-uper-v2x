package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * ParticipantData ::= SEQUENCE {<br/>
 * ptcType ParticipantType,<br/>
 * ptcId INTEGER (0..65535),<br/>
 * -- temporary ID set by RSU<br/>
 * -- 0 is RSU itself<br/>
 * -- 1..255 represent participants detected by RSU<br/>
 * -- ptcId of different participant needs to be unique in RSU<br/>
 * source SourceType,<br/>
 * id OCTET STRING (SIZE(8)) OPTIONAL,<br/>
 * -- temperary vehicle ID from BSM<br/>
 * secMark DSecond,<br/>
 * pos PositionOffsetLLV,<br/>
 * posConfidence PositionConfidenceSet,<br/>
 * transmission TransmissionState OPTIONAL,<br/>
 * speed Speed,<br/>
 * heading Heading,<br/>
 * angle SteeringWheelAngle OPTIONAL,<br/>
 * motionCfd MotionConfidenceSet OPTIONAL,<br/>
 * accelSet AccelerationSet4Way OPTIONAL,<br/>
 * size VehicleSize,<br/>
 * -- Size of participant including motor/non-motor/pedestrian/rsu<br/>
 * -- is represented by DE_VehilceSize<br/>
 * vehicleClass VehicleClassification OPTIONAL,<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/22  19:17
 */
@Getter
@Setter
@Sequence
@HasExtensionMarker
public class ParticipantData {
    @Component(0)
    public ParticipantType ptcType;
    @Component(1)
    public PtcId ptcId;
    @Component(2)
    public SourceType source;
    @Component(3)
    @Asn1Optional
    public ID id;
    @Component(4)
    public DDateTime.DSecond secMark;
    @Component(5)
    public PositionOffsetLLV pos;
    @Component(6)
    public PositionConfidenceSet posConfidence;
    @Component(7)
    @Asn1Optional
    public TransmissionState transmission;
    @Component(8)
    public Speed speed;
    @Component(9)
    public Heading heading;
    @Component(10)
    @Asn1Optional
    public SteeringWheelAngle angle;
    @Component(11)
    @Asn1Optional
    public MotionConfidenceSet motionCfd;
    @Component(12)
    @Asn1Optional
    public AccelerationSet4Way accelSet;
    @Component(13)
    public VehicleSize size;
    @Component(14)
    @Asn1Optional
    public VehicleClassification vehicleClass;

    /**
     * ParticipantType ::= ENUMERATED {<br/>
     * unknown (0), -- Unknown<br/>
     * motor (1), -- motor<br/>
     * non-motor (2), -- non-motor<br/>
     * pedestrian (3), -- pedestrian<br/>
     * rsu (4), -- rsu<br/>
     * ...<br/>
     * }<br/>
     */
    @HasExtensionMarker
    public enum ParticipantType {
        unknown(0),
        motor(1),
        non_motor(2),
        pedestrian(3),
        rsu(4);
        private final int value;

        private ParticipantType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * SourceType ::= ENUMERATED {<br/>
     * unknown(0),<br/>
     * selfinfo(1),<br/>
     * v2x(2),<br/>
     * video(3),<br/>
     * microwaveRadar(4),<br/>
     * loop(5),<br/>
     * lidar(6),<br/>
     * integrated(7),<br/>
     * ...<br/>
     * }<br/>
     */
    @HasExtensionMarker
    public enum SourceType {
        unknown(0),
        selfinfo(1),
        v2x(2),
        video(3),
        microwaveRadar(4),
        loop(5),
        lidar(6),
        integrated(7);
        private final int value;

        private SourceType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * ptcId INTEGER (0..65535)<br/>
     */
    @IntRange(minValue = 0, maxValue = 65535)
    public static class PtcId extends Asn1Integer {
        public PtcId() {
            this(0);
        }

        public PtcId(int value) {
            super(value);
        }
    }
}
