package org.v2x.map.node;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "NodeList")
public class NodeList {

    @ASN1SequenceOf(name = "NodeList", isSetOf = false)
    private java.util.Collection<Node> value = null;

    public NodeList() {
    }

    public NodeList(java.util.Collection<Node> value) {
        setValue(value);
    }

    public java.util.Collection<Node> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<Node> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Node>());
    }

    public void add(Node item) {
        value.add(item);
    }


}
            