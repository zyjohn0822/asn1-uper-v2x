package org.v2x.vehicle;

import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "GNSSstatus")
public class GNSSstatus {

    @ASN1BitString(name = "GNSSstatus")
    @ASN1SizeConstraint(max = 8L)
    private BitString value = null;

    public GNSSstatus() {
    }

    public GNSSstatus(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }
}
            