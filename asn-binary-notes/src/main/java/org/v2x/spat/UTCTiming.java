package org.v2x.spat;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.time.TimeMark;
import org.v2x.vehicle.Confidence;

/**
 * @author zhangyong
 */
@ASN1Sequence(name = "UTCTiming", isSet = false)
public class UTCTiming {

    @ASN1Element(name = "startUTCTime", isOptional = false, hasTag = false, hasDefaultValue = false)
    private TimeMark startUTCTime = null;

    @ASN1Element(name = "minEndUTCTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeMark minEndUTCTime = null;

    @ASN1Element(name = "maxEndUTCTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeMark maxEndUTCTime = null;

    @ASN1Element(name = "likelyEndUTCTime", isOptional = false, hasTag = false, hasDefaultValue = false)
    private TimeMark likelyEndUTCTime = null;

    @ASN1Element(name = "timeConfidence", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Confidence timeConfidence = null;

    @ASN1Element(name = "nextStartUTCTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeMark nextStartUTCTime = null;

    @ASN1Element(name = "nextEndUTCTime", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TimeMark nextEndUTCTime = null;


    public TimeMark getStartUTCTime() {
        return this.startUTCTime;
    }


    public void setStartUTCTime(TimeMark value) {
        this.startUTCTime = value;
    }


    public TimeMark getMinEndUTCTime() {
        return this.minEndUTCTime;
    }

    public void setMinEndUTCTime(TimeMark value) {
        this.minEndUTCTime = value;
    }

    public boolean isMinEndUTCTimePresent() {
        return this.minEndUTCTime != null;
    }

    public TimeMark getMaxEndUTCTime() {
        return this.maxEndUTCTime;
    }

    public void setMaxEndUTCTime(TimeMark value) {
        this.maxEndUTCTime = value;
    }

    public boolean isMaxEndUTCTimePresent() {
        return this.maxEndUTCTime != null;
    }

    public TimeMark getLikelyEndUTCTime() {
        return this.likelyEndUTCTime;
    }


    public void setLikelyEndUTCTime(TimeMark value) {
        this.likelyEndUTCTime = value;
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

    public TimeMark getNextStartUTCTime() {
        return this.nextStartUTCTime;
    }

    public void setNextStartUTCTime(TimeMark value) {
        this.nextStartUTCTime = value;
    }

    public boolean isNextStartUTCTimePresent() {
        return this.nextStartUTCTime != null;
    }

    public TimeMark getNextEndUTCTime() {
        return this.nextEndUTCTime;
    }

    public void setNextEndUTCTime(TimeMark value) {
        this.nextEndUTCTime = value;
    }

    public boolean isNextEndUTCTimePresent() {
        return this.nextEndUTCTime != null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"startUTCTime\":")
                .append(startUTCTime);
        sb.append(",\"minEndUTCTime\":")
                .append(minEndUTCTime);
        sb.append(",\"maxEndUTCTime\":")
                .append(maxEndUTCTime);
        sb.append(",\"likelyEndUTCTime\":")
                .append(likelyEndUTCTime);
        sb.append(",\"timeConfidence\":")
                .append(timeConfidence);
        sb.append(",\"nextStartUTCTime\":")
                .append(nextStartUTCTime);
        sb.append(",\"nextEndUTCTime\":")
                .append(nextEndUTCTime);
        sb.append('}');
        return sb.toString();
    }
}
            