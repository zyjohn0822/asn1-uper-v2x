/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "DefMotion"
 */
package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.EncodingRules;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum SteeringWheelAngleConfidence {
    unavailable(0),
    prec2deg(1),
    prec1deg(2),
    prec0_02deg(3);

    public final static AsnType TYPE = MsgFrame.type(393239);
    public final static AsnConverter CONV;

    static {
        CONV = new ReflectionEnumeratedConverter(SteeringWheelAngleConfidence.class);
    }

    private int value;

    private SteeringWheelAngleConfidence(int value) {
        this.value = value;
    }

    public static SteeringWheelAngleConfidence valueOf(int value) {
        SteeringWheelAngleConfidence[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].value == value) {
                return values[i];
            }
        }
        throw new IllegalArgumentException("No enum const value for " + value);
    }

    public static SteeringWheelAngleConfidence ber_decode(InputStream in) throws IOException {
        return (SteeringWheelAngleConfidence) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static SteeringWheelAngleConfidence per_decode(boolean align, InputStream in) throws IOException {
        return (SteeringWheelAngleConfidence) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    public int value() {
        return value;
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
        sb.append("\"value\":")
                .append(value);
        sb.append('}');
        return sb.toString();
    }

}
