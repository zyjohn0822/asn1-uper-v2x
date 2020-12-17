package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.IntRange;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/5  11:24
 */
@Sequence
@Setter
@Getter
public class DDateTime {
    @Asn1Optional
    DYear year;
    @Asn1Optional
    DMonth month;
    @Asn1Optional
    DDay day;
    @Asn1Optional
    DHour hour;
    @Asn1Optional
    DMinute minute;
    @Asn1Optional
    DSecond second;
    @Asn1Optional
    DTimeOffset offset;

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
    @IntRange(minValue = 0, maxValue = 4095)
    public static class DYear extends Asn1Integer {
        public DYear() {
            this(0);
        }

        public DYear(int value) {
            super(value);
        }
    }

    @IntRange(minValue = 0, maxValue = 12)
    public static class DMonth extends Asn1Integer {
        public DMonth() {
            this(0);
        }

        public DMonth(int value) {
            super(value);
        }
    }

    @IntRange(minValue = 0, maxValue = 31)
    public static class DDay extends Asn1Integer {
        public DDay() {
            this(0);
        }

        public DDay(int value) {
            super(value);
        }
    }

    @IntRange(minValue = 0, maxValue = 24)
    public static class DHour extends Asn1Integer {
        public DHour() {
            this(0);
        }

        public DHour(int value) {
            super(value);
        }
    }

    @IntRange(minValue = 0, maxValue = 60)
    public static class DMinute extends Asn1Integer {
        public DMinute() {
            this(0);
        }

        public DMinute(int value) {
            super(value);
        }
    }

    @IntRange(minValue = 0, maxValue = 65535)
    public static class DSecond extends Asn1Integer {
        public DSecond() {
            this(0);
        }

        public DSecond(int value) {
            super(value);
        }
    }

    @IntRange(minValue = -720, maxValue = 721)
    public static class DTimeOffset extends Asn1Integer {
        public DTimeOffset() {
            this(0);
        }

        public DTimeOffset(int value) {
            super(value);
        }
    }

    @IntRange(minValue = 0, maxValue = 527040)
    public static class MinuteOfTheYear extends Asn1Integer {
        public MinuteOfTheYear() {
            this(0);
        }

        public MinuteOfTheYear(int value) {
            super(value);
        }

    }

    @IntRange(minValue = 0, maxValue = 36001)
    public static class TimeMark extends Asn1Integer {
        public TimeMark() {
            this(0);
        }

        public TimeMark(int value) {
            super(value);
        }

    }

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
