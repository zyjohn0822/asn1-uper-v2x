
package org.v2x.map.node;


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
@ASN1Sequence(name = "NodeReferenceID", isSet = false)
public class NodeReferenceID implements IASN1PreparedElement {

    @ASN1Element(name = "region", isOptional = true, hasTag = false, hasDefaultValue = false)
    private RoadRegulatorID region = null;

    @ASN1Element(name = "id", isOptional = false, hasTag = false, hasDefaultValue = false)
    private NodeID id = null;


    public RoadRegulatorID getRegion() {
        return this.region;
    }


    public boolean isRegionPresent() {
        return this.region != null;
    }


    public void setRegion(RoadRegulatorID value) {
        this.region = value;
    }


    public NodeID getId() {
        return this.id;
    }


    public void setId(NodeID value) {
        this.id = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(NodeReferenceID.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            