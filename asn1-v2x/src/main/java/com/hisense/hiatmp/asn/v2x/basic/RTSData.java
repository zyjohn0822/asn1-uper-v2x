package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * RTSData ::= SEQUENCE {<br/>
 * rtsId INTEGER (0..255),<br/>
 * -- local ID of this rts information set by RSU<br/>
 * signType SignType,<br/>
 * -- Type of sign, according to China GB 5768.2<br/>
 * signPos PositionOffsetLLV OPTIONAL,<br/>
 * -- Position of the traffic sign, if exists<br/>
 * description Description OPTIONAL,<br/>
 * -- Additional description to the sign<br/>
 * timeDetails RSITimeDetails OPTIONAL,<br/>
 * -- start time or end time when this sign is active, if existed<br/>
 * priority RSIPriority OPTIONAL,<br/>
 * -- the urgency of this RSI data, a relative<br/>
 * -- degree of merit compared with other RSI data<br/>
 * referencePaths ReferencePathList OPTIONAL,<br/>
 * -- Related paths of this traffic sign<br/>
 * referenceLinks ReferenceLinkList OPTIONAL,<br/>
 * -- Related links of this traffic sign<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/22  19:03
 */
@Getter
@Setter
@Sequence
@HasExtensionMarker
public class RTSData {
    @Component(0)
    public RtsId rtsId;
    @Component(1)
    public SignType signType;
    @Component(2)
    @Asn1Optional
    public PositionOffsetLLV signPos;
    @Component(3)
    @Asn1Optional
    public Description description;
    @Component(4)
    @Asn1Optional
    public RSITimeDetails timeDetails;
    @Component(5)
    @Asn1Optional
    public RSIPriority priority;
    @Component(6)
    @Asn1Optional
    public ReferencePathList referencePaths;
    @Component(7)
    @Asn1Optional
    public ReferenceLinkList referenceLinks;

    public RTSData() {
    }

    public RTSData(RtsId rtsId,
                   SignType signType,
                   PositionOffsetLLV signPos,
                   Description description,
                   RSITimeDetails timeDetails,
                   RSIPriority priority,
                   ReferencePathList referencePaths,
                   ReferenceLinkList referenceLinks) {
        this.rtsId = rtsId;
        this.signType = signType;
        this.signPos = signPos;
        this.description = description;
        this.timeDetails = timeDetails;
        this.priority = priority;
        this.referencePaths = referencePaths;
        this.referenceLinks = referenceLinks;
    }

    /**
     * rtsId INTEGER (0..255)
     */
    @IntRange(minValue = 0, maxValue = 255)
    public static class RtsId extends Asn1Integer {
        public RtsId() {
            this(0);
        }

        public RtsId(int value) {
            super(value);
        }
    }

    /**
     * SignType ::= INTEGER (0..65535)<br/>
     * -- Traffic sign type according to China GB 5768.2<br/>
     * -- Text message warning = 0<br/>
     * -- Danger = 37<br/>
     * -- Rockfall = 15<br/>
     * -- SharpTurn = 2<br/>
     * -- UnderConstruction = 38<br/>
     * -- Slippy = 17<br/>
     * -- Tunnel = 21<br/>
     */
    @IntRange(minValue = 0, maxValue = 65535)
    public static class SignType extends Asn1Integer {
        public SignType() {
            this(0);
        }

        public SignType(long value) {
            super(value);
        }
    }
}
