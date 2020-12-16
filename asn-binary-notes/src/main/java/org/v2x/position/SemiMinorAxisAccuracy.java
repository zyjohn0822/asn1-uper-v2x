
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
@ASN1BoxedType(name = "SemiMinorAxisAccuracy")
public class SemiMinorAxisAccuracy implements IASN1PreparedElement {

    @ASN1Integer(name = "SemiMinorAxisAccuracy")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 255L
    )
    private Integer value;

    public SemiMinorAxisAccuracy() {
    }

    public SemiMinorAxisAccuracy(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(SemiMinorAxisAccuracy.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            