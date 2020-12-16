package com.hisense.hiatmp.asn.uper;

import com.hisense.hiatmp.asn.api.UperAsnProcess;
import com.hisense.hiatmp.asn.v2x.AsnV2x;
import com.hisense.hiatmp.asn.v2x.MsgFrame.MessageFrame;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhangyong
 * @date 2020/11/6  20:02
 */

public class UperDecoder implements UperAsnProcess {
    /**
     * 功能描述: <br>
     * <p>UPER ASN解码</p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     *
     * @param in     输入流
     * @param type   v2x消息
     * @param isUper 是否为uper编码 true为是uper，否则不是
     * @return: T
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/11/6 19:49
     */
    public AsnV2x decode(InputStream in, AsnV2x.Type type, boolean isUper) throws IOException {
        final MessageFrame messageFrame = MessageFrame.per_decode(!isUper, in);
        switch (type) {
            case BSM:
                return messageFrame.bsmFrame;
            case RSM:
                return messageFrame.rsmFrame;
            case SPAT:
                return messageFrame.spatFrame;
            case RSI:
                return messageFrame.rsiFrame;
            default:
                return null;
        }
    }
}
