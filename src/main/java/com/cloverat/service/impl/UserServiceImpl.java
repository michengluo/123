package com.cloverat.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloverat.common.Constants;
import com.cloverat.common.GlobalErrorEnum;
import com.cloverat.common.MyErrorEnum;
import com.cloverat.common.exception.MyRuntimeException;
import com.cloverat.dao.UserDao;
import com.cloverat.domain.User;
import com.cloverat.dto.UserInfo;
import com.cloverat.dto.WeChatResp;
import com.cloverat.service.AbstractService;
import com.cloverat.service.UserService;
import com.cloverat.util.HttpUtil;

/**
 * 服务实现
 *
 * @author cloverat 2019/6/11
 */
@Service
@Component
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    private UserDao userDao;

    @Value("${wx.appId}")
    private String wxAppId;
    @Value("${wx.secret}")
    private String wxSecret;
    @Value("${qq.appId}")
    private String qqAppId;
    @Value("${qq.secret}")
    private String qqSecret;

    @Override
    public String login(UserInfo req) {
        logger.info("接口请求为：" + req.toString());
        String code = req.getCode();
        String openId = req.getOpenId();

        // 如果前端没有带openId过来，说明可能是第一次签到，或者关闭重开
        if (null == openId || "null".equals(openId) || "".equals(openId)) {
            // 通过微信接口获取openId
            WeChatResp weChatResp = getOpenId(code);
            if (null != weChatResp) {
                // TODO 可能存在code没刷新，获取到的openId为空
                if (null != weChatResp.getErrcode()) {
                    throw new MyRuntimeException(GlobalErrorEnum.UNKNOWN_ERROR);
                }
            }
            openId = weChatResp.getOpenid();
            logger.info("微信接口获取到的openId为：" + openId);
        }

        return openId;
    }

    @Override
    public UserInfo findByOpenId(UserInfo userInfo) {
        String platform = userInfo.getPlatform();
        User user;
        if (platform.equals(Constants.PLATFORM_WX)) {
            user = userDao.findByWxOpenId(userInfo.getOpenId());
        } else {
            user = userDao.findByQqOpenId(userInfo.getOpenId());
        }

        if (null != user) {
            user.setCode("");
            UserInfo result = new UserInfo(user);
            logger.info("检查录入接口返回为：" + result.toString());
            return result;
        } else {
            User tempUser = new User();
            tempUser.setCode("");
            // tempUser.setOpenId(openId);

            UserInfo result = new UserInfo(tempUser);
            logger.info("接口返回为：" + result.toString());
            return result;
        }
    }

    /**
     * 获取openId
     *
     * @param code code
     * @return openId
     */
    private WeChatResp getOpenId(String code) {
        try {
            String result =
                HttpUtil.doHttpGet("https://api.weixin.qq.com/sns/jscode2session?appid=" + wxAppId + "&secret="
                    + wxSecret + "&js_code=" + code + "&grant_type=authorization_code");
            logger.info("获取openId接口返回为：" + result);
            if (result != null) {
                JSONObject resultJson = JSON.parseObject(result);
                return JSON.toJavaObject(resultJson, WeChatResp.class);
            } else {
                return null;
            }
        } catch (IOException e) {
            logger.info(GlobalErrorEnum.UNKNOWN_ERROR.getMsg(), e);
        }

        return null;
    }

    @Override
    public int insertUser(UserInfo userInfo) {
        List<User> userList = userDao.listByCardNoAndQqNo(userInfo.getCardNo(), userInfo.getQqNo());
        if (null != userList && userList.size() == 1) {
            User user = userList.get(0);
            String platform = userInfo.getPlatform();
            if (platform.equals(Constants.PLATFORM_WX) && StringUtils.isEmpty(user.getWxOpenId())) {
                // 新增wx
                return userDao.updateWxOpenId(user.getUserId(), userInfo.getOpenId());
            }
            if (platform.equals(Constants.PLATFORM_QQ) && StringUtils.isEmpty(user.getQqOpenId())) {
                return userDao.updateQqOpenId(user.getUserId(), userInfo.getOpenId());
            }
        }

        userList = userDao.listByCardNo(userInfo.getCardNo());
        if (null != userList && userList.size() > 0) {
            throw new MyRuntimeException(MyErrorEnum.CARD_NO_EXIST);
        }
        User user = new User(userInfo);
        userDao.insert(user);
        return user.getUserId();
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        String platform = userInfo.getPlatform();
        User oldUser;
        if (platform.equals(Constants.PLATFORM_WX)) {
            oldUser = userDao.findByWxOpenId(userInfo.getOpenId());
        } else {
            oldUser = userDao.findByQqOpenId(userInfo.getOpenId());
        }
        String oldCardNo = oldUser.getCardNo();
        String newCardNo = userInfo.getCardNo();
        if (!oldCardNo.equals(newCardNo)) {
            List<User> userList = userDao.listByCardNo(newCardNo);
            if (null != userList && userList.size() > 0) {
                throw new MyRuntimeException(MyErrorEnum.CARD_NO_EXIST);
            }
        }

        User user = new User(userInfo);
        userDao.update(user);
    }

    @Override
    public String findByCardNo(String cardNo) {
        List<User> userList = userDao.listByCardNo(cardNo);
        if (null != userList) {
            return userList.get(0).getQqNo();
        } else {
            return null;
        }
    }
}
