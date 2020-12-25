package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.HasExtensionMarker;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * VehSafetyExt DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p>
 * -- imports and exports<br/>
 * <p>
 * EXPORTS VehicleSafetyExtensions, Confidence, FullPositionVector, GNSSstatus;<br/>
 * IMPORTS VehicleEventFlags, ExteriorLights, TransmissionState FROM VehStatus<br/>
 * PositionOffsetLLV FROM DefPositionOffset<br/>
 * Speed, Heading, MotionConfidenceSet, CoarseHeading FROM DefMotion<br/>
 * Position3D, PositionConfidenceSet, PositionalAccuracy FROM DefPosition<br/>
 * DDateTime, TimeOffset, TimeConfidence FROM DefTime;<br/>
 * <p>
 * VehicleSafetyExtensions ::= SEQUENCE {<br/>
 * events VehicleEventFlags OPTIONAL,<br/>
 * pathHistory PathHistory OPTIONAL,<br/>
 * pathPrediction PathPrediction OPTIONAL,<br/>
 * lights ExteriorLights OPTIONAL,<br/>
 * ...<br/>
 * }<br/>
 * END<br/>
 *
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
    public VehicleEventFlags events;
    @Component(1)
    @Asn1Optional
    public PathHistory pathHistory;
    @Component(2)
    @Asn1Optional
    public PathPrediction pathPrediction;
    @Component(3)
    @Asn1Optional
    public ExteriorLights lights;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"events\":")
                .append(events);
        sb.append(",\"pathHistory\":")
                .append(pathHistory);
        sb.append(",\"pathPrediction\":")
                .append(pathPrediction);
        sb.append(",\"lights\":")
                .append(lights);
        sb.append('}');
        return sb.toString();
    }
}
