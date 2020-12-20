package org.v2x.position;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "ElevationConfidence"
)
public class ElevationConfidence {
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
        @ASN1EnumItem(name = "elev-500-00", hasTag = true, tag = 1)
        elev_500_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-200-00", hasTag = true, tag = 2)
        elev_200_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-100-00", hasTag = true, tag = 3)
        elev_100_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-050-00", hasTag = true, tag = 4)
        elev_050_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-020-00", hasTag = true, tag = 5)
        elev_020_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-010-00", hasTag = true, tag = 6)
        elev_010_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-005-00", hasTag = true, tag = 7)
        elev_005_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-002-00", hasTag = true, tag = 8)
        elev_002_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-001-00", hasTag = true, tag = 9)
        elev_001_00,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-000-50", hasTag = true, tag = 10)
        elev_000_50,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-000-20", hasTag = true, tag = 11)
        elev_000_20,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-000-10", hasTag = true, tag = 12)
        elev_000_10,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-000-05", hasTag = true, tag = 13)
        elev_000_05,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-000-02", hasTag = true, tag = 14)
        elev_000_02,
        /**
         *
         */
        @ASN1EnumItem(name = "elev-000-01", hasTag = true, tag = 15)
        elev_000_01
    }

}
            