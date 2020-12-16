
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
@ASN1BoxedType(name = "OffsetLL_B18")
public class OffsetLL_B18 implements IASN1PreparedElement {

    @ASN1Integer(name = "OffsetLL-B18")
    @ASN1ValueRangeConstraint(
            min = -131072L,
            max = 131071L
    )
    private Integer value;

    public OffsetLL_B18() {
    }

    public OffsetLL_B18(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(OffsetLL_B18.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            