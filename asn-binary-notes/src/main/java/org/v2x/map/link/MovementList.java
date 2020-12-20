package org.v2x.map.link;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "MovementList")
public class MovementList {

    @ASN1SequenceOf(name = "MovementList", isSetOf = false)
    private java.util.Collection<Movement> value = null;

    public MovementList() {
    }

    public MovementList(java.util.Collection<Movement> value) {
        setValue(value);
    }

    public java.util.Collection<Movement> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<Movement> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<Movement>());
    }

    public void add(Movement item) {
        value.add(item);
    }

}
            