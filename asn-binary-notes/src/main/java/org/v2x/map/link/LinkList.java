package org.v2x.map.link;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "LinkList")
public class LinkList {


    @ASN1SequenceOf(name = "LinkList", isSetOf = false)
    private java.util.Collection<Link> value = null;

    public LinkList() {
    }

    public LinkList(java.util.Collection<Link> value) {
        setValue(value);
    }

    public java.util.Collection<Link> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<Link> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Link>());
    }

    public void add(Link item) {
        value.add(item);
    }

}
            