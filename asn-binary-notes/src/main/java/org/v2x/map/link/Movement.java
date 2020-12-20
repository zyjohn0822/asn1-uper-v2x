package org.v2x.map.link;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.v2x.map.node.NodeReferenceID;
import org.v2x.spat.PhaseID;

/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "Movement", isSet = false)
public class Movement {

    @ASN1Element(name = "remoteIntersection", isOptional = false, hasTag = false, hasDefaultValue = false)
    private NodeReferenceID remoteIntersection = null;

    @ASN1Element(name = "phaseId", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PhaseID phaseId = null;


    public NodeReferenceID getRemoteIntersection() {
        return this.remoteIntersection;
    }


    public void setRemoteIntersection(NodeReferenceID value) {
        this.remoteIntersection = value;
    }


    public PhaseID getPhaseId() {
        return this.phaseId;
    }

    public void setPhaseId(PhaseID value) {
        this.phaseId = value;
    }

    public boolean isPhaseIdPresent() {
        return this.phaseId != null;
    }


}
            