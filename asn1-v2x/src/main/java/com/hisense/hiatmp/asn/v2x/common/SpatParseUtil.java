package com.hisense.hiatmp.asn.v2x.common;


import com.hisense.hiatmp.asn.v2x.SPAT;
import net.gcdc.asn1.uper.UperEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @description: //取开头的RsuiD并且转换为字符串
 * String rsuids = s.substring(0, 16);
 * String rsuid = HexUtils.hexStringToString(rsuids);
 * @author: r_k
 * @date: 2020/11/13 14:05
 * @version: v1.0
 */
public class SpatParseUtil {
    private static final Logger logger = LoggerFactory.getLogger(SpatParseUtil.class);

    /**
     * 功能描述: <br>
     * <p></p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     *
     * @param message
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 23:28
     */
    public static MessageContainer spatParse(String message) {
        String spats = message.substring(36);
        SPAT spat = null;
        try {
            spat = UperEncoder.decode(Utils.bytesFromHexString(spats), SPAT.class);
        } catch (Exception e) {
            logger.error("spat解析错误" + e.getCause());
        }
        return null;
    }
}
