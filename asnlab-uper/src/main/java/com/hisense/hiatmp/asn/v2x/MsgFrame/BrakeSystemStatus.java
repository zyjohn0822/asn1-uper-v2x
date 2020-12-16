/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "VehBrake"
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
public class BrakeSystemStatus {

    public final static AsnType TYPE = MsgFrame.type(524316);
    public final static CompositeConverter CONV;

    static {
        CONV = new AnnotationCompositeConverter(BrakeSystemStatus.class);
        AsnConverter brakePadelConverter = BrakePedalStatus.CONV;
        AsnConverter wheelBrakesConverter = BrakeAppliedStatus.CONV;
        AsnConverter tractionConverter = TractionControlStatus.CONV;
        AsnConverter absConverter = AntiLockBrakeStatus.CONV;
        AsnConverter scsConverter = StabilityControlStatus.CONV;
        AsnConverter brakeBoostConverter = BrakeBoostApplied.CONV;
        AsnConverter auxBrakesConverter = AuxiliaryBrakeStatus.CONV;
        CONV.setComponentConverters(new AsnConverter[]{brakePadelConverter, wheelBrakesConverter, tractionConverter, absConverter, scsConverter, brakeBoostConverter, auxBrakesConverter});
    }

    /**
     * OPTIONAL
     */
    @Null
    @Component(0)
    public BrakePedalStatus brakePadel;
    /**
     * OPTIONAL
     */
    @Null
    @Component(1)
    public BrakeAppliedStatus wheelBrakes;
    /**
     * OPTIONAL
     */
    @Null
    @Component(2)
    public TractionControlStatus traction;
    /**
     * OPTIONAL
     */
    @Null
    @Component(3)
    public AntiLockBrakeStatus abs;
    /**
     * OPTIONAL
     */
    @Null
    @Component(4)
    public StabilityControlStatus scs;
    /**
     * OPTIONAL
     */
    @Null
    @Component(5)
    public BrakeBoostApplied brakeBoost;
    /**
     * OPTIONAL
     */
    @Null
    @Component(6)
    public AuxiliaryBrakeStatus auxBrakes;

    public static BrakeSystemStatus ber_decode(InputStream in) throws IOException {
        return (BrakeSystemStatus) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static BrakeSystemStatus per_decode(boolean align, InputStream in) throws IOException {
        return (BrakeSystemStatus) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BrakeSystemStatus)) {
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
        sb.append("\"brakePadel\":")
                .append(brakePadel);
        sb.append(",\"wheelBrakes\":")
                .append(wheelBrakes);
        sb.append(",\"traction\":")
                .append(traction);
        sb.append(",\"abs\":")
                .append(abs);
        sb.append(",\"scs\":")
                .append(scs);
        sb.append(",\"brakeBoost\":")
                .append(brakeBoost);
        sb.append(",\"auxBrakes\":")
                .append(auxBrakes);
        sb.append('}');
        return sb.toString();
    }
}
