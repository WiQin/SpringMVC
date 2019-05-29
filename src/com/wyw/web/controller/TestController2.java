package com.wyw.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName TestController2
 * @Description 直接通过response写响应
 * @Author Wangyw
 */
public class TestController2 extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //服务器  客户端
        response.setContentType("text/html;charset=utf-8");

        PrintWriter pw = response.getWriter();
        pw.write("hello a");
        pw.flush();
        pw.close();
        return null;
    }
}
