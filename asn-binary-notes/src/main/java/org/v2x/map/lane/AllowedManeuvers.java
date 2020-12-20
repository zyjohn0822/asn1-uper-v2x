package org.v2x.map.lane;


import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "AllowedManeuvers")
public class AllowedManeuvers {

    @ASN1BitString(name = "AllowedManeuvers")
    @ASN1SizeConstraint(max = 12L)
    private BitString value = null;

    public AllowedManeuvers() {
    }

    public AllowedManeuvers(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }

}
            