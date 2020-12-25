package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.IntRange;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * DefAcceleration DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p>
 * -- imports and exports<br/>
 * <p>
 * EXPORTS AccelerationSet4Way;<br/>
 * IMPORTS ;<br/>
 * <p>
 * AccelerationSet4Way ::= SEQUENCE {<br/>
 * long Acceleration,<br/>
 * -- Along the Vehicle Longitudinal axis<br/>
 * lat Acceleration,<br/>
 * -- Along the Vehicle Lateral axis<br/>
 * vert VerticalAcceleration,<br/>
 * -- Along the Vehicle Vertical axis<br/>
 * yaw YawRate<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:12
 */
@Sequence
@Setter
@Getter
public class AccelerationSet4Way {
    @Component(0)
    public Acceleration lon;
    @Component(1)
    public Acceleration lat;
    @Component(2)
    public VerticalAcceleration vert;
    @Component(3)
    public YawRate yaw;

    public AccelerationSet4Way() {
    }

    public AccelerationSet4Way(Acceleration lon, Acceleration lat, VerticalAcceleration vert, YawRate yaw) {
        this.lon = lon;
        this.lat = lat;
        this.vert = vert;
        this.yaw = yaw;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"lon\":")
                .append(lon);
        sb.append(",\"lat\":")
                .append(lat);
        sb.append(",\"vert\":")
                .append(vert);
        sb.append(",\"yaw\":")
                .append(yaw);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Acceleration ::= INTEGER (-2000..2001)<br/>
     * -- Units are 0.01 m/s^2<br/>
     * -- the value 2000 shall be used for values greater than 2000<br/>
     * -- the value -2000 shall be used for values less than -2000<br/>
     * -- a value of 2001 shall be used for Unavailable<br/>
     */
    @IntRange(minValue = -2000, maxValue = 2001)
    public static class Acceleration extends Asn1Integer {

        public Acceleration() {
            this(0);
        }

        public Acceleration(int value) {
            super(value);
        }
    }

    /**
     * VerticalAcceleration ::= INTEGER (-127..127)<br/>
     * -- Units of 0.02 G steps over -2.52 to +2.54 G<br/>
     * -- The value +127 shall be used for ranges >= 2.54 G<br/>
     * -- The value -126 shall be used for ranges <= 2.52 G<br/>
     * -- The value -127 shall be used for unavailable<br/>
     */
    @IntRange(minValue = -127, maxValue = 127)
    public static class VerticalAcceleration extends Asn1Integer {
        public VerticalAcceleration() {
            this(0);
        }

        public VerticalAcceleration(int value) {
            super(value);
        }

    }

    /**
     * YawRate ::= INTEGER (-32767..32767)<br/>
     * -- Units of 0.01 degrees per second (signed)<br/>
     */
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
