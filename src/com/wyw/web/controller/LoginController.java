package com.wyw.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginController
 * @Description
 * @Author Wangyw
 */
public class LoginController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.getSession().setAttribute("user","tom");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return null;
    }
}
