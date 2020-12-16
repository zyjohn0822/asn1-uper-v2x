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

    public enum TimeConfidence {
        /**
         * -- Not Equipped or unavailable
         */
        unavailable(0),
        /**
         * -- Better than 100 Seconds
         */
        time_100_000(1),
        /**
         * -- Better than 50 Seconds
         */
        time_050_000(2),
        /**
         * -- Better than 20 Seconds
         */
        time_020_000(3),
        /**
         * -- Better than 10 Seconds
         */
        time_010_000(4),
        /**
         * -- Better than 2 Seconds
         */
        time_002_000(5),
        /**
         * -- Better than 1 Second
         */
        time_001_000(6),
        /**
         * -- Better than 0.5 Seconds
         */
        time_000_500(7),
        /**
         * -- Better than 0.2 Seconds
         */
        time_000_200(8),
        /**
         * -- Better than 0.1 Seconds
         */
        time_000_100(9),
        /**
         * -- Better than 0.05 Seconds
         */
        time_000_050(10),
        /**
         * -- Better than 0.02 Seconds
         */
        time_000_020(11),
        /**
         * -- Better than 0.01 Seconds
         */
        time_000_010(12),
        /**
         * -- Better than 0.005 Seconds
         */
        time_000_005(13),
        /**
         * -- Better than 0.002 Seconds
         */
        time_000_002(14),
        /**
         * -- Better than 0.001 Seconds
         */
        time_000_001(15),
        /**
         * -- Better than 0.000,5 Seconds
         */
        time_000_000_5(16),
        /**
         * -- Better than 0.000,2 Seconds
         */
        time_000_000_2(17),
        /**
         * -- Better than 0.000,1 Seconds
         */
        time_000_000_1(18),
        /**
         * -- Better than 0.000,05 Seconds
         */
        time_000_000_05(19),
        /**
         * -- Better than 0.000,02 Seconds
         */
        time_000_000_02(20),
        /**
         * -- Better than 0.000,01 Seconds
         */
        time_000_000_01(21),
        /**
         * -- Better than 0.000,005 Seconds
         */
        time_000_000_005(22),
        /**
         * -- Better than 0.000,002 Seconds
         */
        time_000_000_002(23),
        /**
         * -- Better than 0.000,001 Seconds
         */
        time_000_000_001(24),
        /**
         * -- Better than 0.000,000,5 Seconds
         */
        time_000_000_000_5(25),
        /**
         * -- Better than 0.000,000,2 Seconds
         */
        time_000_000_000_2(26),
        /**
         * -- Better than 0.000,000,1 Seconds
         */
        time_000_000_000_1(27),
        /**
         * -- Better than 0.000,000,05 Seconds
         */
        time_000_000_000_05(28),
        /**
         * -- Better than 0.000,000,02 Seconds
         */
        time_000_000_000_02(29),
        /**
         * -- Better than 0.000,000,01 Seconds
         */
        time_000_000_000_01(30),
        /**
         * -- Better than 0.000,000,005 Seconds
         */
        time_000_000_000_005(31),
        /**
         * -- Better than 0.000,000,002 Seconds
         */
        time_000_000_000_002(32),
        /**
         * -- Better than 0.000,000,001 Seconds
         */
        time_000_000_000_001(33),
        /**
         * -- Better than 0.000,000,000,5 Seconds
         */
        time_000_000_000_000_5(34),
        /**
         * -- Better than 0.000,000,000,2 Seconds
         */
        time_000_000_000_000_2(35),
        /**
         * -- Better than 0.000,000,000,1 Seconds
         */
        time_000_000_000_000_1(36),
        /**
         * -- Better than 0.000,000,000,05 Seconds
         */
        time_000_000_000_000_05(37),
        /**
         * -- Better than 0.000,000,000,02 Seconds
         */
        time_000_000_000_000_02(38),
        /**
         * -- Better than 0.000,000,000,01 Seconds
         */
        time_000_000_000_000_01(39);

        private final int value;

        TimeConfidence(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
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
