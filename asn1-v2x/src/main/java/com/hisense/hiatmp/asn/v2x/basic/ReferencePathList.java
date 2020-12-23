package com.hisense.hiatmp.asn.v2x.basic;

/**
 * @author zhangyong
 * @date 2020/12/23  12:03
 */

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.Arrays;
import java.util.Collection;

/**
 * ReferencePathList ::= SEQUENCE (SIZE(1..8)) OF ReferencePath
 *
 * @author zhangyong
 * @date 2020/12/23  12:03
 */
@SizeRange(minValue = 1, maxValue = 8)
public class ReferencePathList extends Asn1SequenceOf<ReferencePath> {
    public ReferencePathList(ReferencePath... referencePaths) {
        this(Arrays.asList(referencePaths));
    }

    public ReferencePathList(Collection<ReferencePath> coll) {
        super(coll);
    }
}
