package org.v2x.position;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */

@ASN1Sequence(name = "Position_LL_48B", isSet = false)
public class Position_LL_48B {

    @ASN1Element(name = "lon", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B24 lon = null;

    @ASN1Element(name = "lat", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B24 lat = null;


    public OffsetLL_B24 getLon() {
        return this.lon;
    }


    public void setLon(OffsetLL_B24 value) {
        this.lon = value;
    }


    public OffsetLL_B24 getLat() {
        return this.lat;
    }


    public void setLat(OffsetLL_B24 value) {
        this.lat = value;
    }


}
            