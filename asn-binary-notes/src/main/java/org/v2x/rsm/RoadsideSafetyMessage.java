
package org.v2x.rsm;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1OctetString;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.MsgCount;
import org.v2x.position.Position3D;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "RoadsideSafetyMessage", isSet = false)
public class RoadsideSafetyMessage implements IASN1PreparedElement {

    @ASN1Element(name = "msgCnt", isOptional = false, hasTag = false, hasDefaultValue = false)
    private MsgCount msgCnt = null;

    @ASN1OctetString(name = "")
    @ASN1SizeConstraint(max = 8L)
    @ASN1Element(name = "id", isOptional = false, hasTag = false, hasDefaultValue = false)
    private byte[] id = null;

    @ASN1Element(name = "refPos", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position3D refPos = null;

    @ASN1Element(name = "participants", isOptional = false, hasTag = false, hasDefaultValue = false)
    private ParticipantList participants = null;


    public MsgCount getMsgCnt() {
        return this.msgCnt;
    }


    public void setMsgCnt(MsgCount value) {
        this.msgCnt = value;
    }


    public byte[] getId() {
        return this.id;
    }


    public void setId(byte[] value) {
        this.id = value;
    }


    public Position3D getRefPos() {
        return this.refPos;
    }


    public void setRefPos(Position3D value) {
        this.refPos = value;
    }


    public ParticipantList getParticipants() {
        return this.participants;
    }


    public void setParticipants(ParticipantList value) {
        this.participants = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(RoadsideSafetyMessage.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            