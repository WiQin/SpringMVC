package com.wyw.web.adapter;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyControllertest
 * @Description  自定义接口的自定义处理器
 * @Author Wangyw
 */
public class MyControllertest implements IMyController{
    @Override
    public ModelAndView hand_test(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");

        System.out.println("自定义处理器");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("name","my"+name);

        return mv;
    }
}
