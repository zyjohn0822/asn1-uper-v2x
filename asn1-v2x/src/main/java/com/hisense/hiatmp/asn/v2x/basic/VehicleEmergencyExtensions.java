package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.HasExtensionMarker;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * VehEmgExt DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p>
 * -- imports and exports<br/>
 * <p>
 * EXPORTS VehicleEmergencyExtensions;<br/>
 * IMPORTS ;<br/>
 * <p>
 * -- type assignments	<br/>
 * <p>
 * VehicleEmergencyExtensions ::= SEQUENCE {<br/>
 * responseType ResponseType OPTIONAL,<br/>
 * sirenUse SirenInUse OPTIONAL,<br/>
 * lightsUse LightbarInUse OPTIONAL,<br/>
 * ...<br/>
 * }<br/>
 * <p>
 * ResponseType ::= ENUMERATED {<br/>
 * notInUseOrNotEquipped (0),<br/>
 * emergency (1), -- active service call at emergency level<br/>
 * nonEmergency (2), -- also used when returning from service call<br/>
 * pursuit (3), -- sender driving may be erratic<br/>
 * stationary (4), -- sender is not moving, stopped along roadside<br/>
 * slowMoving (5), -- such a litter trucks, etc.<br/>
 * stopAndGoMovement (6), -- such as school bus or garbage truck<br/>
 * ...<br/>
 * }<br/>
 * <p>
 * SirenInUse ::= ENUMERATED {<br/>
 * unavailable (0), -- Not Equipped or unavailable<br/>
 * notInUse (1),<br/>
 * inUse (2),<br/>
 * reserved (3) -- for future use<br/>
 * }<br/>
 * <p>
 * LightbarInUse ::= ENUMERATED {<br/>
 * unavailable (0), -- Not Equipped or unavailable<br/>
 * notInUse (1), -- none active<br/>
 * inUse (2),<br/>
 * yellowCautionLights (3),<br/>
 * schooldBusLights (4),<br/>
 * arrowSignsActive (5),<br/>
 * slowMovingVehicle (6),<br/>
 * freqStops (7)<br/>
 * }<br/>
 * <p>
 * END
 *
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
    public ResponseType responseType;
    @Component(1)
    @Asn1Optional
    public SirenInUse sirenUse;
    @Component(2)
    @Asn1Optional
    public LightbarInUse lightsUse;

    public VehicleEmergencyExtensions() {
    }

    public VehicleEmergencyExtensions(ResponseType responseType, SirenInUse sirenUse, LightbarInUse lightsUse) {
        this.responseType = responseType;
        this.sirenUse = sirenUse;
        this.lightsUse = lightsUse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"responseType\":")
                .append(responseType);
        sb.append(",\"sirenUse\":")
                .append(sirenUse);
        sb.append(",\"lightsUse\":")
                .append(lightsUse);
        sb.append('}');
        return sb.toString();
    }
}
