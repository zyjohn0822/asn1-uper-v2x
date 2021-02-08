package com.hisense.hiatmp.asn.v2x.common;

/**
 * @author zhangyong
 * @date 2020/12/23  18:56
 */
public interface IV2xUperParse {
    /**
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 18:59
     */
    MessageContainer spatParse(String message);

    /**
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    MessageContainer bsmParse(String message);

    /**
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    MessageContainer rsmParse(String message);

    /**
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    MessageContainer rsiParse(String message);

    /**
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    MessageContainer mapParse(String message);
}
