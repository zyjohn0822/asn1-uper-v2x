
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
@ASN1BoxedType(name = "VehicleLength")
public class VehicleLength implements IASN1PreparedElement {

    @ASN1Integer(name = "VehicleLength")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 4095L
    )
    private Integer value;

    public VehicleLength() {
    }

    public VehicleLength(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(VehicleLength.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            