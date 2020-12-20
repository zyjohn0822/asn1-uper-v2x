package org.v2x.map;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.v2x.MsgCount;
import org.v2x.map.node.NodeList;
import org.v2x.time.MinuteOfTheYear;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "MapData", isSet = false)
public class MapData {

    @ASN1Element(name = "msgCnt", isOptional = false, hasTag = false, hasDefaultValue = false)
    private MsgCount msgCnt = null;

    @ASN1Element(name = "timeStamp", isOptional = true, hasTag = false, hasDefaultValue = false)
    private MinuteOfTheYear timeStamp = null;

    @ASN1Element(name = "nodes", isOptional = false, hasTag = false, hasDefaultValue = false)
    private NodeList nodes = null;


    public MsgCount getMsgCnt() {
        return this.msgCnt;
    }


    public void setMsgCnt(MsgCount value) {
        this.msgCnt = value;
    }


    public MinuteOfTheYear getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(MinuteOfTheYear value) {
        this.timeStamp = value;
    }

    public boolean isTimeStampPresent() {
        return this.timeStamp != null;
    }

    public NodeList getNodes() {
        return this.nodes;
    }


    public void setNodes(NodeList value) {
        this.nodes = value;
    }


}
            