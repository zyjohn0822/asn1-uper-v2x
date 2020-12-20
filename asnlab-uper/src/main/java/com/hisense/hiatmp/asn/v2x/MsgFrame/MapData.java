/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "Map"
 */
package com.hisense.hiatmp.asn.v2x.MsgFrame;

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
import java.util.Vector;

/**
 * @author zhangyong
 */
public class MapData {

    public final static AsnType TYPE = MsgFrame.type(917593);
    public final static CompositeConverter CONV;

    static {
        CONV = new AnnotationCompositeConverter(MapData.class);
        AsnConverter msgCntConverter = MsgCount.CONV;
        AsnConverter timeStampConverter = MinuteOfTheYear.CONV;
        AsnConverter nodesConverter = NodeList.CONV;
        CONV.setComponentConverters(new AsnConverter[]{msgCntConverter, timeStampConverter, nodesConverter});
    }

    @NotNull
    @Component(0)
    public Integer msgCnt;
    /**
     * OPTIONAL
     */
    @Null
    @Component(1)
    public Integer timeStamp;
    @NotNull
    @Component(2)
    public Vector<Node> nodes;

    public static MapData ber_decode(InputStream in) throws IOException {
        return (MapData) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static MapData per_decode(boolean align, InputStream in) throws IOException {
        return (MapData) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MapData)) {
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
        sb.append("\"msgCnt\":")
                .append(msgCnt);
        sb.append(",\"timeStamp\":")
                .append(timeStamp);
        sb.append(",\"nodes\":")
                .append(nodes);
        sb.append('}');
        return sb.toString();
    }
}