package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * @author zhangyong
 * @date 2020/11/5  14:16
 */

@Setter
@Getter
@Sequence
@HasExtensionMarker
public class PathPrediction {
    @Component(0)
    RadiusOfCurvature radiusOfCurve;
    @Component(1)
    Confidence confidence;

    public PathPrediction() {
    }

    public PathPrediction(RadiusOfCurvature radiusOfCurve, Confidence confidence) {
        this.radiusOfCurve = radiusOfCurve;
        this.confidence = confidence;
    }
    @IntRange(minValue = -32767, maxValue = 32767)
    public static class RadiusOfCurvature extends Asn1Integer {
        public RadiusOfCurvature() {
            this(0);
        }

        public RadiusOfCurvature(int value) {
            super(value);
        }
    }
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
