package org.v2x.vehicle;


import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "BrakeAppliedStatus")
public class BrakeAppliedStatus {

    @ASN1BitString(name = "BrakeAppliedStatus")
    @ASN1SizeConstraint(max = 5L)
    private BitString value = null;

    public BrakeAppliedStatus() {
    }

    public BrakeAppliedStatus(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }
}
            