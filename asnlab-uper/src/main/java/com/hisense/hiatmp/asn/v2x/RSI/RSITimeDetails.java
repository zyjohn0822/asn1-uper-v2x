/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "RSI"
 */
package com.hisense.hiatmp.asn.v2x.RSI;

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

public class RSITimeDetails {

    public final static AsnType TYPE = RSI.type(65543);
    public final static CompositeConverter CONV;

    static {
        CONV = new AnnotationCompositeConverter(RSITimeDetails.class);
        AsnConverter startTimeConverter = MinuteOfTheYear.CONV;
        AsnConverter endTimeConverter = MinuteOfTheYear.CONV;
        AsnConverter endTimeConfidenceConverter = TimeConfidence.CONV;
        CONV.setComponentConverters(new AsnConverter[]{startTimeConverter, endTimeConverter, endTimeConfidenceConverter});
    }

    @Null
    @Component(0)
    public Integer startTime;    /* OPTIONAL */
    @Null
    @Component(1)
    public Integer endTime;    /* OPTIONAL */
    @Null
    @Component(2)
    public TimeConfidence endTimeConfidence;    /* OPTIONAL */

    public static RSITimeDetails ber_decode(InputStream in) throws IOException {
        return (RSITimeDetails) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static RSITimeDetails per_decode(boolean align, InputStream in) throws IOException {
        return (RSITimeDetails) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

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


}