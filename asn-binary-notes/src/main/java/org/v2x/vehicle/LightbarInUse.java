
package org.v2x.vehicle;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Enum(
        name = "LightbarInUse"
)
public class LightbarInUse implements IASN1PreparedElement {
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

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(LightbarInUse.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            