package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.IntRange;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/4  19:12
 */
@Sequence
@Setter
@Getter
public class VehicleSize {
    VehicleWidth width;
    VehicleLength length;
    @Asn1Optional
    VehicleHeight height;

    public VehicleSize() {
    }

    public VehicleSize(VehicleWidth width, VehicleLength length) {
        this.width = width;
        this.length = length;
    }

    public VehicleSize(VehicleWidth width, VehicleLength length, VehicleHeight height) {
        this(width, length);
        this.height = height;
    }

    @IntRange(minValue = 0, maxValue = 1023)
    public static class VehicleWidth extends Asn1Integer {
        public VehicleWidth() {
            this(0);
        }

        public VehicleWidth(int width) {
            super(width);
        }
    }

    @IntRange(minValue = 0, maxValue = 4095)
    public static class VehicleLength extends Asn1Integer {
        public VehicleLength() {
            this(0);
        }

        public VehicleLength(int width) {
            super(width);
        }
    }

    @IntRange(minValue = 0, maxValue = 127)
    public static class VehicleHeight extends Asn1Integer {
        public VehicleHeight() {
            this(0);
        }

        public VehicleHeight(int width) {
            super(width);
        }
    }
}
