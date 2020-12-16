
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
        name = "SpeedConfidence"
)
public class SpeedConfidence implements IASN1PreparedElement {
    public enum EnumType {
        /**
         *
         */
        @ASN1EnumItem(name = "unavailable", hasTag = true, tag = 0)
        unavailable,
        /**
         *
         */
        @ASN1EnumItem(name = "prec100ms", hasTag = true, tag = 1)
        prec100ms,
        /**
         *
         */
        @ASN1EnumItem(name = "prec10ms", hasTag = true, tag = 2)
        prec10ms,
        /**
         *
         */
        @ASN1EnumItem(name = "prec5ms", hasTag = true, tag = 3)
        prec5ms,
        /**
         *
         */
        @ASN1EnumItem(name = "prec1ms", hasTag = true, tag = 4)
        prec1ms,
        /**
         *
         */
        @ASN1EnumItem(name = "prec0-1ms", hasTag = true, tag = 5)
        prec0_1ms,
        /**
         *
         */
        @ASN1EnumItem(name = "prec0-05ms", hasTag = true, tag = 6)
        prec0_05ms,
        /**
         *
         */
        @ASN1EnumItem(name = "prec0-01ms", hasTag = true, tag = 7)
        prec0_01ms,
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(SpeedConfidence.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            