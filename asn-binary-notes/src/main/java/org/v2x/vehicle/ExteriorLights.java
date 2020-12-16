
package org.v2x.vehicle;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1BitString;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1BoxedType(name = "ExteriorLights")
public class ExteriorLights implements IASN1PreparedElement {

    @ASN1BitString(name = "ExteriorLights")
    @ASN1SizeConstraint(max = 9L)
    private BitString value = null;

    public ExteriorLights() {
    }

    public ExteriorLights(BitString value) {
        this.value = value;
    }

    public void setValue(BitString value) {
        this.value = value;
    }

    public BitString getValue() {
        return this.value;
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ExteriorLights.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }

}
            