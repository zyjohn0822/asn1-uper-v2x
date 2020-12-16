package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * @author zhangyong
 * @date 2020/11/4  19:28
 */
@Sequence
@Setter
@Getter
@HasExtensionMarker
public class VehicleEmergencyExtensions {
    @Component(0)
    @Asn1Optional
    ResponseType responseType;
    @Component(1)
    @Asn1Optional
    SirenInUse sirenUse;
    @Component(2)
    @Asn1Optional
    LightbarInUse lightsUse;

    public VehicleEmergencyExtensions(){}

    public VehicleEmergencyExtensions(ResponseType responseType, SirenInUse sirenUse, LightbarInUse lightsUse){
        this.responseType = responseType;
        this.sirenUse = sirenUse;
        this.lightsUse = lightsUse;
    }

}
