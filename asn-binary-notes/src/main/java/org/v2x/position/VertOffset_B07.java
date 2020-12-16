
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
@ASN1BoxedType(name = "VertOffset_B07")
public class VertOffset_B07 implements IASN1PreparedElement {

    @ASN1Integer(name = "VertOffset-B07")
    @ASN1ValueRangeConstraint(
            min = -64L,
            max = 63L
    )
    private Integer value;

    public VertOffset_B07() {
    }

    public VertOffset_B07(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(VertOffset_B07.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            