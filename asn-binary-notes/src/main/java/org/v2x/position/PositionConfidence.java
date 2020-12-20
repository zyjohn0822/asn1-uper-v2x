package org.v2x.position;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "PositionConfidence"
)
public class PositionConfidence {
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

    public enum EnumType {
        /**
         *
         */
        @ASN1EnumItem(name = "unavailable", hasTag = true, tag = 0)
        unavailable,
        /**
         *
         */
        @ASN1EnumItem(name = "a500m", hasTag = true, tag = 1)
        a500m,
        /**
         *
         */
        @ASN1EnumItem(name = "a200m", hasTag = true, tag = 2)
        a200m,
        /**
         *
         */
        @ASN1EnumItem(name = "a100m", hasTag = true, tag = 3)
        a100m,
        /**
         *
         */
        @ASN1EnumItem(name = "a50m", hasTag = true, tag = 4)
        a50m,
        /**
         *
         */
        @ASN1EnumItem(name = "a20m", hasTag = true, tag = 5)
        a20m,
        /**
         *
         */
        @ASN1EnumItem(name = "a10m", hasTag = true, tag = 6)
        a10m,
        /**
         *
         */
        @ASN1EnumItem(name = "a5m", hasTag = true, tag = 7)
        a5m,
        /**
         *
         */
        @ASN1EnumItem(name = "a2m", hasTag = true, tag = 8)
        a2m,
        /**
         *
         */
        @ASN1EnumItem(name = "a1m", hasTag = true, tag = 9)
        a1m,
        /**
         *
         */
        @ASN1EnumItem(name = "a50cm", hasTag = true, tag = 10)
        a50cm,
        /**
         *
         */
        @ASN1EnumItem(name = "a20cm", hasTag = true, tag = 11)
        a20cm,
        /**
         *
         */
        @ASN1EnumItem(name = "a10cm", hasTag = true, tag = 12)
        a10cm,
        /**
         *
         */
        @ASN1EnumItem(name = "a5cm", hasTag = true, tag = 13)
        a5cm,
        /**
         *
         */
        @ASN1EnumItem(name = "a2cm", hasTag = true, tag = 14)
        a2cm,
        /**
         *
         */
        @ASN1EnumItem(name = "a1cm", hasTag = true, tag = 15)
        a1cm,
    }


}
            