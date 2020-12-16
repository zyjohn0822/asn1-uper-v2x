
package org.v2x.rsm;


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
@ASN1BoxedType(name = "ParticipantList")
public class ParticipantList implements IASN1PreparedElement {

    @ASN1SequenceOf(name = "ParticipantList", isSetOf = false)
    private java.util.Collection<ParticipantData> value = null;

    public ParticipantList() {
    }

    public ParticipantList(java.util.Collection<ParticipantData> value) {
        setValue(value);
    }

    public void setValue(java.util.Collection<ParticipantData> value) {
        this.value = value;
    }

    public java.util.Collection<ParticipantData> getValue() {
        return this.value;
    }

    public void initValue() {
        setValue(new java.util.LinkedList<ParticipantData>());
    }

    public void add(ParticipantData item) {
        value.add(item);
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ParticipantList.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            