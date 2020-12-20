package org.v2x.vehicle;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "VehicleSafetyExtensions", isSet = false)
public class VehicleSafetyExtensions {

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

    public void setEvents(VehicleEventFlags value) {
        this.events = value;
    }

    public boolean isEventsPresent() {
        return this.events != null;
    }

    public PathHistory getPathHistory() {
        return this.pathHistory;
    }

    public void setPathHistory(PathHistory value) {
        this.pathHistory = value;
    }

    public boolean isPathHistoryPresent() {
        return this.pathHistory != null;
    }

    public PathPrediction getPathPrediction() {
        return this.pathPrediction;
    }

    public void setPathPrediction(PathPrediction value) {
        this.pathPrediction = value;
    }

    public boolean isPathPredictionPresent() {
        return this.pathPrediction != null;
    }

    public ExteriorLights getLights() {
        return this.lights;
    }

    public void setLights(ExteriorLights value) {
        this.lights = value;
    }

    public boolean isLightsPresent() {
        return this.lights != null;
    }

}
            