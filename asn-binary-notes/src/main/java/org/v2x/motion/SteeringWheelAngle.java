
package org.v2x.motion;

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
@ASN1BoxedType(name = "SteeringWheelAngle")
public class SteeringWheelAngle implements IASN1PreparedElement {

    @ASN1Integer(name = "SteeringWheelAngle")
    @ASN1ValueRangeConstraint(
            min = -126L,
            max = 127L
    )
    private Integer value;

    public SteeringWheelAngle() {
    }

    public SteeringWheelAngle(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(SteeringWheelAngle.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            