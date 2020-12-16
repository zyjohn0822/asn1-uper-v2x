
package org.v2x.vehicle;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;

/**
 *
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "PathPrediction", isSet = false)
public class PathPrediction implements IASN1PreparedElement {

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


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PathPrediction.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            