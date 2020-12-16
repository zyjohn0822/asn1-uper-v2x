package com.hisense.hiatmp.asn.v2x.basic;

/**
 * @author zhangyong
 * @date 2020/11/5  12:49
 */
public class VehStatus {

    public enum TransmissionState {
        /**
         * -- Neutral
         */
        neutral(0),
        /**
         * -- Park
         */
        park(1),
        /**
         * -- Forward gears
         */
        forwardGears(2),
        /**
         * -- Reverse gears
         */
        reverseGears(3),
        /**
         *
         */
        reserved1(4),
        /**
         *
         */
        reserved2(5),
        /**
         *
         */
        reserved3(6),
        /**
         * -- not-equipped or unavailable value,
         */
        unavailable(7);

        private final int value;

        TransmissionState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
