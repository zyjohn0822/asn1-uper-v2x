package org.v2x.rsi;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "ReferencePath", isSet = false)
public class ReferencePath {

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


}
            