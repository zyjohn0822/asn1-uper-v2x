
package org.v2x.rsm;

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
        name = "ParticipantType"
)
public class ParticipantType implements IASN1PreparedElement {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ParticipantType.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            