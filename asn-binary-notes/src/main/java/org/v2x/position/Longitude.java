
package org.v2x.position;

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
@ASN1BoxedType(name = "Longitude")
public class Longitude implements IASN1PreparedElement {

    @ASN1Integer(name = "Longitude")
    @ASN1ValueRangeConstraint(
            min = -1799999999L,
            max = 1800000001L
    )
    private Integer value;

    public Longitude() {
    }

    public Longitude(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Longitude.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            