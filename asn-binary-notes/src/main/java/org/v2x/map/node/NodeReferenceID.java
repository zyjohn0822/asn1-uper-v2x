package org.v2x.map.node;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "NodeReferenceID", isSet = false)
public class NodeReferenceID {

    @ASN1Element(name = "region", isOptional = true, hasTag = false, hasDefaultValue = false)
    private RoadRegulatorID region = null;

    @ASN1Element(name = "id", isOptional = false, hasTag = false, hasDefaultValue = false)
    private NodeID id = null;


    public RoadRegulatorID getRegion() {
        return this.region;
    }

    public void setRegion(RoadRegulatorID value) {
        this.region = value;
    }

    public boolean isRegionPresent() {
        return this.region != null;
    }

    public NodeID getId() {
        return this.id;
    }


    public void setId(NodeID value) {
        this.id = value;
    }

}
            