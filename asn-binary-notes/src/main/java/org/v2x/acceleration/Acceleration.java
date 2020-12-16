
package org.v2x.acceleration;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1BoxedType(name = "Acceleration")
public class Acceleration implements IASN1PreparedElement {

    @ASN1Integer(name = "Acceleration")
    @ASN1ValueRangeConstraint(
            min = -2000L,
            max = 2001L
    )
    private Integer value;

    public Acceleration() {
    }

    public Acceleration(Integer value) {
        this.value = value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
    @Override
    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Acceleration.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            