
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
@ASN1Sequence(name = "BrakeSystemStatus", isSet = false)
public class BrakeSystemStatus implements IASN1PreparedElement {

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


    public boolean isBrakePadelPresent() {
        return this.brakePadel != null;
    }


    public void setBrakePadel(BrakePedalStatus value) {
        this.brakePadel = value;
    }


    public BrakeAppliedStatus getWheelBrakes() {
        return this.wheelBrakes;
    }


    public boolean isWheelBrakesPresent() {
        return this.wheelBrakes != null;
    }


    public void setWheelBrakes(BrakeAppliedStatus value) {
        this.wheelBrakes = value;
    }


    public TractionControlStatus getTraction() {
        return this.traction;
    }


    public boolean isTractionPresent() {
        return this.traction != null;
    }


    public void setTraction(TractionControlStatus value) {
        this.traction = value;
    }


    public AntiLockBrakeStatus getAbs() {
        return this.abs;
    }


    public boolean isAbsPresent() {
        return this.abs != null;
    }


    public void setAbs(AntiLockBrakeStatus value) {
        this.abs = value;
    }


    public StabilityControlStatus getScs() {
        return this.scs;
    }


    public boolean isScsPresent() {
        return this.scs != null;
    }


    public void setScs(StabilityControlStatus value) {
        this.scs = value;
    }


    public BrakeBoostApplied getBrakeBoost() {
        return this.brakeBoost;
    }


    public boolean isBrakeBoostPresent() {
        return this.brakeBoost != null;
    }


    public void setBrakeBoost(BrakeBoostApplied value) {
        this.brakeBoost = value;
    }


    public AuxiliaryBrakeStatus getAuxBrakes() {
        return this.auxBrakes;
    }


    public boolean isAuxBrakesPresent() {
        return this.auxBrakes != null;
    }


    public void setAuxBrakes(AuxiliaryBrakeStatus value) {
        this.auxBrakes = value;
    }

    @Override
    public void initWithDefaults() {

    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(BrakeSystemStatus.class);
    @Override
    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            