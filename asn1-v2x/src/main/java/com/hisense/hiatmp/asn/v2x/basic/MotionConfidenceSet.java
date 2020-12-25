package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * MotionConfidenceSet ::= SEQUENCE {<br/>
 * speedCfd SpeedConfidence OPTIONAL,<br/>
 * headingCfd HeadingConfidence OPTIONAL,<br/>
 * steerCfd SteeringWheelAngleConfidence OPTIONAL<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:15
 */
@Sequence
@Setter
@Getter
public class MotionConfidenceSet {
    @Component(0)
    @Asn1Optional
    public SpeedConfidence speedCfd;
    @Component(1)
    @Asn1Optional
    public HeadingConfidence headingCfd;
    @Component(2)
    @Asn1Optional
    public SteeringWheelAngleConfidence steerCfd;

    public MotionConfidenceSet() {
    }

    public MotionConfidenceSet(SpeedConfidence speedCfd, HeadingConfidence headingCfd, SteeringWheelAngleConfidence steerCfd) {
        this.speedCfd = speedCfd;
        this.headingCfd = headingCfd;
        this.steerCfd = steerCfd;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"speedCfd\":")
                .append(speedCfd);
        sb.append(",\"headingCfd\":")
                .append(headingCfd);
        sb.append(",\"steerCfd\":")
                .append(steerCfd);
        sb.append('}');
        return sb.toString();
    }

    /**
     * SpeedConfidence ::= ENUMERATED {<br/>
     * unavailable (0), -- Not Equipped or unavailable<br/>
     * prec100ms (1), -- 100 meters / sec<br/>
     * prec10ms (2), -- 10 meters / sec<br/>
     * prec5ms (3), -- 5 meters / sec<br/>
     * prec1ms (4), -- 1 meters / sec<br/>
     * prec0-1ms (5), -- 0.1 meters / sec<br/>
     * prec0-05ms (6), -- 0.05 meters / sec<br/>
     * prec0-01ms (7) -- 0.01 meters / sec<br/>
     * }<br/>
     */
    public enum SpeedConfidence {
        /**
         * -- Not Equipped or unavailable
         */
        unavailable(0),
        /**
         * -- 10 degrees
         */
        prec10deg(1),
        /**
         * -- 5 degrees
         */
        prec05deg(2),
        /**
         * -- 1 degrees
         */
        prec01deg(3),
        /**
         * -- 0.1 degrees
         */
        prec0_1deg(4),
        /**
         * -- 0.05 degrees
         */
        prec0_05deg(5),
        /**
         * -- 0.01 degrees
         */
        prec0_01deg(6),
        /**
         * -- 0.0125 degrees, aligned with heading LSB
         */
        prec0_0125deg(7);

        private final int value;

        SpeedConfidence(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"value\":")
                    .append(value);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * HeadingConfidence ::= ENUMERATED {<br/>
     * unavailable (0), -- Not Equipped or unavailable<br/>
     * prec10deg (1), -- 10 degrees<br/>
     * prec05deg (2), -- 5 degrees<br/>
     * prec01deg (3), -- 1 degrees<br/>
     * prec0-1deg (4), -- 0.1 degrees<br/>
     * prec0-05deg (5), -- 0.05 degrees<br/>
     * prec0-01deg (6), -- 0.01 degrees<br/>
     * prec0-0125deg (7) -- 0.0125 degrees, aligned with heading LSB<br/>
     * }<br/>
     */
    public enum HeadingConfidence {
        /**
         * -- Not Equipped or unavailable
         */
        unavailable(0),
        /**
         * -- 100 meters / sec
         */
        prec100ms(1),
        /**
         * -- 10 meters / sec
         */
        prec10ms(2),
        /**
         * -- 5 meters / sec
         */
        prec5ms(3),
        /**
         * -- 1 meters / sec
         */
        prec1ms(4),
        /**
         * -- 0.1 meters / sec
         */
        prec0_1ms(5),
        /**
         * -- 0.05 meters / sec
         */
        prec0_05ms(6),
        /**
         * -- 0.01 meters / sec
         */
        prec0_01ms(7);

        private final int value;

        HeadingConfidence(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"value\":")
                    .append(value);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * SteeringWheelAngleConfidence ::= ENUMERATED {<br/>
     * unavailable (0), -- Not Equipped with Wheel angle<br/>
     * -- or Wheel angle status is unavailable<br/>
     * prec2deg (1), -- 2 degrees<br/>
     * prec1deg (2), -- 1 degree<br/>
     * prec0-02deg (3) -- 0.02 degrees<br/>
     * }<br/>
     */
    public enum SteeringWheelAngleConfidence {
        /**
         * -- Not Equipped with Wheel angle
         * -- or Wheel angle status is unavailable
         */
        unavailable(0),
        /**
         *
         */

        /**
         * -- 2 degrees
         */
        prec2deg(1),
        /**
         * -- 1 degree
         */
        prec1deg(2),
        /**
         * -- 0.02 degrees
         */
        prec0_02deg(3);

        private final int value;

        SteeringWheelAngleConfidence(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"value\":")
                    .append(value);
            sb.append('}');
            return sb.toString();
        }
    }
}
