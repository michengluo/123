package com.cloverat.service;

import com.cloverat.dto.UserInfo;

/**
 * 服务
 *
 * @author cloverat 2019/6/11
 */
public interface UserService {

    /**
     * 登陆
     *
     * @param req 登陆
     * @return 登陆
     */
    String login(UserInfo req);

    /**
     * 根据openId和平台获取用户信息
     *
     * @param userInfo userInfo
     * @return 用户信息
     */
    UserInfo findByOpenId(UserInfo userInfo);

    /**
     * 新增人员
     *
     * @param userInfo 人员信息
     * @return 新增结果
     */
    int insertUser(UserInfo userInfo);

    /**
     * 修改人员
     *
     * @param userInfo 人员信息
     */
    void updateUser(UserInfo userInfo);

    /**
     * 根据卡号获取联系方式
     *
     * @param cardNo 卡号
     * @return 联系方式 - QQ
     */
    String findByCardNo(String cardNo);
}
