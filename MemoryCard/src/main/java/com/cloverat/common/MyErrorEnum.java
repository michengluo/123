package com.cloverat.common;

/**
 * 错误码
 *
 * @author cloverat 2019/9/5
 */
public enum MyErrorEnum implements ErrorCode {

    /**
     * 卡号已存在
     */
    CARD_NO_EXIST(20001, "卡号已存在"),;

    private int code;
    private String msg;

    private MyErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
