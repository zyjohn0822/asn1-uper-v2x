package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.ArrayList;
import java.util.Collection;


/**
 * VehicleEventFlags ::= BIT STRING {<br/>
 * eventHazardLights (0),<br/>
 * eventStopLineViolation (1), -- Intersection Violation<br/>
 * eventABSactivated (2),<br/>
 * eventTractionControlLoss (3),<br/>
 * eventStabilityControlactivated (4),<br/>
 * eventHazardousMaterials (5),<br/>
 * eventReserved1 (6),<br/>
 * eventHardBraking (7),<br/>
 * eventLightsChanged (8),<br/>
 * eventWipersChanged (9),<br/>
 * eventFlatTire (10),<br/>
 * eventDisabledVehicle (11), -- The DisabledVehicle DF may also be sent<br/>
 * eventAirBagDeployment (12)<br/>
 * } (SIZE (13, ...))<br/>
 *
 * @author zhangyong
 * @date 2020/11/5  14:16
 */
@SizeRange(minValue = 13, maxValue = 13, hasExtensionMarker = true)
public class VehicleEventFlags extends Asn1SequenceOf<Boolean> {
    public VehicleEventFlags() {
        this(new ArrayList<Boolean>());
    }

    public VehicleEventFlags(Collection<Boolean> coll) {
        super(coll);
    }

    public boolean getOrFalse(int i) {
        return (i < size()) ? get(i) : false;
    }

    public boolean eventHazardLights() {
        return getOrFalse(0);
    }

    public boolean eventStopLineViolation() {
        return getOrFalse(1);
    }

    public boolean eventABSactivated() {
        return getOrFalse(2);
    }

    public boolean eventTractionControlLoss() {
        return getOrFalse(3);
    }

    public boolean eventStabilityControlactivated() {
        return getOrFalse(4);
    }

    public boolean eventHazardousMaterials() {
        return getOrFalse(5);
    }

    public boolean eventReserved1() {
        return getOrFalse(6);
    }

    public boolean eventHardBraking() {
        return getOrFalse(7);
    }

    public boolean eventLightsChanged() {
        return getOrFalse(8);
    }

    public boolean eventWipersChanged() {
        return getOrFalse(9);
    }

    public boolean eventFlatTire() {
        return getOrFalse(10);
    }

    public boolean eventDisabledVehicle() {
        return getOrFalse(11);
    }

    public boolean eventAirBagDeployment() {
        return getOrFalse(12);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\"");
        for (boolean s : bakingList) {
            if (s) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        sb.append("\"");
        return sb.toString();
    }
}
