
package org.v2x.rsi;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1SequenceOf;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;

/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1BoxedType(name = "RTEList")
public class RTEList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "RTEList", isSetOf = false)
    private java.util.Collection<RTEData> value = null;

    public RTEList() {
    }

    public RTEList(java.util.Collection<RTEData> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<RTEData> value) {
        this.value = value;
    }

    public java.util.Collection<RTEData> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<RTEData>());
    }

    public void add(RTEData item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(RTEList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            