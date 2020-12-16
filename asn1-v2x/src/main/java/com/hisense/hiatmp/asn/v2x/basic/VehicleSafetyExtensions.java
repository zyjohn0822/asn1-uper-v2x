package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.HasExtensionMarker;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/4  19:15
 */
@Sequence
@Setter
@Getter
@HasExtensionMarker
public class VehicleSafetyExtensions {
    @Component(0)
    @Asn1Optional
    VehicleEventFlags events;
    @Component(1)
    @Asn1Optional
    PathHistory pathHistory;
    @Component(2)
    @Asn1Optional
    PathPrediction pathPrediction;
    @Component(3)
    @Asn1Optional
    ExteriorLights lights;

    public VehicleSafetyExtensions() {
    }

    public VehicleSafetyExtensions(
            VehicleEventFlags events,
            PathHistory pathHistory,
            PathPrediction pathPrediction,
            ExteriorLights lights
    ) {
        this.events = events;
        this.pathHistory = pathHistory;
        this.pathPrediction = pathPrediction;
        this.lights = lights;
    }
}
