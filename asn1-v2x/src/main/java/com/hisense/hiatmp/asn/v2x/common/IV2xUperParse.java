package com.hisense.hiatmp.asn.v2x.common;

/**
 * @author zhangyong
 * @date 2020/12/23  18:56
 */
public interface IV2xUperParse {
    /**
     * 功能描述: <br>
     * <p></p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 18:59
     */
    MessageContainer spatParse(String message);
    /**
     * 功能描述: <br>
     * <p></p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    MessageContainer bsmParse(String message);
    /**
     * 功能描述: <br>
     * <p></p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    MessageContainer rsmParse(String message);
    /**
     * 功能描述: <br>
     * <p></p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    MessageContainer rsiParse(String message);
    /**
     * 功能描述: <br>
     * <p></p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    MessageContainer mapParse(String message);
}
