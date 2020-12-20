package org.v2x.rsi;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1OctetString;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.v2x.MsgCount;
import org.v2x.position.Position3D;
import org.v2x.time.MinuteOfTheYear;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "RoadSideInformation", isSet = false)
public class RoadSideInformation {

    @ASN1Element(name = "msgCnt", isOptional = false, hasTag = false, hasDefaultValue = false)
    private MsgCount msgCnt = null;

    @ASN1Element(name = "moy", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MinuteOfTheYear moy = null;

    @ASN1OctetString(name = "")
    @ASN1SizeConstraint(max = 8L)
    @ASN1Element(name = "id", isOptional = false, hasTag = false, hasDefaultValue = false)
    private byte[] id = null;

    @ASN1Element(name = "refPos", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position3D refPos = null;

    @ASN1Element(name = "rtes", isOptional = true, hasTag = false, hasDefaultValue = false)
    private RTEList rtes = null;

    @ASN1Element(name = "rtss", isOptional = true, hasTag = false, hasDefaultValue = false)
    private RTSList rtss = null;


    public MsgCount getMsgCnt() {
        return this.msgCnt;
    }


    public void setMsgCnt(MsgCount value) {
        this.msgCnt = value;
    }


    public MinuteOfTheYear getMoy() {
        return this.moy;
    }

    public void setMoy(MinuteOfTheYear value) {
        this.moy = value;
    }

    public boolean isMoyPresent() {
        return this.moy != null;
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


    public RTEList getRtes() {
        return this.rtes;
    }

    public void setRtes(RTEList value) {
        this.rtes = value;
    }

    public boolean isRtesPresent() {
        return this.rtes != null;
    }

    public RTSList getRtss() {
        return this.rtss;
    }

    public void setRtss(RTSList value) {
        this.rtss = value;
    }

    public boolean isRtssPresent() {
        return this.rtss != null;
    }

}
            