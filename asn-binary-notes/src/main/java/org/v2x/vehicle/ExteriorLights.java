package org.v2x.vehicle;


import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "ExteriorLights")
public class ExteriorLights {

    @ASN1BitString(name = "ExteriorLights")
    @ASN1SizeConstraint(max = 9L)
    private BitString value = null;

    public ExteriorLights() {
    }

    public ExteriorLights(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }

}
            