package com.hisense.hiatmp.asn.v2x.basic;

/**
 * LightbarInUse<br/>
 * LightbarInUse ::= ENUMERATED {<br/>
 * unavailable (0), -- Not Equipped or unavailable<br/>
 * notInUse (1), -- none active<br/>
 * inUse (2),<br/>
 * yellowCautionLights (3),<br/>
 * schooldBusLights (4),<br/>
 * arrowSignsActive (5),<br/>
 * slowMovingVehicle (6),<br/>
 * freqStops (7)<br/>
 * }<br/>
 *
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
