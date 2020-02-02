package com.cloverat.dto;

import com.cloverat.domain.User;

import java.sql.Timestamp;

import lombok.Data;

/**
 * 人员信息
 *
 * @author cloverat 2019/6/11
 */
@Data
public class UserInfo {

    public UserInfo() {
    }

    public UserInfo(User user) {
        if (null != user) {
            this.id = user.getUserId();
            this.wxOpenId = user.getWxOpenId();
            this.qqOpenId = user.getQqOpenId();
            this.code = user.getCode();
            this.cardNo = user.getCardNo();
            this.qqNo = user.getQqNo();
            this.schoolCode = user.getSchoolCode();
        }
    }

    /**
     * id
     */
    private Integer id;
    /**
     * openId
     */
    private String openId;
    /**
     * openId
     */
    private String wxOpenId;
    /**
     * openId
     */
    private String qqOpenId;
    /**
     * code
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
    /**
     * 登陆平台，wx、qq
     */
    private String platform;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
}
