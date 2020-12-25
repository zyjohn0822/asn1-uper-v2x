package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

/**
 * PhaseState ::= SEQUENCE {<br/>
 * light LightState,<br/>
 * -- Consisting of:<br/>
 * -- Phase state (the basic 11 states)<br/>
 * -- Directional, protected, or permissive state<br/>
 * timing TimeChangeDetails OPTIONAL,<br/>
 * -- Timing Data in UTC time stamps for event<br/>
 * -- includes start and min/max end times of phase<br/>
 * -- confidence and estimated next occurrence<br/>
 * ...<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/21  11:57
 */
@Setter
@Getter
@Sequence
@HasExtensionMarker
public class PhaseState {
    @Component(0)
    public LightState light;
    @Component(1)
    @Asn1Optional
    public TimeChangeDetails timing;

    public PhaseState() {
    }

    public PhaseState(LightState light, TimeChangeDetails timing) {
        this.light = light;
        this.timing = timing;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"light\":")
                .append(light);
        sb.append(",\"timing\":")
                .append(timing);
        sb.append('}');
        return sb.toString();
    }

    /**
     * LightState ::= ENUMERATED {<br/>
     * unavailable (0),<br/>
     * -- This state is used for unknown or error<br/>
     * dark (1),<br/>
     * -- The signal is dark (unlit)<br/>
     * <p>
     * -- Reds<br/>
     * flashing-red (2),<br/>
     * -- Reserved for special scenarios<br/>
     * red (3),<br/>
     * -- Driver Action:<br/>
     * -- Stop vehicle at stop line.<br/>
     * -- Do not proceed.<br/>
     * <p>
     * -- Greens<br/>
     * flashing-green (4),<br/>
     * -- Reserved for special scenarios<br/>
     * permissive-green (5),<br/>
     * -- Driver Action:<br/>
     * -- Proceed with caution,<br/>
     * -- must yield to all conflicting traffic<br/>
     * -- Conflicting traffic may be present<br/>
     * -- in the intersection conflict area<br/>
     * protected-green (6),<br/>
     * -- Driver Action:<br/>
     * -- Proceed, tossing caution to the wind,<br/>
     * -- in indicated (allowed) direction.<br/>
     * <p>
     * -- Yellows / Ambers <br/>
     * -- The vehicle is not allowed to cross the stop bar if it is possible<br/>
     * -- to stop without danger.<br/>
     * yellow (7),<br/>
     * -- Driver Action:<br/>
     * -- Prepare to stop.<br/>
     * -- Proceed if unable to stop,<br/>
     * -- in indicated direction (to connected lane)<br/>
     * -- Clear Intersection.<br/>
     * <p>
     * flashing-yellow (8),<br/>
     * -- Driver Action:<br/>
     * -- Proceed with caution,<br/>
     * -- Conflicting traffic may be present<br/>
     * -- in the intersection conflict area<br/>
     * <p>
     * ...<br/>
     * }<br/>
     */
    @HasExtensionMarker
    public enum LightState {
        unavailable(0),
        dark(1),
        flashing_red(2),
        red(3),
        flashing_green(4),
        permissive_green(5),
        protected_green(6),
        yellow(7),
        flashing_yellow(8);
        private final int value;

        private LightState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

    }

    /**
     * TimeChangeDetails ::= CHOICE {<br/>
     * counting TimeCountingDown,<br/>
     * utcTiming UTCTiming,<br/>
     * ...<br/>
     * }<br/>
     */
    @Getter
    @Setter
    @Choice
    @HasExtensionMarker
    public static class TimeChangeDetails {
        public TimeCountingDown counting;
        public UTCTiming utcTiming;

        public TimeChangeDetails() {
        }

        public TimeChangeDetails(TimeCountingDown counting, UTCTiming utcTiming) {
            this.counting = counting;
            this.utcTiming = utcTiming;
        }

        public static TimeChangeDetails counting(TimeCountingDown counting) {
            return new TimeChangeDetails(counting, null);
        }

        public static TimeChangeDetails utcTiming(UTCTiming utcTiming) {
            return new TimeChangeDetails(null, utcTiming);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"counting\":")
                    .append(counting);
            sb.append(",\"utcTiming\":")
                    .append(utcTiming);
            sb.append('}');
            return sb.toString();
        }
    }
}
