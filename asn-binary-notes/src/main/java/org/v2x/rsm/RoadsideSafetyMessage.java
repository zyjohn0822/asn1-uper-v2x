package org.v2x.rsm;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1OctetString;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.v2x.MsgCount;
import org.v2x.position.Position3D;


/**
 * @author zhangyong
 */

@ASN1Sequence(name = "RoadsideSafetyMessage", isSet = false)
public class RoadsideSafetyMessage {

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


}
            