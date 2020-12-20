package org.v2x.position;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "Position_LLmD_64b", isSet = false)
public class Position_LLmD_64b {

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


}
            