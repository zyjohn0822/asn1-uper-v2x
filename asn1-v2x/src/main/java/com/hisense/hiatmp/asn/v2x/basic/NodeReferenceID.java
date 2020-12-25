package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * NodeReferenceID ::= SEQUENCE {<br/>
 * region RoadRegulatorID OPTIONAL,<br/>
 * -- a globally unique regional assignment value<br/>
 * -- typical assigned to a regional DOT authority<br/>
 * -- the value zero shall be used for testing needs<br/>
 * id NodeID<br/>
 * -- a unique mapping to the node<br/>
 * -- in question within the above region of use<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/21  10:31
 */
@Getter
@Setter
@Sequence
public class NodeReferenceID {
    @Component(0)
    @Asn1Optional
    public RoadRegulatorID region;
    @Component(1)
    public NodeID id;

    public NodeReferenceID() {
    }

    public NodeReferenceID(RoadRegulatorID region, NodeID id) {
        this.region = region;
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"region\":")
                .append(region);
        sb.append(",\"id\":")
                .append(id);
        sb.append('}');
        return sb.toString();
    }

    /**
     * RoadRegulatorID ::= INTEGER (0..65535)<br/>
     * -- The value zero shall be used for testing only
     */
    @IntRange(minValue = 0, maxValue = 65535)
    public static class RoadRegulatorID extends Asn1Integer {
        public RoadRegulatorID() {
            this(0);
        }

        public RoadRegulatorID(int value) {
            super(value);
        }
    }

    /**
     * NodeID ::= INTEGER (0..65535)<br/>
     * -- The values zero through 255 are allocated for testing purposes<br/>
     * -- Note that the value assigned to a node will be<br/>
     * -- unique within a given regional ID only<br/>
     */
    @IntRange(minValue = 0, maxValue = 65535)
    public static class NodeID extends Asn1Integer {
        public NodeID() {
            this(0);
        }

        public NodeID(int value) {
            super(value);
        }
    }
}
