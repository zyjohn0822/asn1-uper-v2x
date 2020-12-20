package org.v2x.rsm;

import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "ParticipantType"
)
public class ParticipantType {
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
        @ASN1EnumItem(name = "motor", hasTag = true, tag = 1)
        motor,
        /**
         *
         */
        @ASN1EnumItem(name = "non-motor", hasTag = true, tag = 2)
        non_motor,
        /**
         *
         */
        @ASN1EnumItem(name = "pedestrian", hasTag = true, tag = 3)
        pedestrian,
        /**
         *
         */
        @ASN1EnumItem(name = "rsu", hasTag = true, tag = 4)
        rsu,
    }

}
            