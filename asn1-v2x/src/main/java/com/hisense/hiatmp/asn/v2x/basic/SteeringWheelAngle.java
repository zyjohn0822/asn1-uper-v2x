package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * SteeringWheelAngle ::= INTEGER (-126..127)<br/>
 * -- Units of 1.5 degrees, a range of -189 to +189 degrees<br/>
 * -- +001 = +1.5 deg<br/>
 * -- -126 = -189 deg and beyond<br/>
 * -- +126 = +189 deg and beyond<br/>
 * -- +127 to be used for unavailable<br/>
 *
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
