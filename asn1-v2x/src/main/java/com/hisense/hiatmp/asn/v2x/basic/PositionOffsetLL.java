package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * @author zhangyong
 * @date 2020/11/5  15:30
 */
@Choice
@Getter
@Setter
public class PositionOffsetLL {
    @Component(0)
    PositionLL24B positionLL1;
    @Component(1)
    PositionLL28B positionLL2;
    @Component(2)
    PositionLL32B positionLL3;
    @Component(3)
    PositionLL36B positionLL4;
    @Component(4)
    PositionLL44B positionLL5;
    @Component(5)
    PositionLL48B positionLL6;
    @Component(6)
    PositionLLmD64b positionLatLon;

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
    public static PositionOffsetLL positionLL1(PositionLL24B positionLL1){
        return new PositionOffsetLL(
                positionLL1,
                null,
                null,
                null,
                null,
                null,
                null);
    }
    public static PositionOffsetLL positionLL2(PositionLL28B positionLL2){
        return new PositionOffsetLL(
                null,
                positionLL2,
                null,
                null,
                null,
                null,
                null);
    }
    public static PositionOffsetLL positionLL3(PositionLL32B positionLL3){
        return new PositionOffsetLL(
                null,
                null,
                positionLL3,
                null,
                null,
                null,
                null);
    }
    public static PositionOffsetLL positionLL4(PositionLL36B positionLL4){
        return new PositionOffsetLL(
                null,
                null,
                null,
                positionLL4,
                null,
                null,
                null);
    }
    public static PositionOffsetLL positionLL5(PositionLL44B positionLL5){
        return new PositionOffsetLL(
                null,
                null,
                null,
                null,
                positionLL5,
                null,
                null);
    }
    public static PositionOffsetLL positionLL6(PositionLL48B positionLL6){
        return new PositionOffsetLL(
                null,
                null,
                null,
                null,
                null,
                positionLL6,
                null);
    }
    public static PositionOffsetLL positionLatLon(PositionLLmD64b positionLatLon){
        return new PositionOffsetLL(
                null,
                null,
                null,
                null,
                null,
                null,
                positionLatLon);
    }
    @Sequence
    @Getter
    @Setter
    public static class PositionLL24B {
        OffsetLLB12 log;
        OffsetLLB12 lat;

        public PositionLL24B() {
        }

        public PositionLL24B(OffsetLLB12 log, OffsetLLB12 lat) {
            this.log = log;
            this.lat = lat;
        }
    }

    @Sequence
    @Getter
    @Setter
    public static class PositionLL28B {
        OffsetLLB14 log;
        OffsetLLB14 lat;

        public PositionLL28B() {
        }

        public PositionLL28B(OffsetLLB14 log, OffsetLLB14 lat) {
            this.log = log;
            this.lat = lat;
        }
    }

    @Sequence
    @Getter
    @Setter
    public static class PositionLL32B {
        OffsetLLB16 log;
        OffsetLLB16 lat;

        public PositionLL32B() {
        }

        public PositionLL32B(OffsetLLB16 log, OffsetLLB16 lat) {
            this.log = log;
            this.lat = lat;
        }
    }

    @Sequence
    @Getter
    @Setter
    public static class PositionLL36B {
        OffsetLLB18 log;
        OffsetLLB18 lat;

        public PositionLL36B() {
        }

        public PositionLL36B(OffsetLLB18 log, OffsetLLB18 lat) {
            this.log = log;
            this.lat = lat;
        }
    }

    @Sequence
    @Getter
    @Setter
    public static class PositionLL44B {
        OffsetLLB22 log;
        OffsetLLB22 lat;

        public PositionLL44B() {
        }

        public PositionLL44B(OffsetLLB22 log, OffsetLLB22 lat) {
            this.log = log;
            this.lat = lat;
        }
    }

    @Sequence
    @Getter
    @Setter
    public static class PositionLL48B {
        OffsetLLB24 log;
        OffsetLLB24 lat;

        public PositionLL48B() {
        }

        public PositionLL48B(OffsetLLB24 log, OffsetLLB24 lat) {
            this.log = log;
            this.lat = lat;
        }
    }

    @Sequence
    @Getter
    @Setter
    public static class PositionLLmD64b {
        Position3D.Longitude lon;
        Position3D.Latitude lat;

        public PositionLLmD64b(Position3D.Longitude lon, Position3D.Latitude lat) {
            this.lon = lon;
            this.lat = lat;
        }

        public PositionLLmD64b() {
        }
    }

    @IntRange(minValue = -2048, maxValue = 2047)
    public static class OffsetLLB12 extends Asn1Integer {
        public OffsetLLB12() {
            this(0);
        }

        public OffsetLLB12(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -8192, maxValue = 8191)
    public static class OffsetLLB14 extends Asn1Integer {
        public OffsetLLB14() {
            this(0);
        }

        public OffsetLLB14(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -32768, maxValue = 32767)
    public static class OffsetLLB16 extends Asn1Integer {
        public OffsetLLB16() {
            this(0);
        }

        public OffsetLLB16(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -131072, maxValue = 131071)
    public static class OffsetLLB18 extends Asn1Integer {
        public OffsetLLB18() {
            this(0);
        }

        public OffsetLLB18(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -2097152, maxValue = 2097151)
    public static class OffsetLLB22 extends Asn1Integer {
        public OffsetLLB22() {
            this(0);
        }

        public OffsetLLB22(int value) {
            super(value);
        }
    }

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
