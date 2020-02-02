package com.cloverat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloverat.common.JSONResponse;

/**
 * 抽象控制器
 *
 * @author cloverat 2019/6/11
 */
public abstract class AbstractController {

    private static final String success = null;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected <T> JSONResponse<T> success(T result) {
        return new JSONResponse<>(result);
    }

    protected JSONResponse<String> success() {
        return success(success);
    }
}
