
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
        name = "ResponseType"
)
public class ResponseType implements IASN1PreparedElement {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ResponseType.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            