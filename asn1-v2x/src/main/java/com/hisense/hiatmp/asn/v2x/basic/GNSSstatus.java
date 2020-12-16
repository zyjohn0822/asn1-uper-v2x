package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.ArrayList;
import java.util.Collection;

/**
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
}
