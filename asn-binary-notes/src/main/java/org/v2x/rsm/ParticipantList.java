package org.v2x.rsm;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "ParticipantList")
public class ParticipantList {

    @ASN1SequenceOf(name = "ParticipantList", isSetOf = false)
    private java.util.Collection<ParticipantData> value = null;

    public ParticipantList() {
    }

    public ParticipantList(java.util.Collection<ParticipantData> value) {
        setValue(value);
    }

    public java.util.Collection<ParticipantData> getValue() {
        return this.value;
    }

    public void setValue(java.util.Collection<ParticipantData> value) {
        this.value = value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<ParticipantData>());
    }

    public void add(ParticipantData item) {
        value.add(item);
    }
}
            