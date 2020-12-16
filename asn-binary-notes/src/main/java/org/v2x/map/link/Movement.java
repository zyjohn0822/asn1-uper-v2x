
package org.v2x.map.link;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.map.node.NodeReferenceID;
import org.v2x.spat.PhaseID;

/**
 *
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "Movement", isSet = false)
public class Movement implements IASN1PreparedElement {

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


    public boolean isPhaseIdPresent() {
        return this.phaseId != null;
    }


    public void setPhaseId(PhaseID value) {
        this.phaseId = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Movement.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            