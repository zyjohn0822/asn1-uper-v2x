/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "MapLane"
 */
package com.hisense.hiatmp.asn.v2x.MapLane;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.EncodingRules;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LaneAttributes_Sidewalk extends BitString {

    public static final int sidewalk_RevocableLane = 0;
    public static final int bicyleUseAllowed = 1;
    public static final int isSidewalkFlyOverLane = 2;
    public static final int walkBikes = 3;
    public final static AsnType TYPE = MapLane.type(65543);
    public final static AsnConverter CONV;

    static {
        CONV = new ReflectionBitStringConverter(LaneAttributes_Sidewalk.class);
    }

    public LaneAttributes_Sidewalk(byte[] bytes, byte unusedBits) {
        super(bytes, unusedBits);
    }

    public LaneAttributes_Sidewalk(int size) {
        super(size);
    }

    public LaneAttributes_Sidewalk() {
        super(0);
    }

    public static LaneAttributes_Sidewalk ber_decode(InputStream in) throws IOException {
        return (LaneAttributes_Sidewalk) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static LaneAttributes_Sidewalk per_decode(boolean align, InputStream in) throws IOException {
        return (LaneAttributes_Sidewalk) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    public boolean getSidewalk_RevocableLane() {
        return getBit(sidewalk_RevocableLane);
    }

    public void setSidewalk_RevocableLane() {
        setBit(sidewalk_RevocableLane, true);
    }

    public void clearSidewalk_RevocableLane() {
        setBit(sidewalk_RevocableLane, false);
    }

    public boolean getBicyleUseAllowed() {
        return getBit(bicyleUseAllowed);
    }

    public void setBicyleUseAllowed() {
        setBit(bicyleUseAllowed, true);
    }

    public void clearBicyleUseAllowed() {
        setBit(bicyleUseAllowed, false);
    }

    public boolean getIsSidewalkFlyOverLane() {
        return getBit(isSidewalkFlyOverLane);
    }

    public void setIsSidewalkFlyOverLane() {
        setBit(isSidewalkFlyOverLane, true);
    }

    public void clearIsSidewalkFlyOverLane() {
        setBit(isSidewalkFlyOverLane, false);
    }

    public boolean getWalkBikes() {
        return getBit(walkBikes);
    }

    public void setWalkBikes() {
        setBit(walkBikes, true);
    }

    public void clearWalkBikes() {
        setBit(walkBikes, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LaneAttributes_Sidewalk)) {
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
