
package org.v2x.rsi;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1OctetString;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.constraints.ASN1SizeConstraint;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.bn.types.BitString;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1BoxedType(name = "RSIPriority")
public class RSIPriority implements IASN1PreparedElement {

    @ASN1OctetString(name = "RSIPriority")
    @ASN1SizeConstraint(max = 1L)
    private byte[] value = null;

    public RSIPriority() {
    }

    public RSIPriority(byte[] value) {
        this.value = value;
    }

    public RSIPriority(BitString value) {
        setValue(value);
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    public void setValue(BitString btStr) {
        this.value = btStr.getValue();
    }

    public byte[] getValue() {
        return this.value;
    }

    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(RSIPriority.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            