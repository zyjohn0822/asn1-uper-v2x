
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
@ASN1BoxedType(name = "OffsetLL_B24")
public class OffsetLL_B24 implements IASN1PreparedElement {

    @ASN1Integer(name = "OffsetLL-B24")
    @ASN1ValueRangeConstraint(
            min = -8388608L,
            max = 8388607L
    )
    private Integer value;

    public OffsetLL_B24() {
    }

    public OffsetLL_B24(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(OffsetLL_B24.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            