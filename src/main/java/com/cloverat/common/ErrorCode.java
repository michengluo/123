package com.cloverat.common;

/**
 * 错误码接口
 *
 * @author cloverat 2019/6/11
 */
public interface ErrorCode {

    /**
     * 获取code
     *
     * @return code
     */
    int getCode();

    /**
     * 获取msg
     *
     * @return msg
     */
    String getMsg();
}