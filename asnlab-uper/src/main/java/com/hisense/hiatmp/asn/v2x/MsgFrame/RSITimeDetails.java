/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "RSI"
 */
package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.EncodingRules;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zhangyong
 */
public class RSITimeDetails {

    public final static AsnType TYPE = MsgFrame.type(1507479);
    public final static CompositeConverter CONV;

    static {
        CONV = new AnnotationCompositeConverter(RSITimeDetails.class);
        AsnConverter startTimeConverter = MinuteOfTheYear.CONV;
        AsnConverter endTimeConverter = MinuteOfTheYear.CONV;
        AsnConverter endTimeConfidenceConverter = TimeConfidence.CONV;
        CONV.setComponentConverters(new AsnConverter[]{startTimeConverter, endTimeConverter, endTimeConfidenceConverter});
    }

    /**
     * OPTIONAL
     */
    @Null
    @Component(0)
    public Integer startTime;
    /**
     * OPTIONAL
     */
    @Null
    @Component(1)
    public Integer endTime;
    /**
     * OPTIONAL
     */
    @Null
    @Component(2)
    public TimeConfidence endTimeConfidence;

    public static RSITimeDetails ber_decode(InputStream in) throws IOException {
        return (RSITimeDetails) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static RSITimeDetails per_decode(boolean align, InputStream in) throws IOException {
        return (RSITimeDetails) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RSITimeDetails)) {
            return false;
        }
        return TYPE.equals(this, obj, CONV);
    }

    public void ber_encode(OutputStream out) throws IOException {
        TYPE.encode(this, EncodingRules.BASIC_ENCODING_RULES, CONV, out);
    }

    public void per_encode(boolean align, OutputStream out) throws IOException {
        TYPE.encode(this, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV, out);
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