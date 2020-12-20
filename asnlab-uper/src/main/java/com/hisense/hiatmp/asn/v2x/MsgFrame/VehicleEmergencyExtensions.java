/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "VehEmgExt"
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
public class VehicleEmergencyExtensions {

    public final static AsnType TYPE = MsgFrame.type(852053);
    public final static CompositeConverter CONV;

    static {
        CONV = new AnnotationCompositeConverter(VehicleEmergencyExtensions.class);
        AsnConverter responseTypeConverter = ResponseType.CONV;
        AsnConverter sirenUseConverter = SirenInUse.CONV;
        AsnConverter lightsUseConverter = LightbarInUse.CONV;
        CONV.setComponentConverters(new AsnConverter[]{responseTypeConverter, sirenUseConverter, lightsUseConverter});
    }

    /**
     * OPTIONAL
     */
    @Null
    @Component(0)
    public ResponseType responseType;
    /**
     * OPTIONAL
     */
    @Null
    @Component(1)
    public SirenInUse sirenUse;
    /**
     * OPTIONAL
     */
    @Null
    @Component(2)
    public LightbarInUse lightsUse;

    public static VehicleEmergencyExtensions ber_decode(InputStream in) throws IOException {
        return (VehicleEmergencyExtensions) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static VehicleEmergencyExtensions per_decode(boolean align, InputStream in) throws IOException {
        return (VehicleEmergencyExtensions) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VehicleEmergencyExtensions)) {
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
        sb.append("\"responseType\":")
                .append(responseType);
        sb.append(",\"sirenUse\":")
                .append(sirenUse);
        sb.append(",\"lightsUse\":")
                .append(lightsUse);
        sb.append('}');
        return sb.toString();
    }
}