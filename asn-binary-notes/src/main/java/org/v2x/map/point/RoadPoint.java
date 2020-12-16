
package org.v2x.map.point;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.position.PositionOffsetLLV;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "RoadPoint", isSet = false)
public class RoadPoint implements IASN1PreparedElement {

    @ASN1Element(name = "posOffset", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PositionOffsetLLV posOffset = null;


    public PositionOffsetLLV getPosOffset() {
        return this.posOffset;
    }


    public void setPosOffset(PositionOffsetLLV value) {
        this.posOffset = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(RoadPoint.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            