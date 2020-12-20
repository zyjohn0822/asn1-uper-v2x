package org.v2x.vehicle;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */

@ASN1Enum(
        name = "ResponseType"
)
public class ResponseType {
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
        @ASN1EnumItem(name = "notInUseOrNotEquipped", hasTag = true, tag = 0)
        notInUseOrNotEquipped,
        @ASN1EnumItem(name = "emergency", hasTag = true, tag = 1)
        emergency,
        @ASN1EnumItem(name = "nonEmergency", hasTag = true, tag = 2)
        nonEmergency,
        @ASN1EnumItem(name = "pursuit", hasTag = true, tag = 3)
        pursuit,
        @ASN1EnumItem(name = "stationary", hasTag = true, tag = 4)
        stationary,
        @ASN1EnumItem(name = "slowMoving", hasTag = true, tag = 5)
        slowMoving,
        @ASN1EnumItem(name = "stopAndGoMovement", hasTag = true, tag = 6)
        stopAndGoMovement,
    }

}
            