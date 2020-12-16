/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "MapLane"
 */
package com.hisense.hiatmp.asn.v2x.Map;

import org.asnlab.asndt.runtime.conv.AnnotationChoiceConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.EncodingRules;
import org.asnlab.asndt.runtime.conv.annotation.Alternative;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LaneTypeAttributes {

    public static final int vehicleChosen = 0;
    public static final int crosswalkChosen = 1;
    public static final int bikeLaneChosen = 2;
    public static final int sidewalkChosen = 3;
    public static final int medianChosen = 4;
    public static final int stripingChosen = 5;
    public static final int trackedVehicleChosen = 6;
    public static final int parkingChosen = 7;
    public final static AsnType TYPE = Map.type(524340);
    public final static ChoiceConverter CONV;

    static {
        CONV = new AnnotationChoiceConverter(LaneTypeAttributes.class);
        AsnConverter vehicleConverter = LaneAttributes_Vehicle.CONV;
        AsnConverter crosswalkConverter = LaneAttributes_Crosswalk.CONV;
        AsnConverter bikeLaneConverter = LaneAttributes_Bike.CONV;
        AsnConverter sidewalkConverter = LaneAttributes_Sidewalk.CONV;
        AsnConverter medianConverter = LaneAttributes_Barrier.CONV;
        AsnConverter stripingConverter = LaneAttributes_Striping.CONV;
        AsnConverter trackedVehicleConverter = LaneAttributes_TrackedVehicle.CONV;
        AsnConverter parkingConverter = LaneAttributes_Parking.CONV;
        CONV.setAlternativeConverters(new AsnConverter[]{vehicleConverter, crosswalkConverter, bikeLaneConverter, sidewalkConverter, medianConverter, stripingConverter, trackedVehicleConverter, parkingConverter});
    }

    public final int choiceID;
    @Alternative(0)
    public final LaneAttributes_Vehicle vehicle;
    @Alternative(1)
    public final LaneAttributes_Crosswalk crosswalk;
    @Alternative(2)
    public final LaneAttributes_Bike bikeLane;
    @Alternative(3)
    public final LaneAttributes_Sidewalk sidewalk;
    @Alternative(4)
    public final LaneAttributes_Barrier median;
    @Alternative(5)
    public final LaneAttributes_Striping striping;
    @Alternative(6)
    public final LaneAttributes_TrackedVehicle trackedVehicle;
    @Alternative(7)
    public final LaneAttributes_Parking parking;

    private LaneTypeAttributes(int choiceID, LaneAttributes_Vehicle vehicle, LaneAttributes_Crosswalk crosswalk, LaneAttributes_Bike bikeLane, LaneAttributes_Sidewalk sidewalk, LaneAttributes_Barrier median, LaneAttributes_Striping striping, LaneAttributes_TrackedVehicle trackedVehicle, LaneAttributes_Parking parking) {
        this.choiceID = choiceID;
        this.vehicle = vehicle;
        this.crosswalk = crosswalk;
        this.bikeLane = bikeLane;
        this.sidewalk = sidewalk;
        this.median = median;
        this.striping = striping;
        this.trackedVehicle = trackedVehicle;
        this.parking = parking;
    }

    public static LaneTypeAttributes vehicle(LaneAttributes_Vehicle vehicle) {
        return new LaneTypeAttributes(vehicleChosen, vehicle, null, null, null, null, null, null, null);
    }

    public static LaneTypeAttributes crosswalk(LaneAttributes_Crosswalk crosswalk) {
        return new LaneTypeAttributes(crosswalkChosen, null, crosswalk, null, null, null, null, null, null);
    }

    public static LaneTypeAttributes bikeLane(LaneAttributes_Bike bikeLane) {
        return new LaneTypeAttributes(bikeLaneChosen, null, null, bikeLane, null, null, null, null, null);
    }

    public static LaneTypeAttributes sidewalk(LaneAttributes_Sidewalk sidewalk) {
        return new LaneTypeAttributes(sidewalkChosen, null, null, null, sidewalk, null, null, null, null);
    }

    public static LaneTypeAttributes median(LaneAttributes_Barrier median) {
        return new LaneTypeAttributes(medianChosen, null, null, null, null, median, null, null, null);
    }

    public static LaneTypeAttributes striping(LaneAttributes_Striping striping) {
        return new LaneTypeAttributes(stripingChosen, null, null, null, null, null, striping, null, null);
    }

    public static LaneTypeAttributes trackedVehicle(LaneAttributes_TrackedVehicle trackedVehicle) {
        return new LaneTypeAttributes(trackedVehicleChosen, null, null, null, null, null, null, trackedVehicle, null);
    }

    public static LaneTypeAttributes parking(LaneAttributes_Parking parking) {
        return new LaneTypeAttributes(parkingChosen, null, null, null, null, null, null, null, parking);
    }

    public static LaneTypeAttributes ber_decode(InputStream in) throws IOException {
        return (LaneTypeAttributes) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static LaneTypeAttributes per_decode(boolean align, InputStream in) throws IOException {
        return (LaneTypeAttributes) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LaneTypeAttributes)) {
            return false;
        }
        return TYPE.equals(this, obj, CONV);
    }

    public void ber_encode(OutputStream out) throws IOException {
        TYPE.encode(this, EncodingRules.BASIC_ENCODING_RULES, CONV, out);
    }

    public void per_encode(boolean align, OutputStream out) throws IOException {
        TYPE.encode(this, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV, out);
    }


}
