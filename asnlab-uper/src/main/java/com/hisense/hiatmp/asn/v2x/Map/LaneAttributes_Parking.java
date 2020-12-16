/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "MapLane"
 */
package com.hisense.hiatmp.asn.v2x.Map;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.EncodingRules;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LaneAttributes_Parking extends BitString {

    public static final int parkingRevocableLane = 0;
    public static final int parallelParkingInUse = 1;
    public static final int headInParkingInUse = 2;
    public static final int doNotParkZone = 3;
    public static final int parkingForBusUse = 4;
    public static final int parkingForTaxiUse = 5;
    public static final int noPublicParkingUse = 6;
    public final static AsnType TYPE = Map.type(524348);
    public final static AsnConverter CONV;

    static {
        CONV = new ReflectionBitStringConverter(LaneAttributes_Parking.class);
    }

    public LaneAttributes_Parking(byte[] bytes, byte unusedBits) {
        super(bytes, unusedBits);
    }

    public LaneAttributes_Parking(int size) {
        super(size);
    }

    public LaneAttributes_Parking() {
        super(0);
    }

    public static LaneAttributes_Parking ber_decode(InputStream in) throws IOException {
        return (LaneAttributes_Parking) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static LaneAttributes_Parking per_decode(boolean align, InputStream in) throws IOException {
        return (LaneAttributes_Parking) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    public boolean getParkingRevocableLane() {
        return getBit(parkingRevocableLane);
    }

    public void setParkingRevocableLane() {
        setBit(parkingRevocableLane, true);
    }

    public void clearParkingRevocableLane() {
        setBit(parkingRevocableLane, false);
    }

    public boolean getParallelParkingInUse() {
        return getBit(parallelParkingInUse);
    }

    public void setParallelParkingInUse() {
        setBit(parallelParkingInUse, true);
    }

    public void clearParallelParkingInUse() {
        setBit(parallelParkingInUse, false);
    }

    public boolean getHeadInParkingInUse() {
        return getBit(headInParkingInUse);
    }

    public void setHeadInParkingInUse() {
        setBit(headInParkingInUse, true);
    }

    public void clearHeadInParkingInUse() {
        setBit(headInParkingInUse, false);
    }

    public boolean getDoNotParkZone() {
        return getBit(doNotParkZone);
    }

    public void setDoNotParkZone() {
        setBit(doNotParkZone, true);
    }

    public void clearDoNotParkZone() {
        setBit(doNotParkZone, false);
    }

    public boolean getParkingForBusUse() {
        return getBit(parkingForBusUse);
    }

    public void setParkingForBusUse() {
        setBit(parkingForBusUse, true);
    }

    public void clearParkingForBusUse() {
        setBit(parkingForBusUse, false);
    }

    public boolean getParkingForTaxiUse() {
        return getBit(parkingForTaxiUse);
    }

    public void setParkingForTaxiUse() {
        setBit(parkingForTaxiUse, true);
    }

    public void clearParkingForTaxiUse() {
        setBit(parkingForTaxiUse, false);
    }

    public boolean getNoPublicParkingUse() {
        return getBit(noPublicParkingUse);
    }

    public void setNoPublicParkingUse() {
        setBit(noPublicParkingUse, true);
    }

    public void clearNoPublicParkingUse() {
        setBit(noPublicParkingUse, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LaneAttributes_Parking)) {
            return false;
        }
        return TYPE.equals(this, obj, CONV);
    }

    public void ber_encode(OutputStream out) throws IOException {
        TYPE.encode(this, EncodingRules.BASIC_ENCODING_RULES, CONV, out);
    }

    public void per_encode(boolean align, OutputStream out) throws IOException {
        TYPE.encode(this, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV, out);
    }


}
