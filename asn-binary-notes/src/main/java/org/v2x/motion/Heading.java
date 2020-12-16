
package org.v2x.motion;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;

/**
 *
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1BoxedType(name = "Heading")
public class Heading implements IASN1PreparedElement {

    @ASN1Integer(name = "Heading")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 28800L
    )
    private Integer value;

    public Heading() {
    }

    public Heading(Integer value) {
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

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Heading.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            