package org.v2x.spat;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "PhaseState", isSet = false)
public class PhaseState {

    @ASN1Element(name = "light", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LightState light = null;

    @ASN1Element(name = "timing", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeChangeDetails timing = null;


    public LightState getLight() {
        return this.light;
    }


    public void setLight(LightState value) {
        this.light = value;
    }


    public TimeChangeDetails getTiming() {
        return this.timing;
    }

    public void setTiming(TimeChangeDetails value) {
        this.timing = value;
    }

    public boolean isTimingPresent() {
        return this.timing != null;
    }


}
            