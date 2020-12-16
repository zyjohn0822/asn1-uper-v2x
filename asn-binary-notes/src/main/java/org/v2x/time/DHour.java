
package org.v2x.time;


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
@ASN1BoxedType(name = "DHour")
public class DHour implements IASN1PreparedElement {

    @ASN1Integer(name = "DHour")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 24L
    )
    private Integer value;

    public DHour() {
    }

    public DHour(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(DHour.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            