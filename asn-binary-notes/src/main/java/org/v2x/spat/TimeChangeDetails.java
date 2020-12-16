
package org.v2x.spat;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Choice;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Choice(name = "TimeChangeDetails")
public class TimeChangeDetails implements IASN1PreparedElement {

    @ASN1Element(name = "counting", isOptional = false, hasTag = false, hasDefaultValue = false)
    private TimeCountingDown counting = null;

    @ASN1Element(name = "utcTiming", isOptional = false, hasTag = false, hasDefaultValue = false)
    private UTCTiming utcTiming = null;


    public TimeCountingDown getCounting() {
        return this.counting;
    }

    public boolean isCountingSelected() {
        return this.counting != null;
    }

    private void setCounting(TimeCountingDown value) {
        this.counting = value;
    }


    public void selectCounting(TimeCountingDown value) {
        this.counting = value;

        setUtcTiming(null);

    }


    public UTCTiming getUtcTiming() {
        return this.utcTiming;
    }

    public boolean isUtcTimingSelected() {
        return this.utcTiming != null;
    }

    private void setUtcTiming(UTCTiming value) {
        this.utcTiming = value;
    }


    public void selectUtcTiming(UTCTiming value) {
        this.utcTiming = value;

        setCounting(null);

    }


    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(TimeChangeDetails.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            