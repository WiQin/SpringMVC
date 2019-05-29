package com.wyw.web.adapter;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyHandlerAdapter
 * @Description 自定义适配器
 * @Author Wangyw
 */
public class MyHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object o) {
        return o instanceof IMyController;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        return ((IMyController)o).hand_test(request,response);
    }

    @Override
    public long getLastModified(HttpServletRequest httpServletRequest, Object o) {
        return 0;
    }
}
