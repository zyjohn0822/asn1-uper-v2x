
package org.v2x.map.node;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.map.link.LinkList;
import org.v2x.position.Position3D;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "Node", isSet = false)
public class Node implements IASN1PreparedElement {

    @ASN1Element(name = "name", isOptional = true, hasTag = false, hasDefaultValue = false)
    private DescriptiveName name = null;

    @ASN1Element(name = "id", isOptional = false, hasTag = false, hasDefaultValue = false)
    private NodeReferenceID id = null;

    @ASN1Element(name = "refPos", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position3D refPos = null;

    @ASN1Element(name = "inLinks", isOptional = true, hasTag = false, hasDefaultValue = false)
    private LinkList inLinks = null;


    public DescriptiveName getName() {
        return this.name;
    }


    public boolean isNamePresent() {
        return this.name != null;
    }


    public void setName(DescriptiveName value) {
        this.name = value;
    }


    public NodeReferenceID getId() {
        return this.id;
    }


    public void setId(NodeReferenceID value) {
        this.id = value;
    }


    public Position3D getRefPos() {
        return this.refPos;
    }


    public void setRefPos(Position3D value) {
        this.refPos = value;
    }


    public LinkList getInLinks() {
        return this.inLinks;
    }


    public boolean isInLinksPresent() {
        return this.inLinks != null;
    }


    public void setInLinks(LinkList value) {
        this.inLinks = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Node.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            