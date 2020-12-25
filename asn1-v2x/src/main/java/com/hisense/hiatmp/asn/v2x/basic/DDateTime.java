package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * DDateTime ::= SEQUENCE {<br/>
 * year DYear OPTIONAL,<br/>
 * month DMonth OPTIONAL,<br/>
 * day DDay OPTIONAL,<br/>
 * hour DHour OPTIONAL,<br/>
 * minute DMinute OPTIONAL,<br/>
 * second DSecond OPTIONAL,<br/>
 * offset DTimeOffset OPTIONAL -- time zone<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/5  11:24
 */
@Sequence
@Setter
@Getter
public class DDateTime {
    @Component(0)
    @Asn1Optional
    public DYear year;
    @Component(1)
    @Asn1Optional
    public DMonth month;
    @Component(2)
    @Asn1Optional
    public DDay day;
    @Component(3)
    @Asn1Optional
    public DHour hour;
    @Component(4)
    @Asn1Optional
    public DMinute minute;
    @Component(5)
    @Asn1Optional
    public DSecond second;
    @Component(6)
    @Asn1Optional
    public DTimeOffset offset;

    public DDateTime() {

    }

    public DDateTime(DYear year,
                     DMonth month,
                     DDay day,
                     DHour hour,
                     DMinute minute,
                     DSecond second,
                     DTimeOffset offset) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.offset = offset;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"year\":")
                .append(year);
        sb.append(",\"month\":")
                .append(month);
        sb.append(",\"day\":")
                .append(day);
        sb.append(",\"hour\":")
                .append(hour);
        sb.append(",\"minute\":")
                .append(minute);
        sb.append(",\"second\":")
                .append(second);
        sb.append(",\"offset\":")
                .append(offset);
        sb.append('}');
        return sb.toString();
    }

    /**
     * DYear ::= INTEGER (0..4095)<br/>
     * -- units of years
     */
    @IntRange(minValue = 0, maxValue = 4095)
    public static class DYear extends Asn1Integer {
        public DYear() {
            this(0);
        }

        public DYear(int value) {
            super(value);
        }
    }

    /**
     * DMonth ::= INTEGER (0..12)<br/>
     * -- units of months
     */
    @IntRange(minValue = 0, maxValue = 12)
    public static class DMonth extends Asn1Integer {
        public DMonth() {
            this(0);
        }

        public DMonth(int value) {
            super(value);
        }
    }

    /**
     * DDay ::= INTEGER (0..31)<br/>
     * -- units of days
     */
    @IntRange(minValue = 0, maxValue = 31)
    public static class DDay extends Asn1Integer {
        public DDay() {
            this(0);
        }

        public DDay(int value) {
            super(value);
        }
    }

    /**
     * DHour ::= INTEGER (0..24)<br/>
     * -- units of hours
     */
    @IntRange(minValue = 0, maxValue = 24)
    public static class DHour extends Asn1Integer {
        public DHour() {
            this(0);
        }

        public DHour(int value) {
            super(value);
        }
    }

    /**
     * DMinute ::= INTEGER (0..60)<br/>
     * -- units of minutes
     */
    @IntRange(minValue = 0, maxValue = 60)
    public static class DMinute extends Asn1Integer {
        public DMinute() {
            this(0);
        }

        public DMinute(int value) {
            super(value);
        }
    }

    /**
     * DSecond ::= INTEGER (0..65535)<br/>
     * -- units of milliseconds
     */
    @IntRange(minValue = 0, maxValue = 65535)
    public static class DSecond extends Asn1Integer {
        public DSecond() {
            this(0);
        }

        public DSecond(int value) {
            super(value);
        }
    }

    /**
     * DTimeOffset ::= INTEGER (-720..721)<br/>
     * -- units of minutes from UTC time
     */
    @IntRange(minValue = -720, maxValue = 721)
    public static class DTimeOffset extends Asn1Integer {
        public DTimeOffset() {
            this(0);
        }

        public DTimeOffset(int value) {
            super(value);
        }
    }

    /**
     * MinuteOfTheYear ::= INTEGER (0..527040)<br/>
     * -- the value 527040 shall be used for invalid
     */
    @IntRange(minValue = 0, maxValue = 527040)
    public static class MinuteOfTheYear extends Asn1Integer {
        public MinuteOfTheYear() {
            this(0);
        }

        public MinuteOfTheYear(int value) {
            super(value);
        }

    }

    /**
     * TimeMark ::= INTEGER (0..36001)<br/>
     * -- Tenths of a second in the current or next hour<br/>
     * -- In units of 1/10th second from UTC time<br/>
     * -- A range of 0~36000 covers one hour<br/>
     * -- The values 35991..35999 are used when a leap second occurs<br/>
     * -- The value 36000 is used to indicate time >3600 seconds<br/>
     * -- 36001 is to be used when value undefined or unknown<br/>
     * -- Note that this is NOT expressed in GNSS time<br/>
     * -- or in local time
     */
    @IntRange(minValue = 0, maxValue = 36001)
    public static class TimeMark extends Asn1Integer {
        public TimeMark() {
            this(0);
        }

        public TimeMark(int value) {
            super(value);
        }

    }

    /**
     * TimeOffset ::= INTEGER (1..65535)<br/>
     * -- Units of of 10 mSec,<br/>
     * -- with a range of 0.01 seconds to 10 minutes and 55.34 seconds<br/>
     * -- a value of 65534 to be used for 655.34 seconds or greater<br/>
     * -- a value of 65535 to be unavailable<br/>
     */
    @IntRange(minValue = 1, maxValue = 65535)
    public static class TimeOffset extends Asn1Integer {

        public TimeOffset() {
            this(0);
        }

        public TimeOffset(int value) {
            super(value);
        }
    }

}
