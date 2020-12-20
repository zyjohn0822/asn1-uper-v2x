package org.v2x.rsi;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1Integer;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "SignType")
public class SignType {

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(SignType.class);
    @ASN1Integer(name = "SignType")
    @ASN1ValueRangeConstraint(
            min = 0L,
            max = 65535L
    )
    private Integer value;

    public SignType() {
    }

    public SignType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void initWithDefaults() {
    }

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            