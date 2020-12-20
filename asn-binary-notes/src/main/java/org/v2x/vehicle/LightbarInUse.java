package org.v2x.vehicle;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "LightbarInUse"
)
public class LightbarInUse {
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
        @ASN1EnumItem(name = "notInUse", hasTag = true, tag = 1)
        notInUse,
        /**
         *
         */
        @ASN1EnumItem(name = "inUse", hasTag = true, tag = 2)
        inUse,
        /**
         *
         */
        @ASN1EnumItem(name = "yellowCautionLights", hasTag = true, tag = 3)
        yellowCautionLights,
        /**
         *
         */
        @ASN1EnumItem(name = "schooldBusLights", hasTag = true, tag = 4)
        schooldBusLights,
        /**
         *
         */
        @ASN1EnumItem(name = "arrowSignsActive", hasTag = true, tag = 5)
        arrowSignsActive,
        /**
         *
         */
        @ASN1EnumItem(name = "slowMovingVehicle", hasTag = true, tag = 6)
        slowMovingVehicle,
        /**
         *
         */
        @ASN1EnumItem(name = "freqStops", hasTag = true, tag = 7)
        freqStops
    }

}
            