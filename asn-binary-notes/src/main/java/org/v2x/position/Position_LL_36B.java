
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
@ASN1Sequence(name = "Position_LL_36B", isSet = false)
public class Position_LL_36B implements IASN1PreparedElement {

    @ASN1Element(name = "lon", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B18 lon = null;

    @ASN1Element(name = "lat", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B18 lat = null;


    public OffsetLL_B18 getLon() {
        return this.lon;
    }


    public void setLon(OffsetLL_B18 value) {
        this.lon = value;
    }


    public OffsetLL_B18 getLat() {
        return this.lat;
    }


    public void setLat(OffsetLL_B18 value) {
        this.lat = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Position_LL_36B.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            