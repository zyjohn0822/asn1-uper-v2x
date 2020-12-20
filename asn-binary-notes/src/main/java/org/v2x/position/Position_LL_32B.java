package org.v2x.position;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "Position_LL_32B", isSet = false)
public class Position_LL_32B {

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


}
            