
package org.v2x.position;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "PositionalAccuracy", isSet = false)
public class PositionalAccuracy implements IASN1PreparedElement {

    @ASN1Element(name = "semiMajor", isOptional = false, hasTag = false, hasDefaultValue = false)
    private SemiMajorAxisAccuracy semiMajor = null;

    @ASN1Element(name = "semiMinor", isOptional = false, hasTag = false, hasDefaultValue = false)
    private SemiMinorAxisAccuracy semiMinor = null;

    @ASN1Element(name = "orientation", isOptional = false, hasTag = false, hasDefaultValue = false)
    private SemiMajorAxisOrientation orientation = null;


    public SemiMajorAxisAccuracy getSemiMajor() {
        return this.semiMajor;
    }


    public void setSemiMajor(SemiMajorAxisAccuracy value) {
        this.semiMajor = value;
    }


    public SemiMinorAxisAccuracy getSemiMinor() {
        return this.semiMinor;
    }


    public void setSemiMinor(SemiMinorAxisAccuracy value) {
        this.semiMinor = value;
    }


    public SemiMajorAxisOrientation getOrientation() {
        return this.orientation;
    }


    public void setOrientation(SemiMajorAxisOrientation value) {
        this.orientation = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PositionalAccuracy.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            