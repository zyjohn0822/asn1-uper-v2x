
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
        name = "SourceType"
)
public class SourceType implements IASN1PreparedElement {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(SourceType.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            