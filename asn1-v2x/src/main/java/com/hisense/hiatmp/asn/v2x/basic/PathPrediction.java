package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * PathPrediction ::= SEQUENCE {<br/>
 * radiusOfCurve RadiusOfCurvature,<br/>
 * -- Units of 10cm<br/>
 * -- straight path to use value of 32767<br/>
 * confidence Confidence,<br/>
 * -- Units of 0.5 percent<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/5  14:16
 */

@Setter
@Getter
@Sequence
@HasExtensionMarker
public class PathPrediction {
    @Component(0)
    public RadiusOfCurvature radiusOfCurve;
    @Component(1)
    public Confidence confidence;

    public PathPrediction() {
    }

    public PathPrediction(RadiusOfCurvature radiusOfCurve, Confidence confidence) {
        this.radiusOfCurve = radiusOfCurve;
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"radiusOfCurve\":")
                .append(radiusOfCurve);
        sb.append(",\"confidence\":")
                .append(confidence);
        sb.append('}');
        return sb.toString();
    }

    /**
     * RadiusOfCurvature ::= INTEGER (-32767..32767)
     * -- Units of 10cm
     * -- A straight path to use value of 32767
     */
    @IntRange(minValue = -32767, maxValue = 32767)
    public static class RadiusOfCurvature extends Asn1Integer {
        public RadiusOfCurvature() {
            this(0);
        }

        public RadiusOfCurvature(int value) {
            super(value);
        }
    }

    /**
     * Confidence ::= INTEGER (0..200)
     * -- Units of 0.5 percent
     */
    @IntRange(minValue = 0, maxValue = 200)
    public static class Confidence extends Asn1Integer {
        public Confidence() {
            this(0);
        }

        public Confidence(int value) {
            super(value);
        }
    }
}
