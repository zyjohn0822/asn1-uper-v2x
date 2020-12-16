package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.IntRange;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/4  19:13
 */
@Sequence
@Setter
@Getter
public class Position3D {
    Latitude lat;
    Longitude lon;
    @Asn1Optional
    Elevation elevation;

    public Position3D() {
    }

    public Position3D(Longitude lon, Latitude lat) {
        this.lat = lat;
        this.lon = lon;
    }

    public Position3D(Longitude lon, Latitude lat, Elevation elevation) {
        this(lon, lat);
        this.elevation = elevation;
    }

    @IntRange(minValue = -900000000, maxValue = 900000001)
    public static class Latitude extends Asn1Integer {
        public Latitude() {
            this(0);
        }

        public Latitude(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -1799999999, maxValue = 1800000001)
    public static class Longitude extends Asn1Integer {
        public Longitude() {
            this(0);
        }

        public Longitude(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -4096, maxValue = 61439)
    public static class Elevation extends Asn1Integer {
        public Elevation() {
            this(0);
        }

        public Elevation(int value) {
            super(value);
        }
    }
}
