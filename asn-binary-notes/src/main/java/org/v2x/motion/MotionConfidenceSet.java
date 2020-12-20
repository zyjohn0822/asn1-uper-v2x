package org.v2x.motion;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "MotionConfidenceSet", isSet = false)
public class MotionConfidenceSet {

    @ASN1Element(name = "speedCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SpeedConfidence speedCfd = null;


    @ASN1Element(name = "headingCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private HeadingConfidence headingCfd = null;


    @ASN1Element(name = "steerCfd", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SteeringWheelAngleConfidence steerCfd = null;


    public SpeedConfidence getSpeedCfd() {
        return this.speedCfd;
    }

    public void setSpeedCfd(SpeedConfidence value) {
        this.speedCfd = value;
    }

    public boolean isSpeedCfdPresent() {
        return this.speedCfd != null;
    }

    public HeadingConfidence getHeadingCfd() {
        return this.headingCfd;
    }

    public void setHeadingCfd(HeadingConfidence value) {
        this.headingCfd = value;
    }

    public boolean isHeadingCfdPresent() {
        return this.headingCfd != null;
    }

    public SteeringWheelAngleConfidence getSteerCfd() {
        return this.steerCfd;
    }

    public void setSteerCfd(SteeringWheelAngleConfidence value) {
        this.steerCfd = value;
    }

    public boolean isSteerCfdPresent() {
        return this.steerCfd != null;
    }

}
            