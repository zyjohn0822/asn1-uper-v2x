package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * VehClass DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p>
 * -- imports and exports<br/>
 * <p>
 * EXPORTS VehicleClassification;<br/>
 * IMPORTS ;<br/>
 * <p>
 * VehicleClassification ::= SEQUENCE {<br/>
 * classification BasicVehicleClass,<br/>
 * fuelType FuelType OPTIONAL,<br/>
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
public class VehicleClassification {
    @Component(0)
    public BasicVehicleClass classification;
    @Component(1)
    @Asn1Optional
    public FuelType fuelType;

    public VehicleClassification() {
    }

    public VehicleClassification(BasicVehicleClass classification, FuelType fuelType) {
        this.classification = classification;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"classification\":")
                .append(classification);
        sb.append(",\"fuelType\":")
                .append(fuelType);
        sb.append('}');
        return sb.toString();
    }

    /**
     * --********************************Basic Vehicle Class**************************<br/>
     * BasicVehicleClass ::= INTEGER (0..255)<br/>
     * <p>
     * unknownVehicleClass BasicVehicleClass ::= 0<br/>
     * -- Not Equipped, Not known or unavailable<br/>
     * specialVehicleClass BasicVehicleClass ::= 1<br/>
     * -- Special use<br/>
     * --<br/>
     * -- Basic Passenger Motor Vehicle Types<br/>
     * --<br/>
     * passenger-Vehicle-TypeUnknown BasicVehicleClass ::= 10 -- default type<br/>
     * passenger-Vehicle-TypeOther BasicVehicleClass ::= 11<br/>
     * -- various fuel types are handled in another element<br/>
     * --<br/>
     * -- Light Trucks, Pickup, Van, Panel<br/>
     * --<br/>
     * lightTruck-Vehicle-TypeUnknown BasicVehicleClass ::= 20 -- default type<br/>
     * lightTruck-Vehicle-TypeOther BasicVehicleClass ::= 21<br/>
     * --<br/>
     * -- Trucks, Various axle types, includes HPMS items<br/>
     * --<br/>
     * truck-Vehicle-TypeUnknown BasicVehicleClass ::= 25 -- default type<br/>
     * truck-Vehicle-TypeOther BasicVehicleClass ::= 26<br/>
     * truck-axleCnt2 BasicVehicleClass ::= 27 -- Two axle, six tire single units<br/>
     * truck-axleCnt3 BasicVehicleClass ::= 28 -- Three axle, single units<br/>
     * truck-axleCnt4 BasicVehicleClass ::= 29 -- Four or more axle, single unit<br/>
     * truck-axleCnt4Trailer BasicVehicleClass ::= 30 -- Four or less axle, single trailer<br/>
     * truck-axleCnt5Trailer BasicVehicleClass ::= 31 -- Five or less axle, single trailer<br/>
     * truck-axleCnt6Trailer BasicVehicleClass ::= 32 -- Six or more axle, single trailer<br/>
     * truck-axleCnt5MultiTrailer BasicVehicleClass ::= 33 -- Five or less axle, multi-trailer<br/>
     * truck-axleCnt6MultiTrailer BasicVehicleClass ::= 34 -- Six axle, multi-trailer<br/>
     * truck-axleCnt7MultiTrailer BasicVehicleClass ::= 35 -- Seven or more axle, multi-trailer<br/>
     * --<br/>
     * -- Motorcycle Types<br/>
     * --<br/>
     * motorcycle-TypeUnknown BasicVehicleClass ::= 40 -- default type<br/>
     * motorcycle-TypeOther BasicVehicleClass ::= 41<br/>
     * motorcycle-Cruiser-Standard BasicVehicleClass ::= 42<br/>
     * motorcycle-SportUnclad BasicVehicleClass ::= 43<br/>
     * motorcycle-SportTouring BasicVehicleClass ::= 44<br/>
     * motorcycle-SuperSport BasicVehicleClass ::= 45<br/>
     * motorcycle-Touring BasicVehicleClass ::= 46<br/>
     * motorcycle-Trike BasicVehicleClass ::= 47<br/>
     * motorcycle-wPassengers BasicVehicleClass ::= 48 -- type not stated<br/>
     * --<br/>
     * -- Transit Types<br/>
     * --<br/>
     * transit-TypeUnknown BasicVehicleClass ::= 50 -- default type<br/>
     * transit-TypeOther BasicVehicleClass ::= 51<br/>
     * transit-BRT BasicVehicleClass ::= 52<br/>
     * transit-ExpressBus BasicVehicleClass ::= 53<br/>
     * transit-LocalBus BasicVehicleClass ::= 54<br/>
     * transit-SchoolBus BasicVehicleClass ::= 55<br/>
     * transit-FixedGuideway BasicVehicleClass ::= 56<br/>
     * transit-Paratransit BasicVehicleClass ::= 57<br/>
     * transit-Paratransit-Ambulance BasicVehicleClass ::= 58<br/>
     * --<br/>
     * -- Emergency Vehicle Types<br/>
     * --<br/>
     * emergency-TypeUnknown BasicVehicleClass ::= 60 -- default type<br/>
     * emergency-TypeOther BasicVehicleClass ::= 61 -- includes federal users<br/>
     * emergency-Fire-Light-Vehicle BasicVehicleClass ::= 62<br/>
     * emergency-Fire-Heavy-Vehicle BasicVehicleClass ::= 63<br/>
     * emergency-Fire-Paramedic-Vehicle BasicVehicleClass ::= 64<br/>
     * emergency-Fire-Ambulance-Vehicle BasicVehicleClass ::= 65<br/>
     * emergency-Police-Light-Vehicle BasicVehicleClass ::= 66<br/>
     * emergency-Police-Heavy-Vehicle BasicVehicleClass ::= 67<br/>
     * emergency-Other-Responder BasicVehicleClass ::= 68<br/>
     * emergency-Other-Ambulance BasicVehicleClass ::= 69<br/>
     * --<br/>
     * -- Other V2X Equipped Travelers<br/>
     * --<br/>
     * otherTraveler-TypeUnknown BasicVehicleClass ::= 80 -- default type<br/>
     * otherTraveler-TypeOther BasicVehicleClass ::= 81<br/>
     * otherTraveler-Pedestrian BasicVehicleClass ::= 82<br/>
     * otherTraveler-Visually-Disabled BasicVehicleClass ::= 83<br/>
     * otherTraveler-Physically-Disabled BasicVehicleClass ::= 84<br/>
     * otherTraveler-Bicycle BasicVehicleClass ::= 85<br/>
     * otherTraveler-Vulnerable-Roadworker BasicVehicleClass ::= 86<br/>
     * --<br/>
     * -- Other V2X Equipped Device Types<br/>
     * --<br/>
     * infrastructure-TypeUnknown BasicVehicleClass ::= 90 -- default type<br/>
     * infrastructure-Fixed BasicVehicleClass ::= 91<br/>
     * infrastructure-Movable BasicVehicleClass ::= 92<br/>
     * equipped-CargoTrailer BasicVehicleClass ::= 93<br/>
     */
    @IntRange(minValue = 0, maxValue = 255)
    public static class BasicVehicleClass extends Asn1Integer {
        public BasicVehicleClass() {
            this(0);
        }

        public BasicVehicleClass(int value) {
            super(value);
        }
    }

    /**
     * FuelType ::= INTEGER (0..15)<br/>
     * <p>
     * unknownFuel FuelType::= 0 -- Gasoline Powered<br/>
     * gasoline FuelType::= 1<br/>
     * ethanol FuelType::= 2 -- Including blends<br/>
     * diesel FuelType::= 3 -- All types<br/>
     * electric FuelType::= 4<br/>
     * hybrid FuelType::= 5 -- All types<br/>
     * hydrogen FuelType::= 6<br/>
     * natGasLiquid FuelType::= 7 -- Liquefied<br/>
     * natGasComp FuelType::= 8 -- Compressed<br/>
     * propane FuelType::= 9<br/>
     */
    @IntRange(minValue = 0, maxValue = 15)
    public static class FuelType extends Asn1Integer {
        public FuelType() {
            this(0);
        }

        public FuelType(int value) {
            super(value);
        }
    }
}
