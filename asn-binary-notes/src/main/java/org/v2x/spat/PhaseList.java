
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
@ASN1BoxedType(name = "PhaseList")
public class PhaseList implements IASN1PreparedElement {


    @ASN1SequenceOf(name = "PhaseList", isSetOf = false)
    private java.util.Collection<Phase> value = null;

    public PhaseList() {
    }

    public PhaseList(java.util.Collection<Phase> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<Phase> value) {
        this.value = value;
    }

    public java.util.Collection<Phase> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Phase>());
    }

    public void add(Phase item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PhaseList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            