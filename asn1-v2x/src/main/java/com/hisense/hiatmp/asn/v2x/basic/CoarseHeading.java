package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * CoarseHeading ::= INTEGER (0..240)<br/>
 * -- Units of 1.5 degrees<br/>
 * -- over a range of 0~358.5 degrees<br/>
 * -- the value 240 shall be used for unavailable<br/>
 *
 * @author zhangyong
 * @date 2020/11/10  10:43
 */
@IntRange(minValue = 0, maxValue = 240)
public class CoarseHeading extends Asn1Integer {
    public CoarseHeading() {
        this(0);
    }

    public CoarseHeading(int value) {
        super(value);
    }
}
