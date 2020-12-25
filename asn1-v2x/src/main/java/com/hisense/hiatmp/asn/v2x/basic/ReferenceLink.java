package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * ReferenceLink ::= SEQUENCE {<br/>
 * -- this Link is from Node of upstreamNodeId to Node of downstreamNodeId<br/>
 * upstreamNodeId NodeReferenceID,<br/>
 * downstreamNodeId NodeReferenceID,<br/>
 * referenceLanes ReferenceLanes OPTIONAL<br/>
 * -- Provide reference lanes if is necessary<br/>
 * -- Refer to all lanes if this data is not given<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/23  11:26
 */
@Setter
@Getter
@Sequence
public class ReferenceLink {
    public NodeReferenceID upstreamNodeId;
    public NodeReferenceID downstreamNodeId;
    @Asn1Optional
    public ReferenceLanes referenceLanes;

    public ReferenceLink() {

    }

    public ReferenceLink(NodeReferenceID upstreamNodeId, NodeReferenceID downstreamNodeId, ReferenceLanes referenceLanes) {
        this.upstreamNodeId = upstreamNodeId;
        this.downstreamNodeId = downstreamNodeId;
        this.referenceLanes = referenceLanes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"upstreamNodeId\":")
                .append(upstreamNodeId);
        sb.append(",\"downstreamNodeId\":")
                .append(downstreamNodeId);
        sb.append(",\"referenceLanes\":")
                .append(referenceLanes);
        sb.append('}');
        return sb.toString();
    }
}
