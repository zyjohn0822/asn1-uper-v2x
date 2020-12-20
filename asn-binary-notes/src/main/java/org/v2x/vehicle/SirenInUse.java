package org.v2x.vehicle;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "SirenInUse"
)
public class SirenInUse {
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
        @ASN1EnumItem(name = "notInUse", hasTag = true, tag = 1)
        notInUse,
        @ASN1EnumItem(name = "inUse", hasTag = true, tag = 2)
        inUse,
        @ASN1EnumItem(name = "reserved", hasTag = true, tag = 3)
        reserved,
    }


}
            