package com.wyw.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName TestRequestParamsController
 * @Description
 * @Author Wangyw
 */
@Controller
@RequestMapping("/rp")
public class Test4RequestParamsController {
    //有指定的请求参数名
    @RequestMapping(value = "/test1",method = RequestMethod.GET,params = "userId")
    public String test1(){

        return "hello";
    }

    //有指定的参数名及参数值
    @RequestMapping(value = "/test2",method = RequestMethod.GET,params = "userId=1223")
    public String test2(){

        return "hello";
    }

    //参数值不为指定值,或没有参数值
    @RequestMapping(value = "/test3",method = RequestMethod.GET,params = "userId!=1223")
    public String test3(){

        return "hello";
    }

    //参数中没有指定的参数值
    @RequestMapping(value = "/test4",method = RequestMethod.GET,params = "!userId")
    public String test4(){

        return "hello";
    }

    //
    @RequestMapping(value = "/test5",method = RequestMethod.GET,params = {"!userId","name=zs"})
    public String test5(){

        return "hello";
    }
}
