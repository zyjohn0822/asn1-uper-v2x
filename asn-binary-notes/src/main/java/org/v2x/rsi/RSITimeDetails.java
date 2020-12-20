package org.v2x.rsi;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.time.MinuteOfTheYear;
import org.v2x.time.TimeConfidence;

/**
 * @author zhangyong
 */
@ASN1Sequence(name = "RSITimeDetails", isSet = false)
public class RSITimeDetails {

    @ASN1Element(name = "startTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MinuteOfTheYear startTime = null;

    @ASN1Element(name = "endTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MinuteOfTheYear endTime = null;

    @ASN1Element(name = "endTimeConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeConfidence endTimeConfidence = null;


    public MinuteOfTheYear getStartTime() {
        return this.startTime;
    }

    public void setStartTime(MinuteOfTheYear value) {
        this.startTime = value;
    }

    public boolean isStartTimePresent() {
        return this.startTime != null;
    }

    public MinuteOfTheYear getEndTime() {
        return this.endTime;
    }

    public void setEndTime(MinuteOfTheYear value) {
        this.endTime = value;
    }

    public boolean isEndTimePresent() {
        return this.endTime != null;
    }

    public TimeConfidence getEndTimeConfidence() {
        return this.endTimeConfidence;
    }

    public void setEndTimeConfidence(TimeConfidence value) {
        this.endTimeConfidence = value;
    }

    public boolean isEndTimeConfidencePresent() {
        return this.endTimeConfidence != null;
    }

}
            