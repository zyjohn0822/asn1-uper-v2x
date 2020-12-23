package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * Radius ::= INTEGER (0..65535)<br/>
 *
 * @author zhangyong
 * @date 2020/12/23  10:43
 */
@IntRange(minValue = 0, maxValue = 65535)
public class Radius extends Asn1Integer {
    public Radius() {
        this(0);
    }

    public Radius(int value) {
        super(value);
    }
}
