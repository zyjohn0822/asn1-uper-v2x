package org.v2x.position;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "Position_LL_36B", isSet = false)
public class Position_LL_36B {

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

}
            