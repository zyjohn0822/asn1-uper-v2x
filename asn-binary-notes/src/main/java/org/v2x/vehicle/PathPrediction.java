package org.v2x.vehicle;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;

/**
 * @author zhangyong
 */
@ASN1Sequence(name = "PathPrediction", isSet = false)
public class PathPrediction {

    @ASN1Element(name = "radiusOfCurve", isOptional = false, hasTag = false, hasDefaultValue = false)
    private RadiusOfCurvature radiusOfCurve = null;

    @ASN1Element(name = "confidence", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Confidence confidence = null;


    public RadiusOfCurvature getRadiusOfCurve() {
        return this.radiusOfCurve;
    }


    public void setRadiusOfCurve(RadiusOfCurvature value) {
        this.radiusOfCurve = value;
    }


    public Confidence getConfidence() {
        return this.confidence;
    }


    public void setConfidence(Confidence value) {
        this.confidence = value;
    }


}
            