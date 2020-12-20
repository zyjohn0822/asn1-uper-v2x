package org.v2x.spat;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "LightState"
)
public class LightState {
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
        @ASN1EnumItem(name = "dark", hasTag = true, tag = 1)
        dark,
        /**
         *
         */
        @ASN1EnumItem(name = "flashing-red", hasTag = true, tag = 2)
        flashing_red,
        /**
         *
         */
        @ASN1EnumItem(name = "red", hasTag = true, tag = 3)
        red,
        /**
         *
         */
        @ASN1EnumItem(name = "flashing-green", hasTag = true, tag = 4)
        flashing_green,
        /**
         *
         */
        @ASN1EnumItem(name = "permissive-green", hasTag = true, tag = 5)
        permissive_green,
        /**
         *
         */
        @ASN1EnumItem(name = "protected-green", hasTag = true, tag = 6)
        protected_green,
        /**
         *
         */
        @ASN1EnumItem(name = "yellow", hasTag = true, tag = 7)
        yellow,
        /**
         *
         */
        @ASN1EnumItem(name = "flashing-yellow", hasTag = true, tag = 8)
        flashing_yellow
    }


}
            