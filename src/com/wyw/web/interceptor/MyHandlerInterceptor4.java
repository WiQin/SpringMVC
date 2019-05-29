package com.wyw.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyHandlerInterceptor1
 * @Description
 * @Author Wangyw
 */
public class MyHandlerInterceptor4 extends HandlerInterceptorAdapter {

    ThreadLocal<Long> time = new ThreadLocal<Long>();

    //请求到达处理器前  true:放行  false:不放行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        long start = System.currentTimeMillis();
        time.set(start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        long finish = System.currentTimeMillis();
        System.out.println("耗时"+(finish-time.get()));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
