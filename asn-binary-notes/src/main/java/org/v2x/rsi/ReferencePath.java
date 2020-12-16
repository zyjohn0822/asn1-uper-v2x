
package org.v2x.rsi;


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
@ASN1Sequence(name = "ReferencePath", isSet = false)
public class ReferencePath implements IASN1PreparedElement {

    @ASN1Element(name = "activePath", isOptional = false, hasTag = false, hasDefaultValue = false)
    private PathPointList activePath = null;

    @ASN1Element(name = "pathRadius", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Radius pathRadius = null;


    public PathPointList getActivePath() {
        return this.activePath;
    }


    public void setActivePath(PathPointList value) {
        this.activePath = value;
    }


    public Radius getPathRadius() {
        return this.pathRadius;
    }


    public void setPathRadius(Radius value) {
        this.pathRadius = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ReferencePath.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            