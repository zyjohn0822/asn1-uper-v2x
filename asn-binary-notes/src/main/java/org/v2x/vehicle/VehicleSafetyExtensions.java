
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
@ASN1Sequence(name = "VehicleSafetyExtensions", isSet = false)
public class VehicleSafetyExtensions implements IASN1PreparedElement {

    @ASN1Element(name = "events", isOptional = true, hasTag = false, hasDefaultValue = false)
    private VehicleEventFlags events = null;

    @ASN1Element(name = "pathHistory", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PathHistory pathHistory = null;

    @ASN1Element(name = "pathPrediction", isOptional = true, hasTag = false, hasDefaultValue = false)
    private PathPrediction pathPrediction = null;

    @ASN1Element(name = "lights", isOptional = true, hasTag = false, hasDefaultValue = false)
    private ExteriorLights lights = null;


    public VehicleEventFlags getEvents() {
        return this.events;
    }


    public boolean isEventsPresent() {
        return this.events != null;
    }


    public void setEvents(VehicleEventFlags value) {
        this.events = value;
    }


    public PathHistory getPathHistory() {
        return this.pathHistory;
    }


    public boolean isPathHistoryPresent() {
        return this.pathHistory != null;
    }


    public void setPathHistory(PathHistory value) {
        this.pathHistory = value;
    }


    public PathPrediction getPathPrediction() {
        return this.pathPrediction;
    }


    public boolean isPathPredictionPresent() {
        return this.pathPrediction != null;
    }


    public void setPathPrediction(PathPrediction value) {
        this.pathPrediction = value;
    }


    public ExteriorLights getLights() {
        return this.lights;
    }


    public boolean isLightsPresent() {
        return this.lights != null;
    }


    public void setLights(ExteriorLights value) {
        this.lights = value;
    }


    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(VehicleSafetyExtensions.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            