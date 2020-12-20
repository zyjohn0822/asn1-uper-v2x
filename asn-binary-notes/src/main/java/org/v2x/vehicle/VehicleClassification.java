package org.v2x.vehicle;

import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "VehicleClassification", isSet = false)
public class VehicleClassification {

    @ASN1Element(name = "classification", isOptional = false, hasTag = false, hasDefaultValue = false)
    private BasicVehicleClass classification = null;

    @ASN1Element(name = "fuelType", isOptional = true, hasTag = false, hasDefaultValue = false)
    private FuelType fuelType = null;


    public BasicVehicleClass getClassification() {
        return this.classification;
    }


    public void setClassification(BasicVehicleClass value) {
        this.classification = value;
    }


    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(FuelType value) {
        this.fuelType = value;
    }

    public boolean isFuelTypePresent() {
        return this.fuelType != null;
    }


}
            