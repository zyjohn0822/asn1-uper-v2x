package org.v2x.vehicle;


import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1Sequence;


/**
 * @author zhangyong
 */
@ASN1Sequence(name = "BrakeSystemStatus", isSet = false)
public class BrakeSystemStatus {

    @ASN1Element(name = "brakePadel", isOptional = true, hasTag = false, hasDefaultValue = false)
    private BrakePedalStatus brakePadel = null;

    @ASN1Element(name = "wheelBrakes", isOptional = true, hasTag = false, hasDefaultValue = false)
    private BrakeAppliedStatus wheelBrakes = null;

    @ASN1Element(name = "traction", isOptional = true, hasTag = false, hasDefaultValue = false)
    private TractionControlStatus traction = null;

    @ASN1Element(name = "abs", isOptional = true, hasTag = false, hasDefaultValue = false)
    private AntiLockBrakeStatus abs = null;

    @ASN1Element(name = "scs", isOptional = true, hasTag = false, hasDefaultValue = false)
    private StabilityControlStatus scs = null;

    @ASN1Element(name = "brakeBoost", isOptional = true, hasTag = false, hasDefaultValue = false)
    private BrakeBoostApplied brakeBoost = null;

    @ASN1Element(name = "auxBrakes", isOptional = true, hasTag = false, hasDefaultValue = false)
    private AuxiliaryBrakeStatus auxBrakes = null;

    public BrakePedalStatus getBrakePadel() {
        return this.brakePadel;
    }

    public void setBrakePadel(BrakePedalStatus value) {
        this.brakePadel = value;
    }

    public boolean isBrakePadelPresent() {
        return this.brakePadel != null;
    }

    public BrakeAppliedStatus getWheelBrakes() {
        return this.wheelBrakes;
    }

    public void setWheelBrakes(BrakeAppliedStatus value) {
        this.wheelBrakes = value;
    }

    public boolean isWheelBrakesPresent() {
        return this.wheelBrakes != null;
    }

    public TractionControlStatus getTraction() {
        return this.traction;
    }

    public void setTraction(TractionControlStatus value) {
        this.traction = value;
    }

    public boolean isTractionPresent() {
        return this.traction != null;
    }

    public AntiLockBrakeStatus getAbs() {
        return this.abs;
    }

    public void setAbs(AntiLockBrakeStatus value) {
        this.abs = value;
    }

    public boolean isAbsPresent() {
        return this.abs != null;
    }

    public StabilityControlStatus getScs() {
        return this.scs;
    }

    public void setScs(StabilityControlStatus value) {
        this.scs = value;
    }

    public boolean isScsPresent() {
        return this.scs != null;
    }

    public BrakeBoostApplied getBrakeBoost() {
        return this.brakeBoost;
    }

    public void setBrakeBoost(BrakeBoostApplied value) {
        this.brakeBoost = value;
    }

    public boolean isBrakeBoostPresent() {
        return this.brakeBoost != null;
    }

    public AuxiliaryBrakeStatus getAuxBrakes() {
        return this.auxBrakes;
    }

    public void setAuxBrakes(AuxiliaryBrakeStatus value) {
        this.auxBrakes = value;
    }

    public boolean isAuxBrakesPresent() {
        return this.auxBrakes != null;
    }


}
            