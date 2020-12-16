
package org.v2x.map.lane;


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
@ASN1BoxedType(name = "ConnectsToList")
public class ConnectsToList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "ConnectsToList", isSetOf = false)
    private java.util.Collection<Connection> value = null;

    public ConnectsToList() {
    }

    public ConnectsToList(java.util.Collection<Connection> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<Connection> value) {
        this.value = value;
    }

    public java.util.Collection<Connection> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Connection>());
    }

    public void add(Connection item) {
        value.add(item);
    }
    @Override
    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ConnectsToList.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            