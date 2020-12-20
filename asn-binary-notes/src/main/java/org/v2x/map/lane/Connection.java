package org.v2x.map.lane;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.map.node.NodeReferenceID;
import org.v2x.spat.PhaseID;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "Connection", isSet = false)
public class Connection {

    @ASN1Element(name = "remoteIntersection", isOptional = false, hasTag = false, hasDefaultValue = false)
    private NodeReferenceID remoteIntersection = null;

    @ASN1Element(name = "connectingLane", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ConnectingLane connectingLane = null;

    @ASN1Element(name = "phaseId", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PhaseID phaseId = null;


    public NodeReferenceID getRemoteIntersection() {
        return this.remoteIntersection;
    }


    public void setRemoteIntersection(NodeReferenceID value) {
        this.remoteIntersection = value;
    }


    public ConnectingLane getConnectingLane() {
        return this.connectingLane;
    }

    public void setConnectingLane(ConnectingLane value) {
        this.connectingLane = value;
    }

    public boolean isConnectingLanePresent() {
        return this.connectingLane != null;
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
            