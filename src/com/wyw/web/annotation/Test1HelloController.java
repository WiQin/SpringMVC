package com.wyw.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName Test1HelloController
 * @Description 处理器类
 * @Author Wangyw
 */
@Controller
public class Test1HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return  mv;
    }

    @RequestMapping("hello2")
    public String hello2(){
        return "hello";
    }

    @RequestMapping("hello3")
    public void hello3(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write("hello3");
        pw.flush();
        pw.close();


    }
}
