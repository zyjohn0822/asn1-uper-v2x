package com.hisense.hiatmp.asn.v2x.api;

import com.hisense.hiatmp.asn.v2x.AsnV2x;

import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/23  21:24
 */
public interface UperAsnProcess {
    /**
     * 功能描述: <br>
     * <p>UPER ASN解码</p>
     * 修改描述: <br>
     * <p>修改人:</p>
     * <p>修改原因:</p>
     *
     * @param in     输入流
     * @param type   v2x消息类型
     * @param isUper 是否为uper编码 true为是uper，否则不是
     * @return: T
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/11/6 19:49
     */
    AsnV2x decode(byte[] in, AsnV2x.Type type, boolean isUper) throws IOException;
}
