package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/5  14:55
 */
@Sequence
@Getter
@Setter
public class PositionOffsetLLV {
    @Component(0)
    PositionOffsetLL offsetLL;
    @Component(1)
    @Asn1Optional
    VerticalOffset offsetV;

    public PositionOffsetLLV() {
    }

    public PositionOffsetLLV(PositionOffsetLL offsetLL, VerticalOffset offsetV) {
        this.offsetLL = offsetLL;
        this.offsetV = offsetV;
    }
}
