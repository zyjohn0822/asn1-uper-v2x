package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.Arrays;
import java.util.Collection;

/**
 * RSIPriority ::= OCTET STRING (SIZE(1))
 * -- The lower five bits are reserved and shall be set to zero
 * -- Value from B00000000 to B11100000 represents the lowest to the highest level
 * <p>
 * -- value assignments
 *
 * @author zhangyong
 * @date 2020/12/23  10:44
 */
@SizeRange(minValue = 1, maxValue = 1)
public class RSIPriority extends Asn1SequenceOf<Byte> {
    public RSIPriority(Byte... coll) {
        this(Arrays.asList(coll));
    }

    public RSIPriority(Collection<Byte> coll) {
        super(coll);
    }
}
