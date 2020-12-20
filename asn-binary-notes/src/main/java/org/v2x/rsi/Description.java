package org.v2x.rsi;


import org.bn.annotations.ASN1Choice;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1OctetString;
import org.bn.annotations.ASN1String;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.bn.coders.UniversalTag;


/**
 * @author zhangyong
 */
@ASN1Choice(name = "Description")
public class Description {

    @ASN1String(name = "",
            stringType = UniversalTag.IA5String, isUCS = false)
    @ASN1ValueRangeConstraint(
            min = 1L,
            max = 512L
    )
    @ASN1Element(name = "textString", isOptional = false, hasTag = false, hasDefaultValue = false)
    private String textString = null;

    @ASN1OctetString(name = "textGB2312")
    @ASN1ValueRangeConstraint(
            min = 2L,
            max = 512L
    )
    @ASN1Element(name = "textGB2312", isOptional = false, hasTag = false, hasDefaultValue = false)
    private byte[] textGB2312 = null;


    public String getTextString() {
        return this.textString;
    }

    private void setTextString(String value) {
        this.textString = value;
    }

    public boolean isTextStringSelected() {
        return this.textString != null;
    }

    public void selectTextString(String value) {
        this.textString = value;

        setTextGB2312(null);

    }


    public byte[] getTextGB2312() {
        return this.textGB2312;
    }

    private void setTextGB2312(byte[] value) {
        this.textGB2312 = value;
    }

    public boolean isTextGB2312Selected() {
        return this.textGB2312 != null;
    }

    public void selectTextGB2312(byte[] value) {
        this.textGB2312 = value;

        setTextString(null);

    }

}
            