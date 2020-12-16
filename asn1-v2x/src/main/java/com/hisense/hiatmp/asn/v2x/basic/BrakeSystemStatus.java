package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.Sequence;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.List;

/**
 * @author zhangyong
 * @date 2020/11/4  19:12
 */
@Sequence
@Setter
@Getter
public class BrakeSystemStatus {
    @Asn1Optional
    BrakePedalStatus brakePadel;
    @Asn1Optional
    BrakeAppliedStatus wheelBrakes;
    @Asn1Optional
    TractionControlStatus traction;
    @Asn1Optional
    AntiLockBrakeStatus abs;
    @Asn1Optional
    StabilityControlStatus scs;
    @Asn1Optional
    BrakeBoostApplied brakeBoost;
    @Asn1Optional
    AuxiliaryBrakeStatus auxBrakes;

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
    }

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
    }

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
    }

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
    }

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
    }

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
    }

    @SizeRange(minValue = 5, maxValue = 5, hasExtensionMarker = true)
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

    }
}
