package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.Arrays;
import java.util.Collection;

/**
 * ReferenceLinkList ::= SEQUENCE (SIZE(1..16)) OF ReferenceLink
 *
 * @author zhangyong
 * @date 2020/12/23  12:04
 */
@SizeRange(minValue = 1, maxValue = 16)
public class ReferenceLinkList extends Asn1SequenceOf<ReferenceLink> {
    public ReferenceLinkList(ReferenceLink... referenceLinks) {
        this(Arrays.asList(referenceLinks));
    }

    public ReferenceLinkList(Collection<ReferenceLink> coll) {
        super(coll);
    }
}
