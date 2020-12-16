
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
@ASN1Sequence(name = "PositionConfidenceSet", isSet = false)
public class PositionConfidenceSet implements IASN1PreparedElement {

    @ASN1Element(name = "pos", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PositionConfidence pos = null;

    @ASN1Element(name = "elevation", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ElevationConfidence elevation = null;


    public PositionConfidence getPos() {
        return this.pos;
    }


    public void setPos(PositionConfidence value) {
        this.pos = value;
    }


    public ElevationConfidence getElevation() {
        return this.elevation;
    }


    public boolean isElevationPresent() {
        return this.elevation != null;
    }


    public void setElevation(ElevationConfidence value) {
        this.elevation = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PositionConfidenceSet.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            