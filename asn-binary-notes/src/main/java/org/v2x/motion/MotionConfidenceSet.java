
package org.v2x.motion;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "MotionConfidenceSet", isSet = false)
public class MotionConfidenceSet implements IASN1PreparedElement {

    @ASN1Element(name = "speedCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SpeedConfidence speedCfd = null;


    @ASN1Element(name = "headingCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private HeadingConfidence headingCfd = null;


    @ASN1Element(name = "steerCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SteeringWheelAngleConfidence steerCfd = null;


    public SpeedConfidence getSpeedCfd() {
        return this.speedCfd;
    }


    public boolean isSpeedCfdPresent() {
        return this.speedCfd != null;
    }


    public void setSpeedCfd(SpeedConfidence value) {
        this.speedCfd = value;
    }


    public HeadingConfidence getHeadingCfd() {
        return this.headingCfd;
    }


    public boolean isHeadingCfdPresent() {
        return this.headingCfd != null;
    }


    public void setHeadingCfd(HeadingConfidence value) {
        this.headingCfd = value;
    }


    public SteeringWheelAngleConfidence getSteerCfd() {
        return this.steerCfd;
    }


    public boolean isSteerCfdPresent() {
        return this.steerCfd != null;
    }


    public void setSteerCfd(SteeringWheelAngleConfidence value) {
        this.steerCfd = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(MotionConfidenceSet.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            