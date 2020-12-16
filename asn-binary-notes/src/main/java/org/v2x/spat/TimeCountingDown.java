
package org.v2x.spat;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.time.TimeMark;
import org.v2x.vehicle.Confidence;

/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "TimeCountingDown", isSet = false)
public class TimeCountingDown implements IASN1PreparedElement {

    @ASN1Element(name = "startTime", isOptional = false, hasTag = false, hasDefaultValue = false)
    private TimeMark startTime = null;

    @ASN1Element(name = "minEndTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeMark minEndTime = null;

    @ASN1Element(name = "maxEndTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeMark maxEndTime = null;

    @ASN1Element(name = "likelyEndTime", isOptional = false, hasTag = false, hasDefaultValue = false)
    private TimeMark likelyEndTime = null;

    @ASN1Element(name = "timeConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Confidence timeConfidence = null;

    @ASN1Element(name = "nextStartTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeMark nextStartTime = null;

    @ASN1Element(name = "nextDuration", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeMark nextDuration = null;


    public TimeMark getStartTime() {
        return this.startTime;
    }


    public void setStartTime(TimeMark value) {
        this.startTime = value;
    }


    public TimeMark getMinEndTime() {
        return this.minEndTime;
    }


    public boolean isMinEndTimePresent() {
        return this.minEndTime != null;
    }


    public void setMinEndTime(TimeMark value) {
        this.minEndTime = value;
    }


    public TimeMark getMaxEndTime() {
        return this.maxEndTime;
    }


    public boolean isMaxEndTimePresent() {
        return this.maxEndTime != null;
    }


    public void setMaxEndTime(TimeMark value) {
        this.maxEndTime = value;
    }


    public TimeMark getLikelyEndTime() {
        return this.likelyEndTime;
    }


    public void setLikelyEndTime(TimeMark value) {
        this.likelyEndTime = value;
    }


    public Confidence getTimeConfidence() {
        return this.timeConfidence;
    }


    public boolean isTimeConfidencePresent() {
        return this.timeConfidence != null;
    }


    public void setTimeConfidence(Confidence value) {
        this.timeConfidence = value;
    }


    public TimeMark getNextStartTime() {
        return this.nextStartTime;
    }


    public boolean isNextStartTimePresent() {
        return this.nextStartTime != null;
    }


    public void setNextStartTime(TimeMark value) {
        this.nextStartTime = value;
    }


    public TimeMark getNextDuration() {
        return this.nextDuration;
    }


    public boolean isNextDurationPresent() {
        return this.nextDuration != null;
    }


    public void setNextDuration(TimeMark value) {
        this.nextDuration = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(TimeCountingDown.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            