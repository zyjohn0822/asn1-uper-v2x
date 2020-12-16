
package org.v2x.spat;


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
@ASN1Sequence(name = "PhaseState", isSet = false)
public class PhaseState implements IASN1PreparedElement {

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


    public boolean isTimingPresent() {
        return this.timing != null;
    }


    public void setTiming(TimeChangeDetails value) {
        this.timing = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PhaseState.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            