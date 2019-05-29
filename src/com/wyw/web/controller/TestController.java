package com.wyw.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TestController
 * @Description
 * @Author Wangyw
 */
public class TestController extends AbstractController {

    /*@Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println( );
        return super.handleRequest(request, response);
    }*/

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");

        System.out.println("test");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("name",name);

        return mv;
    }
}
