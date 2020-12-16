
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
@ASN1BoxedType(name = "Speed")
public class Speed implements IASN1PreparedElement {

    @ASN1Integer(name = "Speed")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 8191L
    )

    private Integer value;

    public Speed() {
    }

    public Speed(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Speed.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            