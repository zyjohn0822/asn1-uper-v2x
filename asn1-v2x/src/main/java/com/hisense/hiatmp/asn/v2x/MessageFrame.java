package com.hisense.hiatmp.asn.v2x;

import lombok.Getter;
import net.gcdc.asn1.datatypes.Choice;
import net.gcdc.asn1.datatypes.HasExtensionMarker;

/**
 * MsgFrame DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p><br/>
 * -- imports and exports<br/>
 * <p><br/>
 * EXPORTS MsgCount;<br/>
 * IMPORTS BasicSafetyMessage FROM BSM<br/>
 * MapData FROM Map<br/>
 * RoadsideSafetyMessage FROM RSM<br/>
 * SPAT FROM SignalPhaseAndTiming<br/>
 * RoadSideInformation FROM RSI;<br/>
 * </p>
 * -- Main message frame<br/>
 * MessageFrame ::= CHOICE {<br/>
 * bsmFrame BasicSafetyMessage,<br/>
 * mapFrame MapData,<br/>
 * rsmFrame RoadsideSafetyMessage,<br/>
 * spatFrame SPAT,<br/>
 * rsiFrame RoadSideInformation,<br/>
 * ...<br/>
 * }<br/>
 * <p>
 * MsgCount ::= INTEGER (0..127)<br/>
 * <p>
 * END<br/>
 *
 * @author zhangyong
 * @date 2020/11/10  15:53
 */
@Choice
@Getter
@HasExtensionMarker
public class MessageFrame {


    public BasicSafetyMessage bsmFrame;
    public MapData mapData;
    public RoadSideSafetyMessage rsmFrame;
    public SPAT spatFrame;
    public RoadSideInformation rsiFrame;

    public MessageFrame() {
    }

    public MessageFrame(BasicSafetyMessage bsmFrame,
                        MapData mapData,
                        RoadSideSafetyMessage rsmFrame,
                        SPAT spatFrame,
                        RoadSideInformation rsiFrame) {
        this.bsmFrame = bsmFrame;
        this.mapData = mapData;
        this.rsmFrame = rsmFrame;
        this.spatFrame = spatFrame;
        this.rsiFrame = rsiFrame;
    }

    public static MessageFrame bsmFrame(BasicSafetyMessage bsm) {
        return new MessageFrame(bsm, null, null, null, null);
    }

    public static MessageFrame mapFrame(MapData mapData) {
        return new MessageFrame(null, mapData, null, null, null);
    }

    public static MessageFrame rsmFrame(RoadSideSafetyMessage rsm) {
        return new MessageFrame(null, null, rsm, null, null);
    }

    public static MessageFrame spatFrame(SPAT spat) {
        return new MessageFrame(null, null, null, spat, null);
    }

    public static MessageFrame rsiFrame(RoadSideInformation rsi) {
        return new MessageFrame(null, null, null, null, rsi);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"bsmFrame\":")
                .append(bsmFrame);
        sb.append(",\"mapData\":")
                .append(mapData);
        sb.append(",\"rsmFrame\":")
                .append(rsmFrame);
        sb.append(",\"spatFrame\":")
                .append(spatFrame);
        sb.append(",\"rsiFrame\":")
                .append(rsiFrame);
        sb.append('}');
        return sb.toString();
    }

}
