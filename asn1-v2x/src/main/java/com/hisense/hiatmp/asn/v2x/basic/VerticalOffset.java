package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.Choice;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * VerticalOffset ::= CHOICE {<br/>
 * -- Vertical Offset<br/>
 * -- All below in steps of 10cm above or below the reference ellipsoid<br/>
 * offset1 VertOffset-B07, -- with a range of +- 6.3 meters vertical<br/>
 * offset2 VertOffset-B08, -- with a range of +- 12.7 meters vertical<br/>
 * offset3 VertOffset-B09, -- with a range of +- 25.5 meters vertical<br/>
 * offset4 VertOffset-B10, -- with a range of +- 51.1 meters vertical<br/>
 * offset5 VertOffset-B11, -- with a range of +- 102.3 meters vertical<br/>
 * offset6 VertOffset-B12, -- with a range of +- 204.7 meters vertical<br/>
 * elevation Elevation -- with a range of -409.5 to + 6143.9 meters<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/10  11:29
 */
@Choice
@Getter
@Setter
public class VerticalOffset {
    @Component(0)
    public VertOffset_B07 offset1;
    @Component(1)
    public VertOffset_B08 offset2;
    @Component(2)
    public VertOffset_B09 offset3;
    @Component(3)
    public VertOffset_B10 offset4;
    @Component(4)
    public VertOffset_B11 offset5;
    @Component(5)
    public VertOffset_B12 offset6;
    @Component(6)
    public Position3D.Elevation elevation;

    public VerticalOffset() {
    }

    private VerticalOffset(VertOffset_B07 offset1,
                           VertOffset_B08 offset2,
                           VertOffset_B09 offset3,
                           VertOffset_B10 offset4,
                           VertOffset_B11 offset5,
                           VertOffset_B12 offset6,
                           Position3D.Elevation elevation) {
        this.offset1 = offset1;
        this.offset2 = offset2;
        this.offset3 = offset3;
        this.offset4 = offset4;
        this.offset5 = offset5;
        this.offset6 = offset6;
        this.elevation = elevation;
    }

    public static VerticalOffset offset1(VertOffset_B07 offset1) {
        return new VerticalOffset(offset1, null, null, null, null, null, null);
    }

    public static VerticalOffset offset2(VertOffset_B08 offset2) {
        return new VerticalOffset(null, offset2, null, null, null, null, null);
    }

    public static VerticalOffset offset3(VertOffset_B09 offset3) {
        return new VerticalOffset(null, null, offset3, null, null, null, null);
    }

    public static VerticalOffset offset4(VertOffset_B10 offset4) {
        return new VerticalOffset(null, null, null, offset4, null, null, null);
    }

    public static VerticalOffset offset5(VertOffset_B11 offset5) {
        return new VerticalOffset(null, null, null, null, offset5, null, null);
    }

    public static VerticalOffset offset6(VertOffset_B12 offset6) {
        return new VerticalOffset(null, null, null, null, null, offset6, null);
    }

    public static VerticalOffset elevation(Position3D.Elevation elevation) {
        return new VerticalOffset(null, null, null, null, null, null, elevation);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"offset1\":")
                .append(offset1);
        sb.append(",\"offset2\":")
                .append(offset2);
        sb.append(",\"offset3\":")
                .append(offset3);
        sb.append(",\"offset4\":")
                .append(offset4);
        sb.append(",\"offset5\":")
                .append(offset5);
        sb.append(",\"offset6\":")
                .append(offset6);
        sb.append(",\"elevation\":")
                .append(elevation);
        sb.append('}');
        return sb.toString();
    }

    /**
     * VertOffset-B07 ::= INTEGER (-64..63)<br/>
     * -- Units of of 10 cm<br/>
     * -- with a range of +- 6.3 meters vertical<br/>
     * -- value 63 to be used for 63 or greater<br/>
     * -- value -63 to be used for -63 or greater<br/>
     * -- value -64 to be unavailable<br/>
     */
    @IntRange(minValue = -64, maxValue = 63)
    public static class VertOffset_B07 extends Asn1Integer {
        public VertOffset_B07() {
            this(0);
        }

        public VertOffset_B07(int value) {
            super(value);
        }
    }

    /**
     * VertOffset-B08 ::= INTEGER (-128..127)<br/>
     * -- Units of of 10 cm<br/>
     * -- with a range of +- 12.7 meters vertical<br/>
     * -- value 127 to be used for 127 or greater<br/>
     * -- value -127 to be used for -127 or greater<br/>
     * -- value -128 to be unavailable<br/>
     */
    @IntRange(minValue = -128, maxValue = 127)
    public static class VertOffset_B08 extends Asn1Integer {
        public VertOffset_B08() {
            this(0);
        }

        public VertOffset_B08(int value) {
            super(value);
        }
    }

    /**
     * VertOffset-B09 ::= INTEGER (-256..255)<br/>
     * -- Units of of 10 cm<br/>
     * -- with a range of +- 25.5 meters vertical<br/>
     * -- value 255 to be used for 255 or greater<br/>
     * -- value -255 to be used for -255 or greater<br/>
     * -- value -256 to be unavailable<br/>
     */
    @IntRange(minValue = -256, maxValue = 255)
    public static class VertOffset_B09 extends Asn1Integer {
        public VertOffset_B09() {
            this(0);
        }

        public VertOffset_B09(int value) {
            super(value);
        }
    }

    /**
     * VertOffset-B10 ::= INTEGER (-512..511)<br/>
     * -- Units of of 10 cm<br/>
     * -- with a range of +- 51.1 meters vertical<br/>
     * -- value 511 to be used for 511 or greater<br/>
     * -- value -511 to be used for -511 or greater<br/>
     * -- value -512 to be unavailable<br/>
     */
    @IntRange(minValue = -512, maxValue = 511)
    public static class VertOffset_B10 extends Asn1Integer {
        public VertOffset_B10() {
            this(0);
        }

        public VertOffset_B10(int value) {
            super(value);
        }
    }

    /**
     * VertOffset-B11 ::= INTEGER (-1024..1023)<br/>
     * -- Units of of 10 cm<br/>
     * -- with a range of +- 102.3 meters vertical<br/>
     * -- value 1023 to be used for 1023 or greater<br/>
     * -- value -1023 to be used for -1023 or greater<br/>
     * -- value -1024 to be unavailable<br/>
     */
    @IntRange(minValue = -1024, maxValue = 1023)
    public static class VertOffset_B11 extends Asn1Integer {
        public VertOffset_B11() {
            this(0);
        }

        public VertOffset_B11(int value) {
            super(value);
        }
    }

    /**
     * VertOffset-B12 ::= INTEGER (-2048..2047)<br/>
     * -- Units of of 10 cm<br/>
     * -- with a range of +- 204.7 meters vertical<br/>
     * -- value 2047 to be used for 2047 or greater<br/>
     * -- value -2047 to be used for -2047 or greater<br/>
     * -- value -2048 to be unavailable<br/>
     */
    @IntRange(minValue = -2048, maxValue = 2047)
    public static class VertOffset_B12 extends Asn1Integer {
        public VertOffset_B12() {
            this(0);
        }

        public VertOffset_B12(int value) {
            super(value);
        }
    }
}
