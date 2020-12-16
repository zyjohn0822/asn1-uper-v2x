package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * @author zhangyong
 * @date 2020/11/4  19:14
 */
@IntRange(minValue = 0, maxValue = 8191)
public class Speed extends Asn1Integer {
    public Speed() {
        this(0);
    }

    public Speed(int value) {
        super(value);
    }
}
