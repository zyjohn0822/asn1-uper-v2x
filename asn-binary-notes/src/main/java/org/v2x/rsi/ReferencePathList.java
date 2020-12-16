
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
@ASN1BoxedType(name = "ReferencePathList")
public class ReferencePathList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "ReferencePathList", isSetOf = false)
    private java.util.Collection<ReferencePath> value = null;

    public ReferencePathList() {
    }

    public ReferencePathList(java.util.Collection<ReferencePath> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<ReferencePath> value) {
        this.value = value;
    }

    public java.util.Collection<ReferencePath> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<ReferencePath>());
    }

    public void add(ReferencePath item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ReferencePathList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            