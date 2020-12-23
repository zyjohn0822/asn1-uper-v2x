package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.ArrayList;
import java.util.Collection;

/**
 * GNSSstatus ::= BIT STRING {<br/>
 * unavailable (0), -- Not Equipped or unavailable<br/>
 * isHealthy (1),<br/>
 * isMonitored (2),<br/>
 * baseStationType (3), -- Set to zero if a moving base station,<br/>
 * -- or if a rover device (an OBU),<br/>
 * -- set to one if it is a fixed base station<br/>
 * aPDOPofUnder5 (4), -- A dilution of precision greater than 5<br/>
 * inViewOfUnder5 (5), -- Less than 5 satellites in view<br/>
 * localCorrectionsPresent (6), -- pseudo range corrections used<br/>
 * networkCorrectionsPresent (7) -- RTK type corrections used<br/>
 * } (SIZE(8))<br/>
 *
 * @author zhangyong
 * @date 2020/11/5  14:40
 */
@SizeRange(minValue = 8, maxValue = 8)
public class GNSSstatus extends Asn1SequenceOf<Boolean> {
    public GNSSstatus() {
        this(new ArrayList<Boolean>());
    }

    public GNSSstatus(Collection<Boolean> coll) {
        super(coll);
    }

    public boolean getOrFalse(int i) {
        return (i < size()) ? get(i) : false;
    }

    public boolean unavailable() {
        return getOrFalse(0);
    }

    public boolean isHealthy() {
        return getOrFalse(1);
    }

    public boolean isMonitored() {
        return getOrFalse(2);
    }

    public boolean baseStationType() {
        return getOrFalse(3);
    }

    public boolean aPDOPofUnder5() {
        return getOrFalse(4);
    }

    public boolean inViewOfUnder5() {
        return getOrFalse(5);
    }

    public boolean localCorrectionsPresent() {
        return getOrFalse(6);
    }

    public boolean networkCorrectionsPresent() {
        return getOrFalse(7);
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
