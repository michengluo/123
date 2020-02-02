package com.cloverat.common;

/**
 * json返回
 *
 * @author cloverat 2019/6/11
 */
public class JSONResponse<T> {

    private int code;
    private String msg;
    private T data;

    public JSONResponse() {}

    public JSONResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JSONResponse(ErrorCode errorCode, T data) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = data;
    }

    public JSONResponse(T data) {
        this(GlobalErrorEnum.SUCCESS, data);
    }

    public JSONResponse(ErrorCode errorCode) {
        this(errorCode, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}