
package org.v2x.map.link;


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
@ASN1BoxedType(name = "LinkList")
public class LinkList implements IASN1PreparedElement {


    @ASN1SequenceOf(name = "LinkList", isSetOf = false)
    private java.util.Collection<Link> value = null;

    public LinkList() {
    }

    public LinkList(java.util.Collection<Link> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<Link> value) {
        this.value = value;
    }

    public java.util.Collection<Link> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Link>());
    }

    public void add(Link item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(LinkList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            