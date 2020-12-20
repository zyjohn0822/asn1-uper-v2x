package org.v2x.motion;

import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "SteeringWheelAngleConfidence"
)
public class SteeringWheelAngleConfidence {
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
        @ASN1EnumItem(name = "prec2deg", hasTag = true, tag = 1)
        prec2deg,
        /**
         *
         */
        @ASN1EnumItem(name = "prec1deg", hasTag = true, tag = 2)
        prec1deg,
        /**
         *
         */
        @ASN1EnumItem(name = "prec0-02deg", hasTag = true, tag = 3)
        prec0_02deg
    }

}
            