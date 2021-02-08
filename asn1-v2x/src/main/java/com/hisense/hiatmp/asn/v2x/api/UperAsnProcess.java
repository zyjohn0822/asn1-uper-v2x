package com.hisense.hiatmp.asn.v2x.api;

import com.hisense.hiatmp.asn.v2x.AsnV2x;

import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/23  21:24
 */
public interface UperAsnProcess {
    /**
     * 解析工具实现
     * @param in 输入流
     * @param type 消息的类型
     * @param isUper 是否uper编码
     * @return
     * @throws IOException
     */
    AsnV2x decode(byte[] in, AsnV2x.Type type, boolean isUper) throws IOException;
}
