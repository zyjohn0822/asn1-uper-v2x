
package org.v2x.map;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.MsgCount;
import org.v2x.map.node.NodeList;
import org.v2x.time.MinuteOfTheYear;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "MapData", isSet = false)
public class MapData implements IASN1PreparedElement {

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


    public boolean isTimeStampPresent() {
        return this.timeStamp != null;
    }


    public void setTimeStamp(MinuteOfTheYear value) {
        this.timeStamp = value;
    }


    public NodeList getNodes() {
        return this.nodes;
    }


    public void setNodes(NodeList value) {
        this.nodes = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(MapData.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            