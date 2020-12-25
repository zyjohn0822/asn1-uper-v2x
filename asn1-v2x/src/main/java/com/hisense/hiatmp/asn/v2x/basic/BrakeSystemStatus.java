package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.*;

import java.util.List;

/**
 * VehBrake DEFINITIONS AUTOMATIC TAGS ::= BEGIN<br/>
 * <p>
 * -- imports and exports<br/>
 * <p>
 * EXPORTS BrakeSystemStatus;<br/>
 * IMPORTS ;<br/>
 * <p>
 * BrakeSystemStatus ::= SEQUENCE {<br/>
 * brakePadel BrakePedalStatus OPTIONAL,<br/>
 * wheelBrakes BrakeAppliedStatus OPTIONAL,<br/>
 * traction TractionControlStatus OPTIONAL,<br/>
 * abs AntiLockBrakeStatus OPTIONAL,<br/>
 * scs StabilityControlStatus OPTIONAL,<br/>
 * brakeBoost BrakeBoostApplied OPTIONAL,<br/>
 * auxBrakes AuxiliaryBrakeStatus OPTIONAL<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/11/4  19:12
 */
@Sequence
@Setter
@Getter
public class BrakeSystemStatus {
    @Component(0)
    @Asn1Optional
    public BrakePedalStatus brakePadel;
    @Component(1)
    @Asn1Optional
    public BrakeAppliedStatus wheelBrakes;
    @Component(2)
    @Asn1Optional
    public TractionControlStatus traction;
    @Component(3)
    @Asn1Optional
    public AntiLockBrakeStatus abs;
    @Component(4)
    @Asn1Optional
    public StabilityControlStatus scs;
    @Component(5)
    @Asn1Optional
    public BrakeBoostApplied brakeBoost;
    @Component(6)
    @Asn1Optional
    public AuxiliaryBrakeStatus auxBrakes;

    public BrakeSystemStatus() {
    }

    public BrakeSystemStatus(
            BrakePedalStatus brakePadel,
            BrakeAppliedStatus wheelBrakes,
            TractionControlStatus traction,
            AntiLockBrakeStatus abs,
            StabilityControlStatus scs,
            BrakeBoostApplied brakeBoost,
            AuxiliaryBrakeStatus auxBrakes
    ) {
        this.brakePadel = brakePadel;
        this.wheelBrakes = wheelBrakes;
        this.traction = traction;
        this.abs = abs;
        this.scs = scs;
        this.brakeBoost = brakeBoost;
        this.auxBrakes = auxBrakes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"brakePadel\":")
                .append(brakePadel);
        sb.append(",\"wheelBrakes\":")
                .append(wheelBrakes);
        sb.append(",\"traction\":")
                .append(traction);
        sb.append(",\"abs\":")
                .append(abs);
        sb.append(",\"scs\":")
                .append(scs);
        sb.append(",\"brakeBoost\":")
                .append(brakeBoost);
        sb.append(",\"auxBrakes\":")
                .append(auxBrakes);
        sb.append('}');
        return sb.toString();
    }

    /**
     * BrakePedalStatus ::= ENUMERATED {
     * unavailable (0), -- Vehicle brake pedal detector is unavailable
     * off (1), -- Vehicle's brake pedal is not pressed
     * on (2) -- Vehicle's brake pedal is pressed
     * }
     */
    public enum BrakePedalStatus {
        /**
         * -- Vehicle brake pedal detector is unavailable
         */
        unavailable(0),
        /**
         * -- Vehicle's brake pedal is not pressed
         */
        off(1),
        /**
         * -- Vehicle's brake pedal is pressed
         */
        on(2);
        private final int value;

        BrakePedalStatus(int value) {
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
     * TractionControlStatus ::= ENUMERATED {
     * unavailable (0), -- Not Equipped with traction control
     * -- or traction control status is unavailable
     * off (1), -- traction control is Off
     * on (2), -- traction control is On (but not Engaged)
     * engaged (3) -- traction control is Engaged
     * }
     */
    public enum TractionControlStatus {
        /**
         * -- Not Equipped with traction control
         * -- or traction control status is unavailable
         */
        unavailable(0),
        /**
         * -- traction control is Off
         */
        off(1),
        /**
         * -- traction control is On (but not Engaged)
         */
        on(2),
        /**
         * -- traction control is Engaged
         */
        engaged(3);

        private final int value;

        private TractionControlStatus(int value) {
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
     * AntiLockBrakeStatus ::= ENUMERATED {
     * unavailable (0), -- Vehicle Not Equipped with ABS Brakes
     * -- or ABS Brakes status is unavailable
     * off (1), -- Vehicle's ABS are Off
     * on (2), -- Vehicle's ABS are On ( but not Engaged )
     * engaged (3) -- Vehicle's ABS control is Engaged on any wheel
     * }
     */
    public enum AntiLockBrakeStatus {
        /**
         * -- Vehicle Not Equipped with ABS Brakes
         * -- or ABS Brakes status is unavailable
         */
        unavailable(0),

        /**
         * -- Vehicle's ABS are Off
         */
        off(1),
        /**
         * -- Vehicle's ABS are On ( but not Engaged )
         */
        on(2),
        /**
         * -- Vehicle's ABS control is Engaged on any wheel
         */
        engaged(3);
        private final int value;

        AntiLockBrakeStatus(int value) {
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
     * StabilityControlStatus ::= ENUMERATED {
     * unavailable (0), -- Not Equipped with SC
     * -- or SC status is unavailable
     * off (1), -- Off
     * on (2), -- On or active (but not engaged)
     * engaged (3) -- stability control is Engaged
     * }
     */
    public enum StabilityControlStatus {
        /**
         * -- Not Equipped with SC
         * -- or SC status is unavailable
         */
        unavailable(0),

        /**
         * -- Off
         */
        off(1),
        /**
         * -- On or active (but not engaged)
         */
        on(2),
        /**
         * -- stability control is Engaged
         */
        engaged(3);

        private final int value;

        StabilityControlStatus(int value) {
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
     * BrakeBoostApplied ::= ENUMERATED {
     * unavailable (0), -- Vehicle not equipped with brake boost
     * -- or brake boost data is unavailable
     * off (1), -- Vehicle's brake boost is off
     * on (2) -- Vehicle's brake boost is on (applied)
     * }
     */
    public enum BrakeBoostApplied {
        /**
         * -- Vehicle not equipped with brake boost
         */
        unavailable(0),
        /**
         * -- or brake boost data is unavailable
         * -- Vehicle's brake boost is off
         */

        off(1),

        /**
         * -- Vehicle's brake boost is on (applied)
         */
        on(2);
        private final int value;

        BrakeBoostApplied(int value) {
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
     * AuxiliaryBrakeStatus ::= ENUMERATED {
     * unavailable (0), -- Vehicle Not Equipped with Aux Brakes
     * -- or Aux Brakes status is unavailable
     * off (1), -- Vehicle's Aux Brakes are Off
     * on (2), -- Vehicle's Aux Brakes are On ( Engaged )
     * reserved (3)
     * }
     */

    public enum AuxiliaryBrakeStatus {
        /**
         * -- Vehicle Not Equipped with Aux Brakes
         * -- or Aux Brakes status is unavailable
         */
        unavailable(0),

        /**
         * -- Vehicle's Aux Brakes are Off
         */
        off(1),
        /**
         * -- Vehicle's Aux Brakes are On ( Engaged )
         */
        on(2),
        /**
         *
         */
        reserved(3);
        private final int value;

        AuxiliaryBrakeStatus(int value) {
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
     * BrakeAppliedStatus ::= BIT STRING {
     * unavailable (0), -- When set, the brake applied status is unavailable
     * leftFront (1), -- Left Front Active
     * leftRear (2), -- Left Rear Active
     * rightFront (3), -- Right Front Active
     * rightRear (4) -- Right Rear Active
     * } (SIZE (5))
     */
    @SizeRange(minValue = 5, maxValue = 5)
    public static class BrakeAppliedStatus extends Asn1SequenceOf<Boolean> {
        public BrakeAppliedStatus() {
            super();
        }

        public BrakeAppliedStatus(List<Boolean> cols) {
            super(cols);
        }

        public boolean getOrFalse(int i) {
            return (i < size()) ? get(i) : false;
        }

        public boolean unavailable() {
            return getOrFalse(0);
        }

        public boolean leftFront() {
            return getOrFalse(1);
        }

        public boolean leftRear() {
            return getOrFalse(2);
        }

        public boolean rightFront() {
            return getOrFalse(3);
        }

        public boolean rightRear() {
            return getOrFalse(4);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("\"");
            for (boolean s : bakingList) {
                if (s) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            sb.append("\"");
            return sb.toString();
        }

    }
}
