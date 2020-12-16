
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
@ASN1Sequence(name = "Position3D", isSet = false)
public class Position3D implements IASN1PreparedElement {

    @ASN1Element(name = "lat", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Latitude lat = null;

    @ASN1Element(name = "long", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Longitude long_ = null;

    @ASN1Element(name = "elevation", isOptional = true, hasTag = false, hasDefaultValue = false)
    private Elevation elevation = null;


    public Latitude getLat() {
        return this.lat;
    }


    public void setLat(Latitude value) {
        this.lat = value;
    }


    public Longitude getLong_() {
        return this.long_;
    }


    public void setLong_(Longitude value) {
        this.long_ = value;
    }


    public Elevation getElevation() {
        return this.elevation;
    }


    public boolean isElevationPresent() {
        return this.elevation != null;
    }


    public void setElevation(Elevation value) {
        this.elevation = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(Position3D.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            