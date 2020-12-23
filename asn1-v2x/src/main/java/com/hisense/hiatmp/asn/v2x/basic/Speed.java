package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * Speed ::= INTEGER (0..8191)<br/>
 * -- Units of 0.02 m/s<br/>
 * -- The value 8191 indicates that<br/>
 * -- speed is unavailable<br/>
 *
 * @author zhangyong<br />
 * @date 2020/11/4  19:14<br/>
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
