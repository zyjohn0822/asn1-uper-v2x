package com.hisense.hiatmp.asn.v2x.common;

import com.hisense.hiatmp.asn.v2x.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * asn解析容器
 *
 * @author zhangyong
 * @date 2020/12/23  18:37
 */
@Getter
@Setter
public class MessageContainer {
    private String rsuId;
    private long timestamp;
    private List<BasicSafetyMessage> bsmList;
    private SPAT spat;
    private RoadSideSafetyMessage rsm;
    private RoadSideInformation rsi;
    private MapData map;

    private MessageContainer() {
    }

    private MessageContainer(
            String rsuId,
            long timestamp,
            List<BasicSafetyMessage> bsmList,
            SPAT spat,
            RoadSideSafetyMessage rsm,
            RoadSideInformation rsi,
            MapData map) {
        this.rsuId = rsuId;
        this.timestamp = timestamp;
        this.bsmList = bsmList;
        this.spat = spat;
        this.rsm = rsm;
        this.rsi = rsi;
        this.map = map;
    }

    public static MessageContainer bsmContainer(String rsuId, long timestamp, List<BasicSafetyMessage> bsmList) {
        return new MessageContainer(rsuId, timestamp, bsmList, null, null, null, null);
    }

    public static MessageContainer spatContainer(String rsuId, long timestamp, SPAT spat) {
        return new MessageContainer(rsuId, timestamp, null, spat, null, null, null);
    }

    public static MessageContainer rsmContainer(String rsuId, long timestamp, RoadSideSafetyMessage rsm) {
        return new MessageContainer(rsuId, timestamp, null, null, rsm, null, null);
    }

    public static MessageContainer rsiContainer(String rsuId, long timestamp, RoadSideInformation rsi) {
        return new MessageContainer(rsuId, timestamp, null, null, null, rsi, null);
    }

    public static MessageContainer mapContainer(String rsuId, long timestamp, MapData map) {
        return new MessageContainer(rsuId, timestamp, null, null, null, null, map);
    }
}
