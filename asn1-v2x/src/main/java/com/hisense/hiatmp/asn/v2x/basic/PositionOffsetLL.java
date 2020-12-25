package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * PositionOffsetLL ::= CHOICE {<br/>
 * -- Locations with LL content Span at the equator when using a zoom of one:<br/>
 * position-LL1 Position-LL-24B,<br/>
 * -- within +- 22.634554 meters of the reference position<br/>
 * position-LL2 Position-LL-28B,<br/>
 * -- within +- 90.571389 meters of the reference position<br/>
 * position-LL3 Position-LL-32B,<br/>
 * -- within +- 362.31873 meters of the reference position<br/>
 * position-LL4 Position-LL-36B,<br/>
 * -- within +- 01.449308 Kmeters of the reference position<br/>
 * position-LL5 Position-LL-44B,<br/>
 * -- within +- 23.189096 Kmeters of the reference position<br/>
 * position-LL6 Position-LL-48B,<br/>
 * -- within +- 92.756481 Kmeters of the reference position<br/>
 * position-LatLon Position-LLmD-64b<br/>
 * -- node is a Lat/Lon absolute coordinates<br/>
 * -- not a reference position<br/>
 * }<br/>
 * =========================
 * Choice::PositionOffsetLL
 * =========================
 *
 * @author zhangyong
 * @date 2020/11/5  15:30
 */
@Choice
@Getter
@Setter
public class PositionOffsetLL {
    @Component(0)
    public PositionLL24B positionLL1;
    @Component(1)
    public PositionLL28B positionLL2;
    @Component(2)
    public PositionLL32B positionLL3;
    @Component(3)
    public PositionLL36B positionLL4;
    @Component(4)
    public PositionLL44B positionLL5;
    @Component(5)
    public PositionLL48B positionLL6;
    @Component(6)
    public PositionLLmD64b positionLatLon;

    private PositionOffsetLL(
            PositionLL24B positionLL1,
            PositionLL28B positionLL2,
            PositionLL32B positionLL3,
            PositionLL36B positionLL4,
            PositionLL44B positionLL5,
            PositionLL48B positionLL6,
            PositionLLmD64b positionLatLon) {
        this.positionLL1 = positionLL1;
        this.positionLL2 = positionLL2;
        this.positionLL3 = positionLL3;
        this.positionLL4 = positionLL4;
        this.positionLL5 = positionLL5;
        this.positionLL6 = positionLL6;
        this.positionLatLon = positionLatLon;
    }

    public static PositionOffsetLL positionLL1(PositionLL24B positionLL1) {
        return new PositionOffsetLL(
                positionLL1,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    public static PositionOffsetLL positionLL2(PositionLL28B positionLL2) {
        return new PositionOffsetLL(
                null,
                positionLL2,
                null,
                null,
                null,
                null,
                null);
    }

    public static PositionOffsetLL positionLL3(PositionLL32B positionLL3) {
        return new PositionOffsetLL(
                null,
                null,
                positionLL3,
                null,
                null,
                null,
                null);
    }

    public static PositionOffsetLL positionLL4(PositionLL36B positionLL4) {
        return new PositionOffsetLL(
                null,
                null,
                null,
                positionLL4,
                null,
                null,
                null);
    }

    public static PositionOffsetLL positionLL5(PositionLL44B positionLL5) {
        return new PositionOffsetLL(
                null,
                null,
                null,
                null,
                positionLL5,
                null,
                null);
    }

    public static PositionOffsetLL positionLL6(PositionLL48B positionLL6) {
        return new PositionOffsetLL(
                null,
                null,
                null,
                null,
                null,
                positionLL6,
                null);
    }

    public static PositionOffsetLL positionLatLon(PositionLLmD64b positionLatLon) {
        return new PositionOffsetLL(
                null,
                null,
                null,
                null,
                null,
                null,
                positionLatLon);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"positionLL1\":")
                .append(positionLL1);
        sb.append(",\"positionLL2\":")
                .append(positionLL2);
        sb.append(",\"positionLL3\":")
                .append(positionLL3);
        sb.append(",\"positionLL4\":")
                .append(positionLL4);
        sb.append(",\"positionLL5\":")
                .append(positionLL5);
        sb.append(",\"positionLL6\":")
                .append(positionLL6);
        sb.append(",\"positionLatLon\":")
                .append(positionLatLon);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Position-LL-24B ::= SEQUENCE {<br/>
     * -- ranges of +- 0.0002047 degrees<br/>
     * -- ranges of +- 22.634554 meters at the equator<br/>
     * lon OffsetLL-B12,<br/>
     * lat OffsetLL-B12<br/>
     * }<br/>
     * =========================
     * Sequence::PositionLL24B
     * =========================
     */
    @Sequence
    @Getter
    @Setter
    public static class PositionLL24B {
        public OffsetLLB12 log;
        public OffsetLLB12 lat;

        public PositionLL24B() {
        }

        public PositionLL24B(OffsetLLB12 log, OffsetLLB12 lat) {
            this.log = log;
            this.lat = lat;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"log\":")
                    .append(log);
            sb.append(",\"lat\":")
                    .append(lat);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * Position-LL-28B ::= SEQUENCE {<br/>
     * -- ranges of +- 0.0008191 degrees<br/>
     * -- ranges of +- 90.571389 meters at the equator<br/>
     * lon OffsetLL-B14,<br/>
     * lat OffsetLL-B14<br/>
     * }<br/>
     * =========================
     * Sequence::PositionLL28B
     * =========================
     */
    @Sequence
    @Getter
    @Setter
    public static class PositionLL28B {
        public OffsetLLB14 log;
        public OffsetLLB14 lat;

        public PositionLL28B() {
        }

        public PositionLL28B(OffsetLLB14 log, OffsetLLB14 lat) {
            this.log = log;
            this.lat = lat;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"log\":")
                    .append(log);
            sb.append(",\"lat\":")
                    .append(lat);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * Position-LL-32B ::= SEQUENCE {<br/>
     * -- ranges of +- 0.0032767 degrees<br/>
     * -- ranges of +- 362.31873 meters at the equator<br/>
     * lon OffsetLL-B16,<br/>
     * lat OffsetLL-B16<br/>
     * }<br/>
     * =========================
     * Sequence::PositionLL32B
     * =========================
     */
    @Sequence
    @Getter
    @Setter
    public static class PositionLL32B {
        public OffsetLLB16 log;
        public OffsetLLB16 lat;

        public PositionLL32B() {
        }

        public PositionLL32B(OffsetLLB16 log, OffsetLLB16 lat) {
            this.log = log;
            this.lat = lat;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"log\":")
                    .append(log);
            sb.append(",\"lat\":")
                    .append(lat);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * Position-LL-36B ::= SEQUENCE {<br/>
     * -- ranges of +- 0.0131071 degrees<br/>
     * -- ranges of +- 01.449308 Kmeters at the equator<br/>
     * lon OffsetLL-B18,<br/>
     * lat OffsetLL-B18<br/>
     * }<br/>
     * =========================
     * Sequence::PositionLL36B
     * =========================
     */
    @Sequence
    @Getter
    @Setter
    public static class PositionLL36B {
        public OffsetLLB18 log;
        public OffsetLLB18 lat;

        public PositionLL36B() {
        }

        public PositionLL36B(OffsetLLB18 log, OffsetLLB18 lat) {
            this.log = log;
            this.lat = lat;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"log\":")
                    .append(log);
            sb.append(",\"lat\":")
                    .append(lat);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * Position-LL-44B ::= SEQUENCE {<br/>
     * -- ranges of +- 0.2097151 degrees<br/>
     * -- ranges of +- 23.189096 Kmeters at the equator<br/>
     * lon OffsetLL-B22,<br/>
     * lat OffsetLL-B22<br/>
     * }<br/>
     * =========================
     * Sequence::PositionLL44B
     * =========================
     */
    @Sequence
    @Getter
    @Setter
    public static class PositionLL44B {
        public OffsetLLB22 log;
        public OffsetLLB22 lat;

        public PositionLL44B() {
        }

        public PositionLL44B(OffsetLLB22 log, OffsetLLB22 lat) {
            this.log = log;
            this.lat = lat;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"log\":")
                    .append(log);
            sb.append(",\"lat\":")
                    .append(lat);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * Position-LL-48B ::= SEQUENCE {<br/>
     * -- ranges of +- 0.8388607 degrees<br/>
     * -- ranges of +- 92.756481 Kmeters at the equator<br/>
     * lon OffsetLL-B24,<br/>
     * lat OffsetLL-B24<br/>
     * }<br/>
     * =========================
     * Sequence::PositionLL48B
     * =========================
     */
    @Sequence
    @Getter
    @Setter
    public static class PositionLL48B {
        public OffsetLLB24 log;
        public OffsetLLB24 lat;

        public PositionLL48B() {
        }

        public PositionLL48B(OffsetLLB24 log, OffsetLLB24 lat) {
            this.log = log;
            this.lat = lat;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"log\":")
                    .append(log);
            sb.append(",\"lat\":")
                    .append(lat);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * Position-LLmD-64b ::= SEQUENCE {<br/>
     * -- a full 32b Lat/Lon range<br/>
     * lon Longitude,<br/>
     * lat Latitude<br/>
     * }<br/>
     * =========================
     * Sequence::PositionLLmD64b
     * =========================
     */
    @Sequence
    @Getter
    @Setter
    public static class PositionLLmD64b {
        public Position3D.Longitude lon;
        public Position3D.Latitude lat;

        public PositionLLmD64b(Position3D.Longitude lon, Position3D.Latitude lat) {
            this.lon = lon;
            this.lat = lat;
        }

        public PositionLLmD64b() {
        }
    }

    /**
     * OffsetLL-B12 ::= INTEGER (-2048..2047)
     * -- A range of +- 0.0002047 degrees
     */
    @IntRange(minValue = -2048, maxValue = 2047)
    public static class OffsetLLB12 extends Asn1Integer {
        public OffsetLLB12() {
            this(0);
        }

        public OffsetLLB12(int value) {
            super(value);
        }
    }

    /**
     * OffsetLL-B14 ::= INTEGER (-8192..8191)
     * -- A range of +- 0.0008191 degrees
     * -- Units of 0.1 microdegrees
     */
    @IntRange(minValue = -8192, maxValue = 8191)
    public static class OffsetLLB14 extends Asn1Integer {
        public OffsetLLB14() {
            this(0);
        }

        public OffsetLLB14(int value) {
            super(value);
        }
    }

    /**
     * OffsetLL-B16 ::= INTEGER (-32768..32767)
     * -- A range of +- 0.0032767 degrees
     * -- Units of 0.1 microdegrees
     */
    @IntRange(minValue = -32768, maxValue = 32767)
    public static class OffsetLLB16 extends Asn1Integer {
        public OffsetLLB16() {
            this(0);
        }

        public OffsetLLB16(int value) {
            super(value);
        }
    }

    /**
     * OffsetLL-B18 ::= INTEGER (-131072..131071)
     * -- A range of +- 0.0131071 degrees
     * -- Units of 0.1 microdegrees
     */
    @IntRange(minValue = -131072, maxValue = 131071)
    public static class OffsetLLB18 extends Asn1Integer {
        public OffsetLLB18() {
            this(0);
        }

        public OffsetLLB18(int value) {
            super(value);
        }
    }

    /**
     * OffsetLL-B22 ::= INTEGER (-2097152..2097151)
     * -- A range of +- 0.2097151 degrees
     * -- Units of 0.1 microdegrees
     */
    @IntRange(minValue = -2097152, maxValue = 2097151)
    public static class OffsetLLB22 extends Asn1Integer {
        public OffsetLLB22() {
            this(0);
        }

        public OffsetLLB22(int value) {
            super(value);
        }
    }

    /**
     * OffsetLL-B24 ::= INTEGER (-8388608..8388607)
     * -- A range of +- 0.8388607 degrees
     * -- Units of 0.1 microdegrees
     */
    @IntRange(minValue = -8388608, maxValue = 8388607)
    public static class OffsetLLB24 extends Asn1Integer {
        public OffsetLLB24() {
            this(0);
        }

        public OffsetLLB24(int value) {
            super(value);
        }
    }


}
