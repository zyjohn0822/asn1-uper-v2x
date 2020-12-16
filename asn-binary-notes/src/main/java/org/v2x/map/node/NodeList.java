
package org.v2x.map.node;


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
@ASN1BoxedType(name = "NodeList")
public class NodeList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "NodeList", isSetOf = false)
    private java.util.Collection<Node> value = null;

    public NodeList() {
    }

    public NodeList(java.util.Collection<Node> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<Node> value) {
        this.value = value;
    }

    public java.util.Collection<Node> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Node>());
    }

    public void add(Node item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(NodeList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            