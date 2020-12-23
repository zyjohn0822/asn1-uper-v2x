package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1Integer;
import net.gcdc.asn1.datatypes.IntRange;

/**
 * MsgCount ::= INTEGER (0..127)<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:15
 */
@IntRange(minValue = 0, maxValue = 127)
public class MsgCount extends Asn1Integer {
    public MsgCount() {
        this(0);
    }

    public MsgCount(int value) {
        super(value);
    }
}
