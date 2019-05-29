package com.wyw.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Test3RequestMethodController
 * @Description  请求方法限定
 * @Author Wangyw
 */
@Controller
@RequestMapping("/rm")
public class Test3RequestMethodController {
    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public String test1(){
        return "hello";
    }

    @RequestMapping(value = "test2",method = RequestMethod.POST)
    public String test2(){
        return "hello";
    }

    @RequestMapping(value = "test3",method = {RequestMethod.GET,RequestMethod.POST})
    public String test3(){
        return "hello";
    }

    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String register_get(){
        System.out.println("跳转到注册页面");
        return "register";
    }

    //根据请求方式的不同对同意请求做出不同响应
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register_post(HttpServletRequest req){
        System.out.print(req.getParameter("name"));
        System.out.println(" ,接收数据，进行注册");
        return "success";
    }

    @RequestMapping(value="/test4",
            method={RequestMethod.PUT})
    public String test4(){
        System.out.println("test4");
        return "hello";
    }
}
