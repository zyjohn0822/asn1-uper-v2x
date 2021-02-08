package com.hisense.hiatmp.asn.v2x.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.hisense.hiatmp.asn.v2x.common.Utils.hexStringToString;

/**
 * @author zhangyong
 * @date 2020/12/23  19:02
 */
public class Parse implements IV2xUperParse{
    private static final Logger logger = LoggerFactory.getLogger(Parse.class);
    /**
     * @description: <br>
     * <p></p>
     * <br>
     * <p></p>
     * <p></p>
     *
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 18:59
     */
    @Override
    public MessageContainer spatParse(String message) {
        return null;
    }

    /**
     * @description:<br>
     *
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    @Override
    public MessageContainer bsmParse(String message) {
        try{
            String rsuId = getRsuId(message);
            long timestamp = getTimestamp(message);

        }catch (Exception e){
            logger.error("BSM��������!" + e.getMessage());
        }


        return null;
    }

    private long getTimestamp(String message) throws Exception {
        String time = message.substring(16, 32);
        return Long.parseLong(Utils.hexLowerSort(time), 16);
    }

    /**
     * @description: <br>
     *
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    @Override
    public MessageContainer rsmParse(String message) {
        return null;
    }

    /**
     * @description: <br>
     * <p></p>
     * �޸�����: <br>
     * <p>�޸���:</p>
     * <p>�޸�ԭ��:</p>
     *
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    @Override
    public MessageContainer rsiParse(String message) {
        return null;
    }

    /**
     * @description: <br>
     * <p></p>
     *
     * @param message hex
     * @return: com.hisense.hiatmp.asn.v2x.common.MessageContainer
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:00
     */
    @Override
    public MessageContainer mapParse(String message) {
        return null;
    }
    /**
     * @description: <br>
     * <p></p>
     * @param message
     * @return: java.lang.String
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:06
     */
    private String getRsuId(String message){
        return hexStringToString(message.substring(0, 16))
                .replaceAll("\u0000", "");
    }
}
