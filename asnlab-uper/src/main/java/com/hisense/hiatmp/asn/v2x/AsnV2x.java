package com.hisense.hiatmp.asn.v2x;

import java.io.Serializable;

/**
 * 为V2X消息提供统一抽象
 *
 * @author zhangyong
 * @date 2020/11/6  19:53
 */
public interface AsnV2x extends Serializable {
    enum Type {
        /**
         * BSM
         */
        BSM,
        /**
         * RSM
         */
        RSM,
        /**
         * RSI
         */
        RSI,
        /**
         * SPAT
         */
        SPAT,
        /**
         * MAP
         */
        MAP
    }
}
