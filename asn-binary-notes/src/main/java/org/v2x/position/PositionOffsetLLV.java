package org.v2x.position;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */

@ASN1Sequence(name = "PositionOffsetLLV", isSet = false)
public class PositionOffsetLLV {

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

    public void setOffsetV(VerticalOffset value) {
        this.offsetV = value;
    }

    public boolean isOffsetVPresent() {
        return this.offsetV != null;
    }

}
            