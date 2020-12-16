/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "RSI"
 */
package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.asnlab.asndt.runtime.conv.*;
import org.asnlab.asndt.runtime.conv.annotation.Alternative;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author zhangyong
 */
public class Description {

    public static final int textStringChosen = 0;
    public static final int textGB2312Chosen = 1;
    public final static AsnType TYPE = MsgFrame.type(1507478);
    public final static ChoiceConverter CONV;

    static {
        CONV = new AnnotationChoiceConverter(Description.class);
        AsnConverter textStringConverter = StringConverter.INSTANCE;
        AsnConverter textGB2312Converter = OctetStringConverter.INSTANCE;
        CONV.setAlternativeConverters(new AsnConverter[]{textStringConverter, textGB2312Converter});
    }

    public final int choiceID;
    @Alternative(0)
    public final String textString;
    @Size(min = 2, max = 512)
    @Alternative(1)
    public final byte[] textGB2312;

    private Description(int choiceID, String textString, byte[] textGB2312) {
        this.choiceID = choiceID;
        this.textString = textString;
        this.textGB2312 = textGB2312;
    }

    public static Description textString(String textString) {
        return new Description(textStringChosen, textString, null);
    }

    public static Description textGB2312(byte[] textGB2312) {
        return new Description(textGB2312Chosen, null, textGB2312);
    }

    public static Description ber_decode(InputStream in) throws IOException {
        return (Description) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static Description per_decode(boolean align, InputStream in) throws IOException {
        return (Description) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Description)) {
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
        sb.append("\"choiceID\":")
                .append(choiceID);
        sb.append(",\"textString\":\"")
                .append(textString).append('\"');
        sb.append(",\"textGB2312\":")
                .append(Arrays.toString(textGB2312));
        sb.append('}');
        return sb.toString();
    }
}
