package org.v2x.spat;


import org.bn.annotations.ASN1Choice;
import org.bn.annotations.ASN1Element;


/**
 * @author zhangyong
 */
@ASN1Choice(name = "TimeChangeDetails")
public class TimeChangeDetails {

    @ASN1Element(name = "counting", isOptional = false, hasTag = false, hasDefaultValue = false)
    private TimeCountingDown counting = null;

    @ASN1Element(name = "utcTiming", isOptional = false, hasTag = false, hasDefaultValue = false)
    private UTCTiming utcTiming = null;


    public TimeCountingDown getCounting() {
        return this.counting;
    }

    private void setCounting(TimeCountingDown value) {
        this.counting = value;
    }

    public boolean isCountingSelected() {
        return this.counting != null;
    }

    public void selectCounting(TimeCountingDown value) {
        this.counting = value;

        setUtcTiming(null);

    }


    public UTCTiming getUtcTiming() {
        return this.utcTiming;
    }

    private void setUtcTiming(UTCTiming value) {
        this.utcTiming = value;
    }

    public boolean isUtcTimingSelected() {
        return this.utcTiming != null;
    }

    public void selectUtcTiming(UTCTiming value) {
        this.utcTiming = value;

        setCounting(null);

    }


}
            