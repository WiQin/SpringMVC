package com.wyw.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName Test5RequestHeaderController
 * @Description 请求头的限定
 * @Author Wangyw
 */
@Controller
@RequestMapping("rh")
public class Test5RequestHeaderController {
    //指定的请求头
    @RequestMapping(value = "/test1",headers = "Accept")
    public String test1(){
        return "hello";
    }


    @RequestMapping(value = "/test2",headers = "myTest")
    public String test2(){
        return "hello";
    }

    //限定请求头中没有指定的信息
    @RequestMapping(value = "/test3",headers = "!myTest")
    public String test3(){
        return "hello";
    }


    @RequestMapping(value = "/test4",headers = "!Host")
    public String test4(){
        return "hello";
    }

    //限定请求头和值
    @RequestMapping(value = "/test5",headers = "Accept=application/json")
    public String test5(){
        return "hello";
    }

    @RequestMapping(value = "/test6",headers = "Content-Type=application/json")
    public String test6(){
        return "hello";
    }

    @RequestMapping(value = "/test7",headers = "Accept!=application/json")
    public String test7(){
        return "hello";
    }

    //消费  ContentType
    @RequestMapping(value = "/test8",consumes = "application/json")
    public String test8(){
        return "hello";
    }

    //产品 Accept
    @RequestMapping(value = "/test9",produces = "application/json")
    public String test9(){
        return "hello";
    }
}
