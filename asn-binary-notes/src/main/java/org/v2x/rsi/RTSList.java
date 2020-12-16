
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
@ASN1BoxedType(name = "RTSList")
public class RTSList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "RTSList", isSetOf = false)
    private java.util.Collection<RTSData> value = null;

    public RTSList() {
    }

    public RTSList(java.util.Collection<RTSData> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<RTSData> value) {
        this.value = value;
    }

    public java.util.Collection<RTSData> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<RTSData>());
    }

    public void add(RTSData item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(RTSList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            