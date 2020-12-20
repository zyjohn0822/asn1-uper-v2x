package org.v2x.vehicle;


import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "TransmissionState"
)
public class TransmissionState {
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"value\":")
                .append(value);
        sb.append(",\"integerForm\":")
                .append(integerForm);
        sb.append('}');
        return sb.toString();
    }

    public enum EnumType {
        /**
         *
         */
        @ASN1EnumItem(name = "neutral", hasTag = true, tag = 0)
        neutral,
        @ASN1EnumItem(name = "park", hasTag = true, tag = 1)
        park,
        @ASN1EnumItem(name = "forwardGears", hasTag = true, tag = 2)
        forwardGears,
        @ASN1EnumItem(name = "reverseGears", hasTag = true, tag = 3)
        reverseGears,
        @ASN1EnumItem(name = "reserved1", hasTag = true, tag = 4)
        reserved1,
        @ASN1EnumItem(name = "reserved2", hasTag = true, tag = 5)
        reserved2,
        @ASN1EnumItem(name = "reserved3", hasTag = true, tag = 6)
        reserved3,
        @ASN1EnumItem(name = "unavailable", hasTag = true, tag = 7)
        unavailable
    }
}
            