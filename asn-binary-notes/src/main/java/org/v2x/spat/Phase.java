
package org.v2x.spat;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "Phase", isSet = false)
public class Phase implements IASN1PreparedElement {

    @ASN1Element(name = "id", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PhaseID id = null;

    @ASN1Element(name = "phaseStates", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PhaseStateList phaseStates = null;


    public PhaseID getId() {
        return this.id;
    }


    public void setId(PhaseID value) {
        this.id = value;
    }


    public PhaseStateList getPhaseStates() {
        return this.phaseStates;
    }


    public void setPhaseStates(PhaseStateList value) {
        this.phaseStates = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Phase.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            