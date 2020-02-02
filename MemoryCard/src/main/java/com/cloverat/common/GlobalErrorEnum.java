package com.cloverat.common;

/**
 * 全局错误码
 *
 * @author cloverat 2019/6/11
 */
public enum GlobalErrorEnum implements ErrorCode {

    /**
     * 正常
     */
    SUCCESS(200, ""),
    /**
     * param_error
     */
    PARAM_ERROR(400, "param_error"),
    /**
     * unknown_error
     */
    UNKNOWN_ERROR(500, "unknown_error"),
    /**
     * not_found
     */
    NOT_FOUND(404, "not_found"),
    /**
     * 超时
     */
    TIME_OUT(555, "超时"),
    /**
     * 请求方式错误
     */
    REQUEST_METHOD_ERROR(501, "请求方式错误"),
    /**
     * 分页参数错误
     */
    PAGE_PARAM_ERROR(502, "分页参数错误"),
    /**
     * 唯一性验证失败
     */
    UNIQUE_ERROR(503, "唯一性验证失败");

    private int code;
    private String msg;

    private GlobalErrorEnum(int code, String msg) {
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
