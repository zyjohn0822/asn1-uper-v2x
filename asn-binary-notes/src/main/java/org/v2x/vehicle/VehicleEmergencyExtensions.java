
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
@ASN1Sequence(name = "VehicleEmergencyExtensions", isSet = false)
public class VehicleEmergencyExtensions implements IASN1PreparedElement {

    @ASN1Element(name = "responseType", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ResponseType responseType = null;

    @ASN1Element(name = "sirenUse", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SirenInUse sirenUse = null;

    @ASN1Element(name = "lightsUse", isOptional = true, hasTag = false, hasDefaultValue = false)
    private LightbarInUse lightsUse = null;


    public ResponseType getResponseType() {
        return this.responseType;
    }


    public boolean isResponseTypePresent() {
        return this.responseType != null;
    }


    public void setResponseType(ResponseType value) {
        this.responseType = value;
    }


    public SirenInUse getSirenUse() {
        return this.sirenUse;
    }


    public boolean isSirenUsePresent() {
        return this.sirenUse != null;
    }


    public void setSirenUse(SirenInUse value) {
        this.sirenUse = value;
    }


    public LightbarInUse getLightsUse() {
        return this.lightsUse;
    }


    public boolean isLightsUsePresent() {
        return this.lightsUse != null;
    }


    public void setLightsUse(LightbarInUse value) {
        this.lightsUse = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(VehicleEmergencyExtensions.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            