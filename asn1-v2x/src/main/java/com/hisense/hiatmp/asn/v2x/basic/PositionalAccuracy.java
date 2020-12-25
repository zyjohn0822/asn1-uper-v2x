package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * PositionalAccuracy ::= SEQUENCE {<br/>
 * -- NMEA-183 values expressed in strict ASN form<br/>
 * semiMajor SemiMajorAxisAccuracy,<br/>
 * semiMinor SemiMinorAxisAccuracy,<br/>
 * orientation SemiMajorAxisOrientation<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:13
 */
@Sequence
@Setter
@Getter
public class PositionalAccuracy {
    public SemiMajorAxisAccuracy semiMajor;
    public SemiMinorAxisAccuracy semiMinor;
    public SemiMajorAxisOrientation orientation;

    public PositionalAccuracy() {

    }

    public PositionalAccuracy(SemiMajorAxisAccuracy semiMajor, SemiMinorAxisAccuracy semiMinor, SemiMajorAxisOrientation orientation) {
        this.semiMajor = semiMajor;
        this.semiMinor = semiMinor;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"semiMajor\":")
                .append(semiMajor);
        sb.append(",\"semiMinor\":")
                .append(semiMinor);
        sb.append(",\"orientation\":")
                .append(orientation);
        sb.append('}');
        return sb.toString();
    }

    /**
     * SemiMajorAxisAccuracy ::= INTEGER (0..255)<br/>
     * -- semi-major axis accuracy at one standard dev<br/>
     * -- range 0-12.7 meter, LSB = .05m<br/>
     * -- 254 = any value equal or greater than 12.70 meter<br/>
     * -- 255 = unavailable semi-major axis value<br/>
     */
    @IntRange(minValue = 0, maxValue = 255)
    public static class SemiMajorAxisAccuracy extends Asn1Integer {
        public SemiMajorAxisAccuracy() {
            this(0);
        }

        public SemiMajorAxisAccuracy(int value) {
            super(value);
        }
    }

    /**
     * SemiMinorAxisAccuracy ::= INTEGER (0..255)<br/>
     * -- semi-minor axis accuracy at one standard dev<br/>
     * -- range 0-12.7 meter, LSB = .05m<br/>
     * -- 254 = any value equal or greater than 12.70 meter<br/>
     * -- 255 = unavailable semi-minor axis value<br/>
     */
    @IntRange(minValue = 0, maxValue = 255)
    public static class SemiMinorAxisAccuracy extends Asn1Integer {
        public SemiMinorAxisAccuracy() {
            this(0);
        }

        public SemiMinorAxisAccuracy(int value) {
            super(value);
        }
    }

    /**
     * SemiMajorAxisOrientation ::= INTEGER (0..65535)<br/>
     * -- orientation of semi-major axis<br/>
     * -- relative to true north (0~359.9945078786 degrees)<br/>
     * -- Units of 360/65535 deg = 0.0054932479<br/>
     * -- a value of 0 shall be 0 degrees<br/>
     * -- a value of 1 shall be 0.0054932479 degrees<br/>
     * -- a value of 65534 shall be 359.9945078786 deg<br/>
     * -- a value of 65535 shall be used for orientation unavailable<br/>
     */
    @IntRange(minValue = 0, maxValue = 65535)
    public static class SemiMajorAxisOrientation extends Asn1Integer {
        public SemiMajorAxisOrientation() {
            this(0);
        }

        public SemiMajorAxisOrientation(int value) {
            super(value);
        }
    }
}
