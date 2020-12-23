package com.hisense.hiatmp.asn.v2x;

import lombok.Getter;
import net.gcdc.asn1.datatypes.Choice;
import net.gcdc.asn1.datatypes.HasExtensionMarker;

/**
 * @author zhangyong
 * @date 2020/11/10  15:53
 */
@Choice
@Getter
@HasExtensionMarker
public class MessageFrame {


    public BasicSafetyMessage bsmFrame;
    public MapData mapData;
    public RoadsideSafetyMessage rsmFrame;
    public SPAT spatFrame;
    public RoadSideInformation rsiFrame;

    public MessageFrame() {
    }

    public MessageFrame(BasicSafetyMessage bsmFrame,
                        MapData mapData,
                        RoadsideSafetyMessage rsmFrame,
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

    public static MessageFrame rsmFrame(RoadsideSafetyMessage rsm) {
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
