package org.v2x.position;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "PositionalAccuracy", isSet = false)
public class PositionalAccuracy {

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

}
            