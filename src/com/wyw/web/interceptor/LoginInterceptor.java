package com.wyw.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description
 * @Author Wangyw
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(httpServletRequest.getServletPath().equals("/login")){
            return true;
        }else if(httpServletRequest.getSession().getAttribute("user")!= null){
            return true;
        }else{
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login");
            return false;
        }


    }
}
