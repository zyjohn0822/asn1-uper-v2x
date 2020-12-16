
package org.v2x.rsi;


import org.bn.CoderFactory;
import org.bn.annotations.*;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.bn.coders.UniversalTag;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Choice(name = "Description")
public class Description implements IASN1PreparedElement {

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

    public boolean isTextStringSelected() {
        return this.textString != null;
    }

    private void setTextString(String value) {
        this.textString = value;
    }


    public void selectTextString(String value) {
        this.textString = value;

        setTextGB2312(null);

    }


    public byte[] getTextGB2312() {
        return this.textGB2312;
    }

    public boolean isTextGB2312Selected() {
        return this.textGB2312 != null;
    }

    private void setTextGB2312(byte[] value) {
        this.textGB2312 = value;
    }


    public void selectTextGB2312(byte[] value) {
        this.textGB2312 = value;

        setTextString(null);

    }


    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Description.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            