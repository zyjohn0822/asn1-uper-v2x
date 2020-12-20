package org.v2x.vehicle;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "VehicleSize", isSet = false)
public class VehicleSize {

    @ASN1Element(name = "width", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VehicleWidth width = null;

    @ASN1Element(name = "length", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VehicleLength length = null;

    @ASN1Element(name = "height", isOptional = true, hasTag = false, hasDefaultValue = false)
    private VehicleHeight height = null;


    public VehicleWidth getWidth() {
        return this.width;
    }


    public void setWidth(VehicleWidth value) {
        this.width = value;
    }


    public VehicleLength getLength() {
        return this.length;
    }


    public void setLength(VehicleLength value) {
        this.length = value;
    }


    public VehicleHeight getHeight() {
        return this.height;
    }

    public void setHeight(VehicleHeight value) {
        this.height = value;
    }

    public boolean isHeightPresent() {
        return this.height != null;
    }

}
            