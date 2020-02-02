package com.cloverat.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器,拦截请求，preHandle中判断操作权限，afterCompletion中记录操作日志
 *
 * @author cloverat 2019/6/11
 */
public class RequestInterceptor implements HandlerInterceptor {

    private String uri;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        Object handler) {
        uri = httpServletRequest.getRequestURI();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        Object handler, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
