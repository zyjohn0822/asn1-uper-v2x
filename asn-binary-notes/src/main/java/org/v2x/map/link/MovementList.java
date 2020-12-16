
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
@ASN1BoxedType(name = "MovementList")
public class MovementList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "MovementList", isSetOf = false)
    private java.util.Collection<Movement> value = null;

    public MovementList() {
    }

    public MovementList(java.util.Collection<Movement> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<Movement> value) {
        this.value = value;
    }

    public java.util.Collection<Movement> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Movement>());
    }

    public void add(Movement item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(MovementList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            