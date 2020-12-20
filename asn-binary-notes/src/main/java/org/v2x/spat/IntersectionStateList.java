package org.v2x.spat;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "IntersectionStateList")
public class IntersectionStateList {

    @ASN1SequenceOf(name = "IntersectionStateList", isSetOf = false)
    private java.util.Collection<IntersectionState> value = null;

    public IntersectionStateList() {
    }

    public IntersectionStateList(java.util.Collection<IntersectionState> value) {
        setValue(value);
    }

    public java.util.Collection<IntersectionState> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<IntersectionState> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<IntersectionState>());
    }

    public void add(IntersectionState item) {
        value.add(item);
    }


}
            