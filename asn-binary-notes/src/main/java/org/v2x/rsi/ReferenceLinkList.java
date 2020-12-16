
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
@ASN1BoxedType(name = "ReferenceLinkList")
public class ReferenceLinkList implements IASN1PreparedElement {


    @ASN1SequenceOf(name = "ReferenceLinkList", isSetOf = false)
    private java.util.Collection<ReferenceLink> value = null;

    public ReferenceLinkList() {
    }

    public ReferenceLinkList(java.util.Collection<ReferenceLink> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<ReferenceLink> value) {
        this.value = value;
    }

    public java.util.Collection<ReferenceLink> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<ReferenceLink>());
    }

    public void add(ReferenceLink item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ReferenceLinkList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            