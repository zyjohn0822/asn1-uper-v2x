
package org.v2x.vehicle;


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
@ASN1Sequence(name = "VehicleSize", isSet = false)
public class VehicleSize implements IASN1PreparedElement {

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


    public boolean isHeightPresent() {
        return this.height != null;
    }


    public void setHeight(VehicleHeight value) {
        this.height = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(VehicleSize.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            