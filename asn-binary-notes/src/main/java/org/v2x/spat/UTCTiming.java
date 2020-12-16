
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
@ASN1Sequence(name = "UTCTiming", isSet = false)
public class UTCTiming implements IASN1PreparedElement {

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


    public boolean isMinEndUTCTimePresent() {
        return this.minEndUTCTime != null;
    }


    public void setMinEndUTCTime(TimeMark value) {
        this.minEndUTCTime = value;
    }


    public TimeMark getMaxEndUTCTime() {
        return this.maxEndUTCTime;
    }


    public boolean isMaxEndUTCTimePresent() {
        return this.maxEndUTCTime != null;
    }


    public void setMaxEndUTCTime(TimeMark value) {
        this.maxEndUTCTime = value;
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


    public boolean isTimeConfidencePresent() {
        return this.timeConfidence != null;
    }


    public void setTimeConfidence(Confidence value) {
        this.timeConfidence = value;
    }


    public TimeMark getNextStartUTCTime() {
        return this.nextStartUTCTime;
    }


    public boolean isNextStartUTCTimePresent() {
        return this.nextStartUTCTime != null;
    }


    public void setNextStartUTCTime(TimeMark value) {
        this.nextStartUTCTime = value;
    }


    public TimeMark getNextEndUTCTime() {
        return this.nextEndUTCTime;
    }


    public boolean isNextEndUTCTimePresent() {
        return this.nextEndUTCTime != null;
    }


    public void setNextEndUTCTime(TimeMark value) {
        this.nextEndUTCTime = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(UTCTiming.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            