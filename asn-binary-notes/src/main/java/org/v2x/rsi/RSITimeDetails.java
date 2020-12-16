
package org.v2x.rsi;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.time.MinuteOfTheYear;
import org.v2x.time.TimeConfidence;

/**
 *
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "RSITimeDetails", isSet = false)
public class RSITimeDetails implements IASN1PreparedElement {

    @ASN1Element(name = "startTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MinuteOfTheYear startTime = null;

    @ASN1Element(name = "endTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MinuteOfTheYear endTime = null;

    @ASN1Element(name = "endTimeConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeConfidence endTimeConfidence = null;


    public MinuteOfTheYear getStartTime() {
        return this.startTime;
    }


    public boolean isStartTimePresent() {
        return this.startTime != null;
    }


    public void setStartTime(MinuteOfTheYear value) {
        this.startTime = value;
    }


    public MinuteOfTheYear getEndTime() {
        return this.endTime;
    }


    public boolean isEndTimePresent() {
        return this.endTime != null;
    }


    public void setEndTime(MinuteOfTheYear value) {
        this.endTime = value;
    }


    public TimeConfidence getEndTimeConfidence() {
        return this.endTimeConfidence;
    }


    public boolean isEndTimeConfidencePresent() {
        return this.endTimeConfidence != null;
    }


    public void setEndTimeConfidence(TimeConfidence value) {
        this.endTimeConfidence = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(RSITimeDetails.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            