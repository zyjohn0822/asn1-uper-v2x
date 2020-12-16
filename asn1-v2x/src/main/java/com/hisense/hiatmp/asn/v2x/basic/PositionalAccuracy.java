package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/4  19:13
 */
@Sequence
@Setter
@Getter
public class PositionalAccuracy {
    SemiMajorAxisAccuracy semiMajor;
    SemiMinorAxisAccuracy semiMinor;
    SemiMajorAxisOrientation orientation;

    public PositionalAccuracy() {

    }

    public PositionalAccuracy(SemiMajorAxisAccuracy semiMajor, SemiMinorAxisAccuracy semiMinor, SemiMajorAxisOrientation orientation) {
        this.semiMajor = semiMajor;
        this.semiMinor = semiMinor;
        this.orientation = orientation;
    }

    @IntRange(minValue = 0, maxValue = 255)
    public static class SemiMajorAxisAccuracy extends Asn1Integer {
        public SemiMajorAxisAccuracy() {
            this(0);
        }

        public SemiMajorAxisAccuracy(int value) {
            super(value);
        }
    }

    @IntRange(minValue = 0, maxValue = 255)
    public static class SemiMinorAxisAccuracy extends Asn1Integer {
        public SemiMinorAxisAccuracy() {
            this(0);
        }

        public SemiMinorAxisAccuracy(int value) {
            super(value);
        }
    }

    @IntRange(minValue = 0, maxValue = 65535)
    public static class SemiMajorAxisOrientation extends Asn1Integer {
        public SemiMajorAxisOrientation() {
            this(0);
        }

        public SemiMajorAxisOrientation(int value) {
            super(value);
        }
    }
}
