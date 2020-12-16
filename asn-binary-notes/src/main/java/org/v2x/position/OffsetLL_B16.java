
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
@ASN1BoxedType(name = "OffsetLL_B16")
public class OffsetLL_B16 implements IASN1PreparedElement {

    @ASN1Integer(name = "OffsetLL-B16")
    @ASN1ValueRangeConstraint(
            min = -32768L,
            max = 32767L
    )
    private Integer value;

    public OffsetLL_B16() {
    }

    public OffsetLL_B16(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(OffsetLL_B16.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            