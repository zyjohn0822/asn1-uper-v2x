package org.v2x.vehicle;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.ASN1SequenceOf;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "PathHistory", isSet = false)
public class PathHistory {

    @ASN1Element(name = "initialPosition", isOptional = true, hasTag = false, hasDefaultValue = false)
    private FullPositionVector initialPosition = null;

    @ASN1Element(name = "currGNSSstatus", isOptional = true, hasTag = false, hasDefaultValue = false)
    private GNSSstatus currGNSSstatus = null;

    @ASN1SequenceOf(name = "crumbData", isSetOf = false)
    @ASN1Element(name = "crumbData", isOptional = false, hasTag = false, hasDefaultValue = false)
    private java.util.Collection<PathHistoryPoint> crumbData = null;


    public FullPositionVector getInitialPosition() {
        return this.initialPosition;
    }

    public void setInitialPosition(FullPositionVector value) {
        this.initialPosition = value;
    }

    public boolean isInitialPositionPresent() {
        return this.initialPosition != null;
    }

    public GNSSstatus getCurrGNSSstatus() {
        return this.currGNSSstatus;
    }

    public void setCurrGNSSstatus(GNSSstatus value) {
        this.currGNSSstatus = value;
    }

    public boolean isCurrGNSSstatusPresent() {
        return this.currGNSSstatus != null;
    }

    public java.util.Collection<PathHistoryPoint> getCrumbData() {
        return this.crumbData;
    }


    public void setCrumbData(java.util.Collection<PathHistoryPoint> value) {
        this.crumbData = value;
    }


}
            