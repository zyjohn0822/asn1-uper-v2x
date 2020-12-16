
package org.v2x.spat;


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
        name = "LightState"
)
public class LightState implements IASN1PreparedElement {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(LightState.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            