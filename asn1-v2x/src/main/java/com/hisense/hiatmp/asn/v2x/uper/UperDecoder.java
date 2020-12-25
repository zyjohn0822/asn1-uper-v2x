package com.hisense.hiatmp.asn.v2x.uper;

import com.hisense.hiatmp.asn.v2x.AsnV2x;
import com.hisense.hiatmp.asn.v2x.MessageFrame;
import com.hisense.hiatmp.asn.v2x.api.UperAsnProcess;
import net.gcdc.asn1.uper.UperEncoder;

import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/11/6  20:02
 */

public class UperDecoder implements UperAsnProcess {
    /**
     * 功能描述: <br>
     * <p></p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     * @param in
	 * @param type
	 * @param isUper
     * @return: com.hisense.hiatmp.asn.v2x.AsnV2x
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 23:28
     */
    public AsnV2x decode(byte[] in, AsnV2x.Type type, boolean isUper) throws IOException {
        final MessageFrame messageFrame = UperEncoder.decode(in, MessageFrame.class);
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
