package org.v2x.vehicle;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "VehicleEmergencyExtensions", isSet = false)
public class VehicleEmergencyExtensions {

    @ASN1Element(name = "responseType", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ResponseType responseType = null;

    @ASN1Element(name = "sirenUse", isOptional = true, hasTag = false, hasDefaultValue = false)
    private SirenInUse sirenUse = null;

    @ASN1Element(name = "lightsUse", isOptional = true, hasTag = false, hasDefaultValue = false)
    private LightbarInUse lightsUse = null;


    public ResponseType getResponseType() {
        return this.responseType;
    }

    public void setResponseType(ResponseType value) {
        this.responseType = value;
    }

    public boolean isResponseTypePresent() {
        return this.responseType != null;
    }

    public SirenInUse getSirenUse() {
        return this.sirenUse;
    }

    public void setSirenUse(SirenInUse value) {
        this.sirenUse = value;
    }

    public boolean isSirenUsePresent() {
        return this.sirenUse != null;
    }

    public LightbarInUse getLightsUse() {
        return this.lightsUse;
    }

    public void setLightsUse(LightbarInUse value) {
        this.lightsUse = value;
    }

    public boolean isLightsUsePresent() {
        return this.lightsUse != null;
    }


}
            