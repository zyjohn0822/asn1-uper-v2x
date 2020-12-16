package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhangyong
 * @date 2020/11/5  14:17
 */
@SizeRange(minValue = 9, maxValue = 9, hasExtensionMarker = true)
public class ExteriorLights extends Asn1SequenceOf<Boolean> {
    public ExteriorLights() {
        this(new ArrayList<Boolean>());
    }

    public ExteriorLights(Collection<Boolean> coll) {
        super(coll);
    }

    public boolean getOrFalse(int i) {
        return (i < size()) ? get(i) : false;
    }

    public boolean lowBeamHeadlightsOn() {
        return getOrFalse(0);
    }

    public boolean highBeamHeadlightsOn() {
        return getOrFalse(1);
    }

    public boolean leftTurnSignalOn() {
        return getOrFalse(2);
    }

    public boolean rightTurnSignalOn() {
        return getOrFalse(3);
    }

    public boolean hazardSignalOn() {
        return getOrFalse(4);
    }

    public boolean automaticLightControlOn() {
        return getOrFalse(5);
    }

    public boolean daytimeRunningLightsOn() {
        return getOrFalse(6);
    }

    public boolean fogLightOn() {
        return getOrFalse(7);
    }

    public boolean parkingLightsOn() {
        return getOrFalse(8);
    }
}
