package org.v2x.position;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "Position_LL_28B", isSet = false)
public class Position_LL_28B {

    @ASN1Element(name = "lon", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B14 lon = null;

    @ASN1Element(name = "lat", isOptional = false, hasTag = false, hasDefaultValue = false)
    private OffsetLL_B14 lat = null;


    public OffsetLL_B14 getLon() {
        return this.lon;
    }


    public void setLon(OffsetLL_B14 value) {
        this.lon = value;
    }


    public OffsetLL_B14 getLat() {
        return this.lat;
    }


    public void setLat(OffsetLL_B14 value) {
        this.lat = value;
    }

}
            