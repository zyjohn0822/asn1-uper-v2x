package com.hisense.hiatmp.asn.v2x.basic;

/**
 * @author zhangyong
 * @date 2020/12/9  22:33
 */
public enum LightbarInUse {
    /**
     * -- Not Equipped or unavailable
     */
    unavailable(0),
    /**
     * -- none active
     */
    notInUse(1),
    /**
     *
     */
    inUse(2),
    /**
     *
     */
    yellowCautionLights(3),
    /**
     *
     */
    schooldBusLights(4),
    /**
     *
     */
    arrowSignsActive(5),
    /**
     *
     */
    slowMovingVehicle(6),
    /**
     *
     */
    freqStops(7);
    private final int value;

    LightbarInUse(int value) {
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
