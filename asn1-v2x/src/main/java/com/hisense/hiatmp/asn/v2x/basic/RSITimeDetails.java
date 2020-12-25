package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.DDateTime.MinuteOfTheYear;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * RSITimeDetails ::= SEQUENCE {<br/>
 * startTime MinuteOfTheYear OPTIONAL,<br/>
 * endTime MinuteOfTheYear OPTIONAL,<br/>
 * -- Exact or estimated end time<br/>
 * endTimeConfidence TimeConfidence OPTIONAL<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/23  10:43
 */
@Getter
@Setter
@Sequence
public class RSITimeDetails {
    @Component(0)
    @Asn1Optional
    public MinuteOfTheYear startTime;
    @Component(1)
    @Asn1Optional
    public MinuteOfTheYear endTime;
    @Component(2)
    @Asn1Optional
    public TimeConfidence endTimeConfidence;

    public RSITimeDetails() {
    }

    public RSITimeDetails(MinuteOfTheYear startTime, MinuteOfTheYear endTime, TimeConfidence endTimeConfidence) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.endTimeConfidence = endTimeConfidence;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"startTime\":")
                .append(startTime);
        sb.append(",\"endTime\":")
                .append(endTime);
        sb.append(",\"endTimeConfidence\":")
                .append(endTimeConfidence);
        sb.append('}');
        return sb.toString();
    }
}
