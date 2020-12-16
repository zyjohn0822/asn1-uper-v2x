package com.hisense.hiatmp.asn.v2x;

import lombok.Getter;
import net.gcdc.asn1.datatypes.Choice;

/**
 * @author zhangyong
 * @date 2020/11/10  15:53
 */
@Choice
@Getter
public class MessageFrame {
    public static final int bsmFrameChosen = 0;
    public static final int mapFrameChosen = 1;
    public static final int rsmFrameChosen = 2;
    public static final int spatFrameChosen = 3;
    public static final int rsiFrameChosen = 4;

    public final int choiceID;
    public final BasicSafetyMessage bsmFrame;
    public final MapData mapData;
    public final RoadsideSafetyMessage rsmFrame;
    public final SPAT spatFrame;
    public final RoadSideInformation rsiFrame;


    private MessageFrame(int choiceID, BasicSafetyMessage bsmFrame,
                         MapData mapData,
                         RoadsideSafetyMessage rsmFrame,
                         SPAT spatFrame,
                         RoadSideInformation rsiFrame) {
        this.choiceID = choiceID;
        this.bsmFrame = bsmFrame;
        this.mapData = mapData;
        this.rsmFrame = rsmFrame;
        this.spatFrame = spatFrame;
        this.rsiFrame = rsiFrame;
    }

    public static MessageFrame bsmFrame(BasicSafetyMessage bsm) {
        return new MessageFrame(bsmFrameChosen, bsm, null, null, null, null);
    }

    public static MessageFrame mapFrame(MapData mapData) {
        return new MessageFrame(mapFrameChosen, null, mapData, null, null, null);
    }

    public static MessageFrame rsmFrame(RoadsideSafetyMessage rsm) {
        return new MessageFrame(rsmFrameChosen, null, null, rsm, null, null);
    }

    public static MessageFrame spatFrame(SPAT spat) {
        return new MessageFrame(spatFrameChosen, null, null, null, spat, null);
    }

    public static MessageFrame rsiFrame(RoadSideInformation rsi) {
        return new MessageFrame(rsiFrameChosen, null, null, null, null, rsi);
    }

}
