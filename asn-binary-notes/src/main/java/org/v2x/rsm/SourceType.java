package org.v2x.rsm;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "SourceType"
)
public class SourceType {
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
        @ASN1EnumItem(name = "selfinfo", hasTag = true, tag = 1)
        selfinfo,
        /**
         *
         */
        @ASN1EnumItem(name = "v2x", hasTag = true, tag = 2)
        v2x,
        /**
         *
         */
        @ASN1EnumItem(name = "video", hasTag = true, tag = 3)
        video,
        /**
         *
         */
        @ASN1EnumItem(name = "microwaveRadar", hasTag = true, tag = 4)
        microwaveRadar,
        /**
         *
         */
        @ASN1EnumItem(name = "loop", hasTag = true, tag = 5)
        loop,
        /**
         *
         */
        @ASN1EnumItem(name = "lidar", hasTag = true, tag = 6)
        lidar,
        /**
         *
         */
        @ASN1EnumItem(name = "integrated", hasTag = true, tag = 7)
        integrated
    }


}
            