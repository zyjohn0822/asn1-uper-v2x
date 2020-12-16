
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
@ASN1Sequence(name = "Position_LLmD_64b", isSet = false)
public class Position_LLmD_64b implements IASN1PreparedElement {

    @ASN1Element(name = "lon", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Longitude lon = null;

    @ASN1Element(name = "lat", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Latitude lat = null;


    public Longitude getLon() {
        return this.lon;
    }


    public void setLon(Longitude value) {
        this.lon = value;
    }


    public Latitude getLat() {
        return this.lat;
    }


    public void setLat(Latitude value) {
        this.lat = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Position_LLmD_64b.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            