
package org.v2x.map.lane;


import org.bn.CoderFactory;
import org.bn.annotations.ASN1Choice;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;

/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Choice(name = "LaneTypeAttributes")
public class LaneTypeAttributes implements IASN1PreparedElement {

    @ASN1Element(name = "vehicle", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneAttributes_Vehicle vehicle = null;

    @ASN1Element(name = "crosswalk", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneAttributes_Crosswalk crosswalk = null;

    @ASN1Element(name = "bikeLane", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneAttributes_Bike bikeLane = null;

    @ASN1Element(name = "sidewalk", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneAttributes_Sidewalk sidewalk = null;

    @ASN1Element(name = "median", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneAttributes_Barrier median = null;

    @ASN1Element(name = "striping", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneAttributes_Striping striping = null;

    @ASN1Element(name = "trackedVehicle", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneAttributes_TrackedVehicle trackedVehicle = null;

    @ASN1Element(name = "parking", isOptional = false, hasTag = false, hasDefaultValue = false)
    private LaneAttributes_Parking parking = null;


    public LaneAttributes_Vehicle getVehicle() {
        return this.vehicle;
    }

    public boolean isVehicleSelected() {
        return this.vehicle != null;
    }

    private void setVehicle(LaneAttributes_Vehicle value) {
        this.vehicle = value;
    }


    public void selectVehicle(LaneAttributes_Vehicle value) {
        this.vehicle = value;

        setCrosswalk(null);

        setBikeLane(null);

        setSidewalk(null);

        setMedian(null);

        setStriping(null);

        setTrackedVehicle(null);

        setParking(null);

    }


    public LaneAttributes_Crosswalk getCrosswalk() {
        return this.crosswalk;
    }

    public boolean isCrosswalkSelected() {
        return this.crosswalk != null;
    }

    private void setCrosswalk(LaneAttributes_Crosswalk value) {
        this.crosswalk = value;
    }


    public void selectCrosswalk(LaneAttributes_Crosswalk value) {
        this.crosswalk = value;

        setVehicle(null);

        setBikeLane(null);

        setSidewalk(null);

        setMedian(null);

        setStriping(null);

        setTrackedVehicle(null);

        setParking(null);

    }


    public LaneAttributes_Bike getBikeLane() {
        return this.bikeLane;
    }

    public boolean isBikeLaneSelected() {
        return this.bikeLane != null;
    }

    private void setBikeLane(LaneAttributes_Bike value) {
        this.bikeLane = value;
    }


    public void selectBikeLane(LaneAttributes_Bike value) {
        this.bikeLane = value;

        setVehicle(null);

        setCrosswalk(null);

        setSidewalk(null);

        setMedian(null);

        setStriping(null);

        setTrackedVehicle(null);

        setParking(null);

    }


    public LaneAttributes_Sidewalk getSidewalk() {
        return this.sidewalk;
    }

    public boolean isSidewalkSelected() {
        return this.sidewalk != null;
    }

    private void setSidewalk(LaneAttributes_Sidewalk value) {
        this.sidewalk = value;
    }


    public void selectSidewalk(LaneAttributes_Sidewalk value) {
        this.sidewalk = value;

        setVehicle(null);

        setCrosswalk(null);

        setBikeLane(null);

        setMedian(null);

        setStriping(null);

        setTrackedVehicle(null);

        setParking(null);

    }


    public LaneAttributes_Barrier getMedian() {
        return this.median;
    }

    public boolean isMedianSelected() {
        return this.median != null;
    }

    private void setMedian(LaneAttributes_Barrier value) {
        this.median = value;
    }


    public void selectMedian(LaneAttributes_Barrier value) {
        this.median = value;

        setVehicle(null);

        setCrosswalk(null);

        setBikeLane(null);

        setSidewalk(null);

        setStriping(null);

        setTrackedVehicle(null);

        setParking(null);

    }


    public LaneAttributes_Striping getStriping() {
        return this.striping;
    }

    public boolean isStripingSelected() {
        return this.striping != null;
    }

    private void setStriping(LaneAttributes_Striping value) {
        this.striping = value;
    }


    public void selectStriping(LaneAttributes_Striping value) {
        this.striping = value;

        setVehicle(null);

        setCrosswalk(null);

        setBikeLane(null);

        setSidewalk(null);

        setMedian(null);

        setTrackedVehicle(null);

        setParking(null);

    }


    public LaneAttributes_TrackedVehicle getTrackedVehicle() {
        return this.trackedVehicle;
    }

    public boolean isTrackedVehicleSelected() {
        return this.trackedVehicle != null;
    }

    private void setTrackedVehicle(LaneAttributes_TrackedVehicle value) {
        this.trackedVehicle = value;
    }


    public void selectTrackedVehicle(LaneAttributes_TrackedVehicle value) {
        this.trackedVehicle = value;

        setVehicle(null);

        setCrosswalk(null);

        setBikeLane(null);

        setSidewalk(null);

        setMedian(null);

        setStriping(null);

        setParking(null);

    }


    public LaneAttributes_Parking getParking() {
        return this.parking;
    }

    public boolean isParkingSelected() {
        return this.parking != null;
    }

    private void setParking(LaneAttributes_Parking value) {
        this.parking = value;
    }


    public void selectParking(LaneAttributes_Parking value) {
        this.parking = value;

        setVehicle(null);

        setCrosswalk(null);

        setBikeLane(null);

        setSidewalk(null);

        setMedian(null);

        setStriping(null);

        setTrackedVehicle(null);

    }

    @Override
    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(LaneTypeAttributes.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            