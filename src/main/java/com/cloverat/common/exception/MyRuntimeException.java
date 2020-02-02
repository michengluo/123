package com.cloverat.common.exception;

import com.cloverat.common.ErrorCode;
import com.cloverat.common.GlobalErrorEnum;

/**
 * 自定义的运行时异常
 *
 * @author cloverat 2019/6/11
 */
public class MyRuntimeException extends RuntimeException {
    private ErrorCode response;

    public MyRuntimeException(ErrorCode response) {
        super(response.getMsg());
        this.response = response;
    }

    public MyRuntimeException(String message) {
        super(message);
        this.response = GlobalErrorEnum.UNKNOWN_ERROR;
    }

    public MyRuntimeException(Throwable cause) {
        super(cause);
        this.response = GlobalErrorEnum.UNKNOWN_ERROR;
    }

    public MyRuntimeException(ErrorCode response, Throwable cause) {
        super(response.getMsg(), cause);
        this.response = response;
    }

    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
        this.response = response;
    }

    public ErrorCode getResponse() {
        return response;
    }
}
