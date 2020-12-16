package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/4  19:12
 */
@Sequence
@Setter
@Getter
public class AccelerationSet4Way {

    Acceleration lon;
    Acceleration lat;
    VerticalAcceleration vert;
    YawRate yaw;

    public AccelerationSet4Way() {
    }

    public AccelerationSet4Way(Acceleration lon, Acceleration lat, VerticalAcceleration vert, YawRate yaw) {
        this.lon = lon;
        this.lat = lat;
        this.vert = vert;
        this.yaw = yaw;
    }

    @IntRange(minValue = -2000, maxValue = 2000)
    public static class Acceleration extends Asn1Integer {

        public Acceleration() {
            this(0);
        }

        public Acceleration(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -127, maxValue = 127)
    public static class VerticalAcceleration extends Asn1Integer {
        public VerticalAcceleration() {
            this(0);
        }

        public VerticalAcceleration(int value) {
            super(value);
        }

    }

    @IntRange(minValue = -32767, maxValue = 32767)
    public static class YawRate extends Asn1Integer {
        public YawRate() {
            this(0);
        }

        public YawRate(int value) {
            super(value);
        }
    }
}
