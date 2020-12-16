/*
 * Generated by ASN.1 Java Compiler (https://www.asnlab.org/)
 * From ASN.1 module "MapLane"
 */
package com.hisense.hiatmp.asn.v2x.MapNode;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.EncodingRules;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class Lane {

    public final static AsnType TYPE = MapNode.type(393260);
    public final static CompositeConverter CONV;

    static {
        CONV = new AnnotationCompositeConverter(Lane.class);
        AsnConverter laneIDConverter = LaneID.CONV;
        AsnConverter laneWidthConverter = LaneWidth.CONV;
        AsnConverter laneAttributesConverter = LaneAttributes.CONV;
        AsnConverter maneuversConverter = AllowedManeuvers.CONV;
        AsnConverter connectsToConverter = ConnectsToList.CONV;
        AsnConverter speedLimitsConverter = SpeedLimitList.CONV;
        AsnConverter pointsConverter = PointList.CONV;
        CONV.setComponentConverters(new AsnConverter[]{laneIDConverter, laneWidthConverter, laneAttributesConverter, maneuversConverter, connectsToConverter, speedLimitsConverter, pointsConverter});
    }

    @NotNull
    @Component(0)
    public Integer laneID;
    @Null
    @Component(1)
    public Integer laneWidth;    /* OPTIONAL */
    @Null
    @Component(2)
    public LaneAttributes laneAttributes;    /* OPTIONAL */
    @Null
    @Component(3)
    public AllowedManeuvers maneuvers;    /* OPTIONAL */
    @Null
    @Component(4)
    public Vector<Connection> connectsTo;    /* OPTIONAL */
    @Null
    @Component(5)
    public Vector<RegulatorySpeedLimit> speedLimits;    /* OPTIONAL */
    @Null
    @Component(6)
    public Vector<RoadPoint> points;    /* OPTIONAL */

    public static Lane ber_decode(InputStream in) throws IOException {
        return (Lane) TYPE.decode(in, EncodingRules.BASIC_ENCODING_RULES, CONV);
    }

    public static Lane per_decode(boolean align, InputStream in) throws IOException {
        return (Lane) TYPE.decode(in, align ? EncodingRules.ALIGNED_PACKED_ENCODING_RULES : EncodingRules.UNALIGNED_PACKED_ENCODING_RULES, CONV);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Lane)) {
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
