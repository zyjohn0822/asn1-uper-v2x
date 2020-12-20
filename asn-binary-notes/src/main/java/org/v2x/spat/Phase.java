package org.v2x.spat;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "Phase", isSet = false)
public class Phase {

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


}
            