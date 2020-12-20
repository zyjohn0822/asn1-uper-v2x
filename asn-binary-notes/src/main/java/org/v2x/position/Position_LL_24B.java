package org.v2x.position;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */

@ASN1Sequence(name = "Position_LL_24B", isSet = false)
public class Position_LL_24B {

    @ASN1Element(name = "lon", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B12 lon = null;


    @ASN1Element(name = "lat", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B12 lat = null;


    public OffsetLL_B12 getLon() {
        return this.lon;
    }


    public void setLon(OffsetLL_B12 value) {
        this.lon = value;
    }


    public OffsetLL_B12 getLat() {
        return this.lat;
    }


    public void setLat(OffsetLL_B12 value) {
        this.lat = value;
    }

}
            