package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1String;
import net.gcdc.asn1.datatypes.CharacterRestriction;
import net.gcdc.asn1.datatypes.RestrictedString;
import net.gcdc.asn1.datatypes.SizeRange;

/**
 * DescriptiveName ::= IA5String (SIZE(1..63))
 *
 * @author zhangyong
 * @date 2020/12/21  9:38
 */
@RestrictedString(CharacterRestriction.IA5String)
@SizeRange(minValue = 1, maxValue = 63)
public class DescriptiveName extends Asn1String {
    public DescriptiveName() {
        this("");
    }

    public DescriptiveName(String value) {
        super(value);
    }
}
