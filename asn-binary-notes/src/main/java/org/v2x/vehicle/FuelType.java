
package org.v2x.vehicle;


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
@ASN1BoxedType(name = "FuelType")
public class FuelType implements IASN1PreparedElement {

    @ASN1Integer(name = "FuelType")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 15L
    )
    private Integer value;

    public FuelType() {
    }

    public FuelType(Integer value) {
        this.value = value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(FuelType.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            