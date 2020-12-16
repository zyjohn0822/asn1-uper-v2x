/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "VehSafetyExt"
 */
package com.hisense.hiatmp.asn.v2x.BSM;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.EncodingRules;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FullPositionVector {

    public final static AsnType TYPE = BSM.type(655405);
    public final static CompositeConverter CONV;

    static {
        CONV = new AnnotationCompositeConverter(FullPositionVector.class);
        AsnConverter utcTimeConverter = DDateTime.CONV;
        AsnConverter posConverter = Position3D.CONV;
        AsnConverter headingConverter = Heading.CONV;
        AsnConverter transmissionConverter = TransmissionState.CONV;
        AsnConverter speedConverter = Speed.CONV;
        AsnConverter posAccuracyConverter = PositionalAccuracy.CONV;
        AsnConverter posConficenceConverter = PositionConfidenceSet.CONV;
        AsnConverter timeConfidenceConverter = TimeConfidence.CONV;
        AsnConverter motionCfdConverter = MotionConfidenceSet.CONV;
        CONV.setComponentConverters(new AsnConverter[]{utcTimeConverter, posConverter, headingConverter, transmissionConverter, speedConverter, posAccuracyConverter, posConficenceConverter, timeConfidenceConverter, motionCfdConverter});
    }

    @Null
    @Component(0)
    public DDateTime utcTime;    /* OPTIONAL */
    @NotNull
    @Component(1)
    public Position3D pos;
    @Null
    @Component(2)
    public Integer heading;    /* OPTIONAL */
    @Null
    @Component(3)
    public TransmissionState transmission;    /* OPTIONAL */
    @Null
    @Component(4)
    public Integer speed;    /* OPTIONAL */
    @Null
    @Component(5)
    public PositionalAccuracy posAccuracy;    /* OPTIONAL */
    @Null
    @Component(6)
    public PositionConfidenceSet posConficence;    /* OPTIONAL */
    @Null
    @Component(7)
    public TimeConfidence timeConfidence;    /* OPTIONAL */
    @Null
    @Component(8)
    public MotionConfidenceSet motionCfd;    /* OPTIONAL */

    public static FullPositionVector ber_decode(InputStream in) throws IOException {
        return (FullPositionVector) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static FullPositionVector per_decode(boolean align, InputStream in) throws IOException {
        return (FullPositionVector) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FullPositionVector)) {
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
