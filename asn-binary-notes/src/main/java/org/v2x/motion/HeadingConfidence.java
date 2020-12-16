
package org.v2x.motion;

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
        name = "HeadingConfidence"
)
public class HeadingConfidence implements IASN1PreparedElement {
    public enum EnumType {
        /**
         *
         */
        @ASN1EnumItem(name = "unavailable", hasTag = true, tag = 0)
        unavailable,
        /**
         *
         */
        @ASN1EnumItem(name = "prec10deg", hasTag = true, tag = 1)
        prec10deg,
        /**
         *
         */
        @ASN1EnumItem(name = "prec05deg", hasTag = true, tag = 2)
        prec05deg,
        /**
         *
         */
        @ASN1EnumItem(name = "prec01deg", hasTag = true, tag = 3)
        prec01deg,
        /**
         *
         */
        @ASN1EnumItem(name = "prec0-1deg", hasTag = true, tag = 4)
        prec0_1deg,
        /**
         *
         */
        @ASN1EnumItem(name = "prec0-05deg", hasTag = true, tag = 5)
        prec0_05deg,
        /**
         *
         */
        @ASN1EnumItem(name = "prec0-01deg", hasTag = true, tag = 6)
        prec0_01deg,
        /**
         *
         */
        @ASN1EnumItem(name = "prec0-0125deg", hasTag = true, tag = 7)
        prec0_0125deg,
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
    @Override
    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(HeadingConfidence.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            