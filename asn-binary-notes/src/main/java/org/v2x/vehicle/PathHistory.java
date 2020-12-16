
package org.v2x.vehicle;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.annotations.ASN1SequenceOf;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "PathHistory", isSet = false)
public class PathHistory implements IASN1PreparedElement {

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


    public boolean isInitialPositionPresent() {
        return this.initialPosition != null;
    }


    public void setInitialPosition(FullPositionVector value) {
        this.initialPosition = value;
    }


    public GNSSstatus getCurrGNSSstatus() {
        return this.currGNSSstatus;
    }


    public boolean isCurrGNSSstatusPresent() {
        return this.currGNSSstatus != null;
    }


    public void setCurrGNSSstatus(GNSSstatus value) {
        this.currGNSSstatus = value;
    }


    public java.util.Collection<PathHistoryPoint> getCrumbData() {
        return this.crumbData;
    }


    public void setCrumbData(java.util.Collection<PathHistoryPoint> value) {
        this.crumbData = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PathHistory.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            