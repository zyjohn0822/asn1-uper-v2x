
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
@ASN1BoxedType(name = "VehicleHeight")
public class VehicleHeight implements IASN1PreparedElement {

    @ASN1Integer(name = "VehicleHeight")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 127L
    )
    private Integer value;

    public VehicleHeight() {
    }

    public VehicleHeight(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(VehicleHeight.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            