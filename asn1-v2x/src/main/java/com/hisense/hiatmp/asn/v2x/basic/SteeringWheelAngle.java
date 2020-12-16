package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * @author zhangyong
 * @date 2020/11/4  19:14
 */
@IntRange(minValue = -126, maxValue = 127)
public class SteeringWheelAngle extends Asn1Integer {
    public SteeringWheelAngle() {
        this(0);
    }

    public SteeringWheelAngle(int value) {
        super(value);
    }
}
