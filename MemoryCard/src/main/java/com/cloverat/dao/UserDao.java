package com.cloverat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cloverat.domain.User;

/**
 * 人员dao
 *
 * @author cloverat 2019/6/11
 */
@Repository
public interface UserDao {

    /**
     * 获取人员列表
     *
     * @return 人员列表
     */
    List<User> list();

    /**
     * 根据id获取人员信息
     *
     * @param id 人员id
     * @return 人员信息
     */
    User findById(@Param("id") Integer id);

    /**
     * 根据卡号获取人员信息
     *
     * @param cardNo 卡code
     * @return 人员信息
     */
    List<User> listByCardNo(@Param("cardNo") String cardNo);

    /**
     * 根据卡号和QQ号获取人员信息
     *
     * @param cardNo 卡code
     * @param qqNo qqNo
     * @return 人员信息
     */
    List<User> listByCardNoAndQqNo(@Param("cardNo") String cardNo, @Param("qqNo") String qqNo);

    /**
     * 根据openId获取人员信息
     *
     * @param openId 人员openId
     * @return 人员信息
     */
    User findByWxOpenId(@Param("openId") String openId);
    User findByQqOpenId(@Param("openId") String openId);

    /**
     * 新增人员
     *
     * @param sign 人员信息
     * @return 新增结果
     */
    Integer insert(@Param("pojo") User sign);

    /**
     * 修改人员
     *
     * @param sign 人员信息
     * @return 新增结果
     */
    Integer update(@Param("pojo") User sign);

    /**
     * 删除人员
     *
     * @param id 人员id
     * @return 删除结果
     */
    Integer remove(@Param("id") Integer id);

    Integer updateWxOpenId(@Param("id") Integer id,@Param("openId") String openId);

    Integer updateQqOpenId(@Param("id") Integer id,@Param("openId") String openId);
}
