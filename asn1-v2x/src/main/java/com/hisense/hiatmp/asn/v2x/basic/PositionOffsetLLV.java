package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * PositionOffsetLLV ::= SEQUENCE { <br/>
 * offsetLL PositionOffsetLL,<br/>
 * -- offset in lon/lat<br/>
 * offsetV VerticalOffset OPTIONAL<br/>
 * -- offset in elevation<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/5  14:55
 */
@Sequence
@Getter
@Setter
public class PositionOffsetLLV {
    @Component(0)
    public PositionOffsetLL offsetLL;
    @Component(1)
    @Asn1Optional
    public VerticalOffset offsetV;

    public PositionOffsetLLV() {
    }

    public PositionOffsetLLV(PositionOffsetLL offsetLL, VerticalOffset offsetV) {
        this.offsetLL = offsetLL;
        this.offsetV = offsetV;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"offsetLL\":")
                .append(offsetLL);
        sb.append(",\"offsetV\":")
                .append(offsetV);
        sb.append('}');
        return sb.toString();
    }
}
