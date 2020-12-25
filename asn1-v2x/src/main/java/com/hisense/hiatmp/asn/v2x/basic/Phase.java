package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Phase ::= SEQUENCE{<br/>
 * id PhaseID,<br/>
 * -- the group id is used to map to lists<br/>
 * -- of lanes (and their descriptions)<br/>
 * -- which this MovementState data applies to<br/>
 * -- see comments in the Remarks for usage details<br/>
 * phaseStates PhaseStateList<br/>
 * -- Consisting of sets of movement data with:<br/>
 * -- a) SignalPhaseState<br/>
 * -- b) TimeChangeDetails, and<br/>
 * -- c) AdvisorySpeeds (optional )<br/>
 * -- Note one or more of the movement events may be for<br/>
 * -- a future time and that this allows conveying multiple<br/>
 * -- predictive phase and movement timing for various uses<br/>
 * -- for the current signal group<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/21  10:40
 */
@Getter
@Setter
@Sequence
public class Phase {
    @Component(0)
    public PhaseID id;
    @Component(1)
    public PhaseStateList phaseStates;

    public Phase() {
    }

    public Phase(PhaseID id, PhaseStateList phaseStates) {
        this.id = id;
        this.phaseStates = phaseStates;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"phaseStates\":")
                .append(phaseStates);
        sb.append('}');
        return sb.toString();
    }

    /**
     * PhaseID ::= INTEGER (0..255)<br/>
     * -- The value 0 shall be used when the ID is<br/>
     * -- not available or not known<br/>
     * -- the value 255 is reserved to indicate a<br/>
     * -- permanent green movement state<br/>
     * -- therefore a simple 8 phase signal controller<br/>
     * -- device might use 1..9 as its groupIDs<br/>
     */
    @IntRange(minValue = 0, maxValue = 255)
    public static class PhaseID extends Asn1Integer {
        public PhaseID() {
            this(0);
        }

        public PhaseID(int value) {
            super(value);
        }
    }

    /**
     * PhaseStateList ::= SEQUENCE (SIZE(1..16)) OF PhaseState
     */
    @SizeRange(minValue = 1, maxValue = 16)
    public static class PhaseStateList extends Asn1SequenceOf<PhaseState> {
        public PhaseStateList(PhaseState... phaseStates) {
            this(Arrays.asList(phaseStates));
        }

        public PhaseStateList(Collection<PhaseState> coll) {
            super(coll);
        }
    }
}
