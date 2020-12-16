package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.HasExtensionMarker;

/**
 * @author zhangyong
 * @date 2020/12/9  22:32
 */
@HasExtensionMarker
public enum ResponseType {
    /**
     *
     */
    notInUseOrNotEquipped (0),
    /**
     * -- active service call at emergency level
     */
    emergency (1),
    /**
     * -- also used when returning from service call
     */
    nonEmergency (2),
    /**
     * -- sender driving may be erratic
     */
    pursuit (3),
    /**
     * -- sender is not moving, stopped along roadside
     */
    stationary (4),
    /**
     * -- such a litter trucks, etc.
     */
    slowMoving (5),
    /**
     * -- such as school bus or garbage truck
     */
    stopAndGoMovement (6),
    zoro (7);
    private final int value;
    ResponseType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(value);
        return builder.toString();
    }
}
