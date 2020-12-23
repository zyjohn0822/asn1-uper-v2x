package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * Heading ::= INTEGER (0..28800)<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:14
 */
@IntRange(minValue = 0, maxValue = 28800)
public class Heading extends Asn1Integer {
    public Heading() {
        this(0);
    }

    public Heading(int value) {
        super(value);
    }
}
