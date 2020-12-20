package org.v2x.spat;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "PhaseStateList")
public class PhaseStateList {


    @ASN1SequenceOf(name = "PhaseStateList", isSetOf = false)
    private java.util.Collection<PhaseState> value = null;

    public PhaseStateList() {
    }

    public PhaseStateList(java.util.Collection<PhaseState> value) {
        setValue(value);
    }

    public java.util.Collection<PhaseState> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<PhaseState> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<PhaseState>());
    }

    public void add(PhaseState item) {
        value.add(item);
    }


}
            