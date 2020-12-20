package org.v2x.rsi;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "ReferenceLinkList")
public class ReferenceLinkList {


    @ASN1SequenceOf(name = "ReferenceLinkList", isSetOf = false)
    private java.util.Collection<ReferenceLink> value = null;

    public ReferenceLinkList() {
    }

    public ReferenceLinkList(java.util.Collection<ReferenceLink> value) {
        setValue(value);
    }

    public java.util.Collection<ReferenceLink> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<ReferenceLink> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<ReferenceLink>());
    }

    public void add(ReferenceLink item) {
        value.add(item);
    }

}
            