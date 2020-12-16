
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
@ASN1Sequence(name = "Position_LL_32B", isSet = false)
public class Position_LL_32B implements IASN1PreparedElement {

    @ASN1Element(name = "lon", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B16 lon = null;

    @ASN1Element(name = "lat", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B16 lat = null;


    public OffsetLL_B16 getLon() {
        return this.lon;
    }


    public void setLon(OffsetLL_B16 value) {
        this.lon = value;
    }


    public OffsetLL_B16 getLat() {
        return this.lat;
    }


    public void setLat(OffsetLL_B16 value) {
        this.lat = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Position_LL_32B.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            