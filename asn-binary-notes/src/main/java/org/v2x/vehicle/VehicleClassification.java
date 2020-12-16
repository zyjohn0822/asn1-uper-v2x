
package org.v2x.vehicle;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.annotations.ASN1Sequence;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Sequence(name = "VehicleClassification", isSet = false)
public class VehicleClassification implements IASN1PreparedElement {

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


    public boolean isFuelTypePresent() {
        return this.fuelType != null;
    }


    public void setFuelType(FuelType value) {
        this.fuelType = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(VehicleClassification.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            