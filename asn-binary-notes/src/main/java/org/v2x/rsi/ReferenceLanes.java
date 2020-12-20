package org.v2x.rsi;

import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "ReferenceLanes")
public class ReferenceLanes {

    @ASN1BitString(name = "ReferenceLanes")
    @ASN1SizeConstraint(max = 16L)
    private BitString value = null;

    public ReferenceLanes() {
    }

    public ReferenceLanes(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }
}
            