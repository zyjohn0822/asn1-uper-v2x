
package org.v2x.acceleration;


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
@ASN1Sequence(name = "AccelerationSet4Way", isSet = false)
public class AccelerationSet4Way implements IASN1PreparedElement {

    @ASN1Element(name = "long", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Acceleration long_ = null;

    @ASN1Element(name = "lat", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Acceleration lat = null;

    @ASN1Element(name = "vert", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VerticalAcceleration vert = null;

    @ASN1Element(name = "yaw", isOptional = false, hasTag = false, hasDefaultValue = false)
    private YawRate yaw = null;


    public Acceleration getLong_() {
        return this.long_;
    }


    public void setLong_(Acceleration value) {
        this.long_ = value;
    }


    public Acceleration getLat() {
        return this.lat;
    }


    public void setLat(Acceleration value) {
        this.lat = value;
    }


    public VerticalAcceleration getVert() {
        return this.vert;
    }


    public void setVert(VerticalAcceleration value) {
        this.vert = value;
    }


    public YawRate getYaw() {
        return this.yaw;
    }


    public void setYaw(YawRate value) {
        this.yaw = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(AccelerationSet4Way.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            