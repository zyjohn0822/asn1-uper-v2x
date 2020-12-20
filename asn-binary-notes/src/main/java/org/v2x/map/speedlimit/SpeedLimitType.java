package org.v2x.map.speedlimit;

import org.bn.annotations.ASN1Enum;
import org.bn.annotations.ASN1EnumItem;


/**
 * @author zhangyong
 */
@ASN1Enum(
        name = "SpeedLimitType"
)
public class SpeedLimitType {
    private EnumType value;
    private Integer integerForm;

    public EnumType getValue() {
        return this.value;
    }

    public void setValue(EnumType value) {
        this.value = value;
    }

    public Integer getIntegerForm() {
        return integerForm;
    }

    public void setIntegerForm(Integer value) {
        integerForm = value;
    }

    public enum EnumType {
        /**
         *
         */
        @ASN1EnumItem(name = "unknown", hasTag = true, tag = 0)
        unknown,
        @ASN1EnumItem(name = "maxSpeedInSchoolZone", hasTag = true, tag = 1)
        maxSpeedInSchoolZone,
        @ASN1EnumItem(name = "maxSpeedInSchoolZoneWhenChildrenArePresent", hasTag = true, tag = 2)
        maxSpeedInSchoolZoneWhenChildrenArePresent,
        @ASN1EnumItem(name = "maxSpeedInConstructionZone", hasTag = true, tag = 3)
        maxSpeedInConstructionZone,
        @ASN1EnumItem(name = "vehicleMinSpeed", hasTag = true, tag = 4)
        vehicleMinSpeed,
        @ASN1EnumItem(name = "vehicleMaxSpeed", hasTag = true, tag = 5)
        vehicleMaxSpeed,
        @ASN1EnumItem(name = "vehicleNightMaxSpeed", hasTag = true, tag = 6)
        vehicleNightMaxSpeed,
        @ASN1EnumItem(name = "truckMinSpeed", hasTag = true, tag = 7)
        truckMinSpeed,
        @ASN1EnumItem(name = "truckMaxSpeed", hasTag = true, tag = 8)
        truckMaxSpeed,
        @ASN1EnumItem(name = "truckNightMaxSpeed", hasTag = true, tag = 9)
        truckNightMaxSpeed,
        @ASN1EnumItem(name = "vehiclesWithTrailersMinSpeed", hasTag = true, tag = 11)
        vehiclesWithTrailersMinSpeed,
        @ASN1EnumItem(name = "vehiclesWithTrailersMaxSpeed", hasTag = true, tag = 12)
        vehiclesWithTrailersMaxSpeed,
        @ASN1EnumItem(name = "vehiclesWithTrailersNightMaxSpeed", hasTag = true, tag = 13)
        vehiclesWithTrailersNightMaxSpeed
    }


}
            