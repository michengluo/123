package com.cloverat.domain;

import com.cloverat.dto.UserInfo;

import java.sql.Timestamp;

import lombok.Data;

/**
 * 人员信息
 *
 * @author cloverat 2019/6/11
 */
@Data
public class User {

    public User() {
    }

    public User(UserInfo userInfo) {
        if (null != userInfo) {
            this.userId = userInfo.getId();
            this.wxOpenId = userInfo.getWxOpenId();
            this.qqOpenId = userInfo.getQqOpenId();
            this.code = userInfo.getCode();
            this.cardNo = userInfo.getCardNo();
            this.qqNo = userInfo.getQqNo();
            this.schoolCode = userInfo.getSchoolCode();
        }
    }

    /**
     * ID
     */
    private Integer userId;
    /**
     * 微信openId
     */
    private String wxOpenId;
    /**
     * QQopenId
     */
    private String qqOpenId;
    /**
     * 微信code
     */
    private String code;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * QQ
     */
    private String qqNo;
    /**
     * 学校代号
     */
    private String schoolCode;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
}
