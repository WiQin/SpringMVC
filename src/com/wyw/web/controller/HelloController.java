package com.wyw.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @ClassName HelloController
 * @Description  控制器/处理器
 * @Author Wangyw
 */
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");

        //创建mv,包含要返回的模型和逻辑视图名
        ModelAndView mv = new ModelAndView();
        //
        mv.setViewName("hello");//对应物理视图hello.jsp
        //添加数据
        mv.addObject("name:",name);

        return mv;
    }
}
