package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ExteriorLights ::= BIT STRING {<br/>
 * -- All lights off is indicated by no bits set<br/>
 * lowBeamHeadlightsOn (0),<br/>
 * highBeamHeadlightsOn (1),<br/>
 * leftTurnSignalOn (2),<br/>
 * rightTurnSignalOn (3),<br/>
 * hazardSignalOn (4),<br/>
 * automaticLightControlOn (5),<br/>
 * daytimeRunningLightsOn (6),<br/>
 * fogLightOn (7),<br/>
 * parkingLightsOn (8)<br/>
 * } (SIZE (9, ...))<br/>
 *
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\"");
        for (boolean s : bakingList) {
            if (s) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        sb.append("\"");
        return sb.toString();
    }
}
