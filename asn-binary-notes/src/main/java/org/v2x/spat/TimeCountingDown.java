package org.v2x.spat;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.time.TimeMark;
import org.v2x.vehicle.Confidence;

/**
 * tested
 *
 * @author zhangyong
 */
@ASN1Sequence(name = "TimeCountingDown", isSet = false)
public class TimeCountingDown {

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

    public void setMinEndTime(TimeMark value) {
        this.minEndTime = value;
    }

    public boolean isMinEndTimePresent() {
        return this.minEndTime != null;
    }

    public TimeMark getMaxEndTime() {
        return this.maxEndTime;
    }

    public void setMaxEndTime(TimeMark value) {
        this.maxEndTime = value;
    }

    public boolean isMaxEndTimePresent() {
        return this.maxEndTime != null;
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

    public void setTimeConfidence(Confidence value) {
        this.timeConfidence = value;
    }

    public boolean isTimeConfidencePresent() {
        return this.timeConfidence != null;
    }

    public TimeMark getNextStartTime() {
        return this.nextStartTime;
    }

    public void setNextStartTime(TimeMark value) {
        this.nextStartTime = value;
    }

    public boolean isNextStartTimePresent() {
        return this.nextStartTime != null;
    }

    public TimeMark getNextDuration() {
        return this.nextDuration;
    }

    public void setNextDuration(TimeMark value) {
        this.nextDuration = value;
    }

    public boolean isNextDurationPresent() {
        return this.nextDuration != null;
    }

}
            