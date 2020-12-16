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

public class AllowedManeuvers extends BitString {

    public static final int maneuverStraightAllowed = 0;
    public static final int maneuverLeftAllowed = 1;
    public static final int maneuverRightAllowed = 2;
    public static final int maneuverUTurnAllowed = 3;
    public static final int maneuverLeftTurnOnRedAllowed = 4;
    public static final int maneuverRightTurnOnRedAllowed = 5;
    public static final int maneuverLaneChangeAllowed = 6;
    public static final int maneuverNoStoppingAllowed = 7;
    public static final int yieldAllwaysRequired = 8;
    public static final int goWithHalt = 9;
    public static final int caution = 10;
    public static final int reserved1 = 11;
    public final static AsnType TYPE = MapLane.type(65550);
    public final static AsnConverter CONV;

    static {
        CONV = new ReflectionBitStringConverter(AllowedManeuvers.class);
    }

    public AllowedManeuvers(byte[] bytes, byte unusedBits) {
        super(bytes, unusedBits);
    }

    public AllowedManeuvers(int size) {
        super(size);
    }

    public AllowedManeuvers() {
        super(0);
    }

    public static AllowedManeuvers ber_decode(InputStream in) throws IOException {
        return (AllowedManeuvers) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static AllowedManeuvers per_decode(boolean align, InputStream in) throws IOException {
        return (AllowedManeuvers) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    public boolean getManeuverStraightAllowed() {
        return getBit(maneuverStraightAllowed);
    }

    public void setManeuverStraightAllowed() {
        setBit(maneuverStraightAllowed, true);
    }

    public void clearManeuverStraightAllowed() {
        setBit(maneuverStraightAllowed, false);
    }

    public boolean getManeuverLeftAllowed() {
        return getBit(maneuverLeftAllowed);
    }

    public void setManeuverLeftAllowed() {
        setBit(maneuverLeftAllowed, true);
    }

    public void clearManeuverLeftAllowed() {
        setBit(maneuverLeftAllowed, false);
    }

    public boolean getManeuverRightAllowed() {
        return getBit(maneuverRightAllowed);
    }

    public void setManeuverRightAllowed() {
        setBit(maneuverRightAllowed, true);
    }

    public void clearManeuverRightAllowed() {
        setBit(maneuverRightAllowed, false);
    }

    public boolean getManeuverUTurnAllowed() {
        return getBit(maneuverUTurnAllowed);
    }

    public void setManeuverUTurnAllowed() {
        setBit(maneuverUTurnAllowed, true);
    }

    public void clearManeuverUTurnAllowed() {
        setBit(maneuverUTurnAllowed, false);
    }

    public boolean getManeuverLeftTurnOnRedAllowed() {
        return getBit(maneuverLeftTurnOnRedAllowed);
    }

    public void setManeuverLeftTurnOnRedAllowed() {
        setBit(maneuverLeftTurnOnRedAllowed, true);
    }

    public void clearManeuverLeftTurnOnRedAllowed() {
        setBit(maneuverLeftTurnOnRedAllowed, false);
    }

    public boolean getManeuverRightTurnOnRedAllowed() {
        return getBit(maneuverRightTurnOnRedAllowed);
    }

    public void setManeuverRightTurnOnRedAllowed() {
        setBit(maneuverRightTurnOnRedAllowed, true);
    }

    public void clearManeuverRightTurnOnRedAllowed() {
        setBit(maneuverRightTurnOnRedAllowed, false);
    }

    public boolean getManeuverLaneChangeAllowed() {
        return getBit(maneuverLaneChangeAllowed);
    }

    public void setManeuverLaneChangeAllowed() {
        setBit(maneuverLaneChangeAllowed, true);
    }

    public void clearManeuverLaneChangeAllowed() {
        setBit(maneuverLaneChangeAllowed, false);
    }

    public boolean getManeuverNoStoppingAllowed() {
        return getBit(maneuverNoStoppingAllowed);
    }

    public void setManeuverNoStoppingAllowed() {
        setBit(maneuverNoStoppingAllowed, true);
    }

    public void clearManeuverNoStoppingAllowed() {
        setBit(maneuverNoStoppingAllowed, false);
    }

    public boolean getYieldAllwaysRequired() {
        return getBit(yieldAllwaysRequired);
    }

    public void setYieldAllwaysRequired() {
        setBit(yieldAllwaysRequired, true);
    }

    public void clearYieldAllwaysRequired() {
        setBit(yieldAllwaysRequired, false);
    }

    public boolean getGoWithHalt() {
        return getBit(goWithHalt);
    }

    public void setGoWithHalt() {
        setBit(goWithHalt, true);
    }

    public void clearGoWithHalt() {
        setBit(goWithHalt, false);
    }

    public boolean getCaution() {
        return getBit(caution);
    }

    public void setCaution() {
        setBit(caution, true);
    }

    public void clearCaution() {
        setBit(caution, false);
    }

    public boolean getReserved1() {
        return getBit(reserved1);
    }

    public void setReserved1() {
        setBit(reserved1, true);
    }

    public void clearReserved1() {
        setBit(reserved1, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AllowedManeuvers)) {
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
