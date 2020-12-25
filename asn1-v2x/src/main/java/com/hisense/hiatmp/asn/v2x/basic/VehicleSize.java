package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * VehSize DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p>
 * -- imports and exports<br/>
 * <p>
 * EXPORTS VehicleSize;<br/>
 * IMPORTS ;<br/>
 * <p>
 * VehicleSize ::= SEQUENCE {<br/>
 * width VehicleWidth,<br/>
 * length VehicleLength,<br/>
 * height VehicleHeight OPTIONAL<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:12
 */
@Sequence
@Setter
@Getter
public class VehicleSize {
    @Component(0)
    public VehicleWidth width;
    @Component(1)
    public VehicleLength length;
    @Component(2)
    @Asn1Optional
    public VehicleHeight height;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"width\":")
                .append(width);
        sb.append(",\"length\":")
                .append(length);
        sb.append(",\"height\":")
                .append(height);
        sb.append('}');
        return sb.toString();
    }

    /**
     * VehicleWidth ::= INTEGER (0..1023)<br/>
     * -- Units are 1 cm with a range of >10 meters
     */
    @IntRange(minValue = 0, maxValue = 1023)
    public static class VehicleWidth extends Asn1Integer {
        public VehicleWidth() {
            this(0);
        }

        public VehicleWidth(int width) {
            super(width);
        }
    }

    /**
     * VehicleLength ::= INTEGER (0.. 4095)<br/>
     * -- Units of 1 cm with a range of >40 meters
     */
    @IntRange(minValue = 0, maxValue = 4095)
    public static class VehicleLength extends Asn1Integer {
        public VehicleLength() {
            this(0);
        }

        public VehicleLength(int width) {
            super(width);
        }
    }

    /**
     * VehicleHeight ::= INTEGER (0..127)<br/>
     * -- Units of 5 cm, range to 6.35 meters
     */
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
