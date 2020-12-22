package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.Arrays;
import java.util.Collection;

/**
 * id OCTET STRING (SIZE(8))
 * @author zhangyong
 * @date 2020/12/22  17:10
 */
@SizeRange(minValue = 8, maxValue = 8)
public class ID extends Asn1SequenceOf<Byte> {
    // Two constructors -- choose any, or add more.
    public ID(Byte... coll) {
        this(Arrays.asList(coll));
    }

    public ID(Collection<Byte> coll) {
        super(coll);
    }
}
