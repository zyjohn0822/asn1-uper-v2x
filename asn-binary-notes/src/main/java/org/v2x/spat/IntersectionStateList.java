
package org.v2x.spat;


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
@ASN1BoxedType(name = "IntersectionStateList")
public class IntersectionStateList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "IntersectionStateList", isSetOf = false)
    private java.util.Collection<IntersectionState> value = null;

    public IntersectionStateList() {
    }

    public IntersectionStateList(java.util.Collection<IntersectionState> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<IntersectionState> value) {
        this.value = value;
    }

    public java.util.Collection<IntersectionState> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<IntersectionState>());
    }

    public void add(IntersectionState item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(IntersectionStateList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            