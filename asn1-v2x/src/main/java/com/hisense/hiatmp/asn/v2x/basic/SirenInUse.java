package com.hisense.hiatmp.asn.v2x.basic;

/**
 * SirenInUse<br/>
 * SirenInUse ::= ENUMERATED {<br/>
 * unavailable (0), -- Not Equipped or unavailable<br/>
 * notInUse (1),<br/>
 * inUse (2),<br/>
 * reserved (3) -- for future use<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/9  22:32
 */
public enum SirenInUse {
    /**
     * -- Not Equipped or unavailable
     */
    unavailable(0),
    /**
     *
     */
    notInUse(1),
    /**
     *
     */
    inUse(2),
    /**
     * -- for future use
     */
    reserved(3);
    private int value;

    SirenInUse(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(value);
        return builder.toString();
    }
}
