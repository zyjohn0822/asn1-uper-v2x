package org.v2x.vehicle;


import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "VehicleEventFlags")
public class VehicleEventFlags {

    @ASN1BitString(name = "VehicleEventFlags")
    @ASN1SizeConstraint(max = 13L)
    private BitString value = null;

    public VehicleEventFlags() {
    }

    public VehicleEventFlags(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }
}
            