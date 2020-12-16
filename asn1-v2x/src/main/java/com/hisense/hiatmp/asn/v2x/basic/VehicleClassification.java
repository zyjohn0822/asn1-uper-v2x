package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * @author zhangyong
 * @date 2020/11/4  19:15
 */
@Sequence
@Setter
@Getter
@HasExtensionMarker
public class VehicleClassification {
    BasicVehicleClass classification;
    @Asn1Optional
    FuelType fuelType;

    public VehicleClassification() {
    }
    public VehicleClassification(BasicVehicleClass classification, FuelType fuelType) {
        this.classification = classification;
        this.fuelType = fuelType;
    }

    @IntRange(minValue = 0, maxValue = 255)
    public static class BasicVehicleClass extends Asn1Integer {
        public BasicVehicleClass() {
            this(0);
        }

        public BasicVehicleClass(int value) {
            super(value);
        }
    }

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
