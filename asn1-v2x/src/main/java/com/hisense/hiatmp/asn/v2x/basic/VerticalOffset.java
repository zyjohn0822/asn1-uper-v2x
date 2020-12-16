package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.Choice;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * @author zhangyong
 * @date 2020/11/10  11:29
 */
@Choice
@Getter
@Setter
public class VerticalOffset {
    @Component(0)
    VertOffset_B07 offset1;
    @Component(1)
    VertOffset_B08 offset2;
    @Component(2)
    VertOffset_B09 offset3;
    @Component(3)
    VertOffset_B10 offset4;
    @Component(4)
    VertOffset_B11 offset5;
    @Component(5)
    VertOffset_B12 offset6;
    @Component(6)
    Position3D.Elevation elevation;

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

    @IntRange(minValue = -64, maxValue = 63)
    public static class VertOffset_B07 extends Asn1Integer {
        public VertOffset_B07() {
            this(0);
        }

        public VertOffset_B07(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -128, maxValue = 127)
    public static class VertOffset_B08 extends Asn1Integer {
        public VertOffset_B08() {
            this(0);
        }

        public VertOffset_B08(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -256, maxValue = 255)
    public static class VertOffset_B09 extends Asn1Integer {
        public VertOffset_B09() {
            this(0);
        }

        public VertOffset_B09(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -512, maxValue = 511)
    public static class VertOffset_B10 extends Asn1Integer {
        public VertOffset_B10() {
            this(0);
        }

        public VertOffset_B10(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -1024, maxValue = 1023)
    public static class VertOffset_B11 extends Asn1Integer {
        public VertOffset_B11() {
            this(0);
        }

        public VertOffset_B11(int value) {
            super(value);
        }
    }

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
