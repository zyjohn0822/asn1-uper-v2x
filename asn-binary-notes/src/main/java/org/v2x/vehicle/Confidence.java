
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
@ASN1BoxedType(name = "Confidence")
public class Confidence implements IASN1PreparedElement {

    @ASN1Integer(name = "Confidence")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 200L
    )
    private Integer value;

    public Confidence() {
    }

    public Confidence(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Confidence.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            