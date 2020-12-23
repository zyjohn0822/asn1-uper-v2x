package com.hisense.hiatmp.asn.v2x.basic;

/**
 * TransmissionState ::= ENUMERATED {<br/>
 * neutral (0), -- Neutral<br/>
 * park (1), -- Park<br/>
 * forwardGears (2), -- Forward gears<br/>
 * reverseGears (3), -- Reverse gears<br/>
 * reserved1 (4),<br/>
 * reserved2 (5),<br/>
 * reserved3 (6),<br/>
 * unavailable (7)-- not-equipped or unavailable value,<br/>
 * -- Any related speed is relative to the vehicle reference frame used<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/19  12:16
 */
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

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
