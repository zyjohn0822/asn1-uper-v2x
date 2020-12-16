
package org.v2x.map.lane;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1BoxedType(name = "LaneAttributes_Bike")
public class LaneAttributes_Bike implements IASN1PreparedElement {

    @ASN1BitString(name = "LaneAttributes-Bike")
    @ASN1SizeConstraint(max = 16L)
    private BitString value = null;

    public LaneAttributes_Bike() {
    }

    public LaneAttributes_Bike(BitString value) {
        this.value = value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }
    @Override
    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(LaneAttributes_Bike.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }

}
            