package org.v2x.spat;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "PhaseList")
public class PhaseList {


    @ASN1SequenceOf(name = "PhaseList", isSetOf = false)
    private java.util.Collection<Phase> value = null;

    public PhaseList() {
    }

    public PhaseList(java.util.Collection<Phase> value) {
        setValue(value);
    }

    public java.util.Collection<Phase> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<Phase> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Phase>());
    }

    public void add(Phase item) {
        value.add(item);
    }


}
            