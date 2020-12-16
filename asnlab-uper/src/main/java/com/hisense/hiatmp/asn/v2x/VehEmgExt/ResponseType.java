/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "VehEmgExt"
 */
package com.hisense.hiatmp.asn.v2x.VehEmgExt;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.EncodingRules;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum ResponseType {
    notInUseOrNotEquipped(0),
    emergency(1),
    nonEmergency(2),
    pursuit(3),
    stationary(4),
    slowMoving(5),
    stopAndGoMovement(6);

    public final static AsnType TYPE = VehEmgExt.type(65537);
    public final static AsnConverter CONV;

    static {
        CONV = new ReflectionEnumeratedConverter(ResponseType.class);
    }

    private int value;

    private ResponseType(int value) {
        this.value = value;
    }

    public static ResponseType valueOf(int value) {
        ResponseType[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].value == value) {
                return values[i];
            }
        }
        throw new IllegalArgumentException("No enum const value for " + value);
    }

    public static ResponseType ber_decode(InputStream in) throws IOException {
        return (ResponseType) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static ResponseType per_decode(boolean align, InputStream in) throws IOException {
        return (ResponseType) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
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


}
