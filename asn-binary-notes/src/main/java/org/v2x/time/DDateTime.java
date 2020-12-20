package org.v2x.time;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "DDateTime", isSet = false)
public class DDateTime {

    @ASN1Element(name = "year", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DYear year = null;

    @ASN1Element(name = "month", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DMonth month = null;

    @ASN1Element(name = "day", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DDay day = null;

    @ASN1Element(name = "hour", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DHour hour = null;

    @ASN1Element(name = "minute", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DMinute minute = null;

    @ASN1Element(name = "second", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DSecond second = null;

    @ASN1Element(name = "offset", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DTimeOffset offset = null;


    public DYear getYear() {
        return this.year;
    }

    public void setYear(DYear value) {
        this.year = value;
    }

    public boolean isYearPresent() {
        return this.year != null;
    }

    public DMonth getMonth() {
        return this.month;
    }

    public void setMonth(DMonth value) {
        this.month = value;
    }

    public boolean isMonthPresent() {
        return this.month != null;
    }

    public DDay getDay() {
        return this.day;
    }

    public void setDay(DDay value) {
        this.day = value;
    }

    public boolean isDayPresent() {
        return this.day != null;
    }

    public DHour getHour() {
        return this.hour;
    }

    public void setHour(DHour value) {
        this.hour = value;
    }

    public boolean isHourPresent() {
        return this.hour != null;
    }

    public DMinute getMinute() {
        return this.minute;
    }

    public void setMinute(DMinute value) {
        this.minute = value;
    }

    public boolean isMinutePresent() {
        return this.minute != null;
    }

    public DSecond getSecond() {
        return this.second;
    }

    public void setSecond(DSecond value) {
        this.second = value;
    }

    public boolean isSecondPresent() {
        return this.second != null;
    }

    public DTimeOffset getOffset() {
        return this.offset;
    }

    public void setOffset(DTimeOffset value) {
        this.offset = value;
    }

    public boolean isOffsetPresent() {
        return this.offset != null;
    }


}
            