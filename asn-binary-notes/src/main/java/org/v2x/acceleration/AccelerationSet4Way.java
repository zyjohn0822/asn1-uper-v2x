package org.v2x.acceleration;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "AccelerationSet4Way", isSet = false)
public class AccelerationSet4Way {

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


}
            