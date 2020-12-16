
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
@ASN1BoxedType(name = "PhaseStateList")
public class PhaseStateList implements IASN1PreparedElement {


    @ASN1SequenceOf(name = "PhaseStateList", isSetOf = false)
    private java.util.Collection<PhaseState> value = null;

    public PhaseStateList() {
    }

    public PhaseStateList(java.util.Collection<PhaseState> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<PhaseState> value) {
        this.value = value;
    }

    public java.util.Collection<PhaseState> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<PhaseState>());
    }

    public void add(PhaseState item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PhaseStateList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            