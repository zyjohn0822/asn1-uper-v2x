package org.v2x.rsi;

import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "EventSource"
)
public class EventSource {
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
        @ASN1EnumItem(name = "unknown", hasTag = true, tag = 0)
        unknown,
        /**
         *
         */
        @ASN1EnumItem(name = "police", hasTag = true, tag = 1)
        police,
        /**
         *
         */
        @ASN1EnumItem(name = "government", hasTag = true, tag = 2)
        government,
        /**
         *
         */
        @ASN1EnumItem(name = "meteorological", hasTag = true, tag = 3)
        meteorological,
        /**
         *
         */
        @ASN1EnumItem(name = "internet", hasTag = true, tag = 4)
        internet,
        /**
         *
         */
        @ASN1EnumItem(name = "detection", hasTag = true, tag = 5)
        detection
    }
}
            