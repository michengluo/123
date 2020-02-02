package com.cloverat.dto;

import lombok.Data;

/**
 * 微信返回对象
 *
 * @author cloverat 2019/6/11
 */
@Data
public class WeChatResp {

    /**
     * 用户唯一标识
     */
    private String openid;
    /**
     * 会话密钥
     */
    private String session_key;
    /**
     * 用户在开放平台的唯一标识符
     */
    private String unionid;
    /**
     * 错误码
     */
    private Integer errcode;
    /**
     * 错误信息
     */
    private String errmsg;
}
