
package org.v2x.position;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "PositionOffsetLLV", isSet = false)
public class PositionOffsetLLV implements IASN1PreparedElement {

    @ASN1Element(name = "offsetLL", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PositionOffsetLL offsetLL = null;

    @ASN1Element(name = "offsetV", isOptional = true, hasTag = false, hasDefaultValue = false)
    private VerticalOffset offsetV = null;


    public PositionOffsetLL getOffsetLL() {
        return this.offsetLL;
    }


    public void setOffsetLL(PositionOffsetLL value) {
        this.offsetLL = value;
    }


    public VerticalOffset getOffsetV() {
        return this.offsetV;
    }


    public boolean isOffsetVPresent() {
        return this.offsetV != null;
    }


    public void setOffsetV(VerticalOffset value) {
        this.offsetV = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PositionOffsetLLV.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            