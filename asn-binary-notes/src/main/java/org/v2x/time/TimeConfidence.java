package org.v2x.time;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "TimeConfidence"
)
public class TimeConfidence {
    private EnumType value;
    private Integer integerForm;

    public EnumType getValue() {
        return this.value;
    }

    public void setValue(EnumType value) {
        this.value = value;
    }

    public Integer getIntegerForm() {
        return integerForm;
    }

    public void setIntegerForm(Integer value) {
        integerForm = value;
    }

    public enum EnumType {
        /**
         *
         */
        @ASN1EnumItem(name = "unavailable", hasTag = true, tag = 0)
        unavailable,
        /**
         *
         */
        @ASN1EnumItem(name = "time-100-000", hasTag = true, tag = 1)
        time_100_000,
        /**
         *
         */
        @ASN1EnumItem(name = "time-050-000", hasTag = true, tag = 2)
        time_050_000,
        /**
         *
         */
        @ASN1EnumItem(name = "time-020-000", hasTag = true, tag = 3)
        time_020_000,
        /**
         *
         */
        @ASN1EnumItem(name = "time-010-000", hasTag = true, tag = 4)
        time_010_000,
        /**
         *
         */
        @ASN1EnumItem(name = "time-002-000", hasTag = true, tag = 5)
        time_002_000,
        /**
         *
         */
        @ASN1EnumItem(name = "time-001-000", hasTag = true, tag = 6)
        time_001_000,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-500", hasTag = true, tag = 7)
        time_000_500,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-200", hasTag = true, tag = 8)
        time_000_200,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-100", hasTag = true, tag = 9)
        time_000_100,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-050", hasTag = true, tag = 10)
        time_000_050,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-020", hasTag = true, tag = 11)
        time_000_020,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-010", hasTag = true, tag = 12)
        time_000_010,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-005", hasTag = true, tag = 13)
        time_000_005,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-002", hasTag = true, tag = 14)
        time_000_002,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-001", hasTag = true, tag = 15)
        time_000_001,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-5", hasTag = true, tag = 16)
        time_000_000_5,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-2", hasTag = true, tag = 17)
        time_000_000_2,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-1", hasTag = true, tag = 18)
        time_000_000_1,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-05", hasTag = true, tag = 19)
        time_000_000_05,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-02", hasTag = true, tag = 20)
        time_000_000_02,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-01", hasTag = true, tag = 21)
        time_000_000_01,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-005", hasTag = true, tag = 22)
        time_000_000_005,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-002", hasTag = true, tag = 23)
        time_000_000_002,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-001", hasTag = true, tag = 24)
        time_000_000_001,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-5", hasTag = true, tag = 25)
        time_000_000_000_5,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-2", hasTag = true, tag = 26)
        time_000_000_000_2,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-1", hasTag = true, tag = 27)
        time_000_000_000_1,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-05", hasTag = true, tag = 28)
        time_000_000_000_05,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-02", hasTag = true, tag = 29)
        time_000_000_000_02,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-01", hasTag = true, tag = 30)
        time_000_000_000_01,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-005", hasTag = true, tag = 31)
        time_000_000_000_005,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-002", hasTag = true, tag = 32)
        time_000_000_000_002,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-001", hasTag = true, tag = 33)
        time_000_000_000_001,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-000-5", hasTag = true, tag = 34)
        time_000_000_000_000_5,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-000-2", hasTag = true, tag = 35)
        time_000_000_000_000_2,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-000-1", hasTag = true, tag = 36)
        time_000_000_000_000_1,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-000-05", hasTag = true, tag = 37)
        time_000_000_000_000_05,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-000-02", hasTag = true, tag = 38)
        time_000_000_000_000_02,
        /**
         *
         */
        @ASN1EnumItem(name = "time-000-000-000-000-01", hasTag = true, tag = 39)
        time_000_000_000_000_01
    }


}
            