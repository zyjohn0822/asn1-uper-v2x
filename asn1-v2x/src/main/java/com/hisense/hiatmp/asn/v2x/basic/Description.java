package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Description ::= CHOICE{<br/>
 * textString IA5String (SIZE(1..512)),<br/>
 * -- ASCII text<br/>
 * textGB2312 OCTET STRING (SIZE(2..512))<br/>
 * -- text using Chinese-character encoding GB2312-80<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/23  10:43
 */
@Getter
@Setter
@Choice
public class Description {
    public TextString textString;
    public TextGB2312 textGB2312;

    public Description() {
    }

    public Description(TextString textString, TextGB2312 textGB2312) {
        this.textString = textString;
        this.textGB2312 = textGB2312;
    }

    public static Description textString(TextString textString) {
        return new Description(textString, null);
    }

    public static Description textGB2312(TextGB2312 textGB2312) {
        return new Description(null, textGB2312);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"textString\":")
                .append(textString);
        sb.append(",\"textGB2312\":")
                .append(textGB2312);
        sb.append('}');
        return sb.toString();
    }

    /**
     * textString IA5String (SIZE(1..512)),
     * -- ASCII text
     */
    @RestrictedString(CharacterRestriction.IA5String)
    @SizeRange(minValue = 1, maxValue = 512)
    public static class TextString extends Asn1String {
        public TextString() {
            this("");
        }

        public TextString(String value) {
            super(value);
        }
    }

    /**
     * textGB2312 OCTET STRING (SIZE(2..512))
     * -- text using Chinese-character encoding GB2312-80
     */
    @SizeRange(minValue = 2, maxValue = 512)
    public static class TextGB2312 extends Asn1SequenceOf<Byte> {
        public TextGB2312(Byte... coll) {
            this(Arrays.asList(coll));
        }

        public TextGB2312(Collection<Byte> coll) {
            super(coll);
        }
    }
}
