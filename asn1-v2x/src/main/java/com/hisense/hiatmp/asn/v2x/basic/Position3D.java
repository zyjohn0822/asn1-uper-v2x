package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * Position3D ::= SEQUENCE {<br/>
 * lat Latitude,<br/>
 * -- in 1/10th micro degrees<br/>
 * long Longitude,<br/>
 * -- in 1/10th micro degrees<br/>
 * elevation Elevation OPTIONAL<br/>
 * -- in 10 cm units<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:13
 */
@Sequence
@Setter
@Getter
public class Position3D {
    @Component(0)
    public Latitude lat;
    @Component(1)
    public Longitude lon;
    @Component(2)
    @Asn1Optional
    public Elevation elevation;

    public Position3D() {
    }

    public Position3D(Latitude lat, Longitude lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Position3D(Latitude lat, Longitude lon, Elevation elevation) {
        this(lat, lon);
        this.elevation = elevation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"lat\":")
                .append(lat);
        sb.append(",\"lon\":")
                .append(lon);
        sb.append(",\"elevation\":")
                .append(elevation);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Latitude ::= INTEGER (-900000000..900000001)<br/>
     * -- Units of 1/10 micro degree<br/>
     * -- Providing a range of plus-minus 90 degrees<br/>
     */
    @IntRange(minValue = -900000000, maxValue = 900000001)
    public static class Latitude extends Asn1Integer {
        public Latitude() {
            this(0);
        }

        public Latitude(int value) {
            super(value);
        }
    }

    /**
     * Longitude ::= INTEGER (-1799999999..1800000001)<br/>
     * -- Units of 1/10 micro degree<br/>
     * -- Providing a range of plus-minus 180 degrees<br/>
     */
    @IntRange(minValue = -1799999999, maxValue = 1800000001)
    public static class Longitude extends Asn1Integer {
        public Longitude() {
            this(0);
        }

        public Longitude(int value) {
            super(value);
        }
    }

    /**
     * Elevation ::= INTEGER (-4096..61439)<br/>
     * -- Units of 10 cm steps above or below the reference ellipsoid<br/>
     * -- Providing a range of -409.5 to + 6143.9 meters<br/>
     * -- The value -4096 shall be used when Unknown is to be sent<br/>
     */
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
