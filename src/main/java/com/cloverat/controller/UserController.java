package com.cloverat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloverat.common.JSONResponse;
import com.cloverat.dto.UserInfo;
import com.cloverat.service.UserService;

/**
 * 信息API
 *
 * @author cloverat 2019/6/11
 */
@RestController
@RequestMapping("user")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    /**
     * 登陆
     *
     * @param userInfo 用户信息
     * @return openId
     */
    @PostMapping("login")
    public JSONResponse<String> login(@RequestBody UserInfo userInfo) {
        return success(userService.login(userInfo));
    }

    /**
     * 根据openId和平台类型获取用户信息
     *
     * @param userInfo userInfo
     * @return 用户信息
     */
    @PostMapping("findByOpenId")
    public JSONResponse<UserInfo> findByOpenId(@RequestBody UserInfo userInfo) {
        return success(userService.findByOpenId(userInfo));
    }

    /**
     * 根据新增卡号和联系方式
     *
     * @param userInfo userInfo
     * @return
     */
    @PostMapping("insert")
    public JSONResponse<Integer> insert(@RequestBody UserInfo userInfo) {
        return success(userService.insertUser(userInfo));
    }

    /**
     * 根据新增卡号，修改联系方式
     *
     * @param userInfo userInfo
     * @return
     */
    @PostMapping("update")
    public JSONResponse<?> update(@RequestBody UserInfo userInfo) {
        userService.updateUser(userInfo);
        return success();
    }

    /**
     * 根据卡号获取联系方式
     *
     * @param userInfo 卡号
     * @return 联系方式
     */
    @PostMapping("findByCardNo")
    public JSONResponse<String> findByCardNo(@RequestBody UserInfo userInfo) {
        return success(userService.findByCardNo(userInfo.getCardNo()));
    }
}
