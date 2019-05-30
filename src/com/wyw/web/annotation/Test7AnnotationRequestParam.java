package com.wyw.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

/**
 * @ClassName Test7AnnotationRequestParam
 * @Description
 * @Author Wangyw
 */
@Controller
@RequestMapping("arp")
public class Test7AnnotationRequestParam {

    @RequestMapping("/test1")
    public String test1(String name){
        System.out.println("test3-name:"+name);
        return "success";
    }

    @RequestMapping("/test2")
    public String test2(Long id){
        System.out.println("test2-id:"+id);
        return "success";
    }

    @RequestMapping("/test3")
    public String test3(@RequestParam("name") String name){
        System.out.println("test3-name:"+name);
        return "success";
    }
    @RequestMapping("/test4")
    public String test4(@RequestParam("id") Long id){
        System.out.println("test4-id:"+id);
        return "success";
    }

    @RequestMapping("/test5")
    public String test5(@RequestParam(value = "id",required = false,defaultValue = "5") Long id){
        System.out.println("test5:"+id);
        return "success";
    }

    //@PathVariable绑定URI模板变量值
    //获取到的值自动存放在model中，key以@PathVariable 中的值为准
    @RequestMapping("/test7/{name}/hello")
    public String test7(@PathVariable String name){
        System.out.println("test7:"+name);
        return "success";
    }

    //@CookieValue绑定Cookie数据值
    @RequestMapping("/test8")
    public String test8(@CookieValue("JSESSIONID") String sessionId){
        System.out.println("test8:"+sessionId);
        return "success";
    }

    @RequestMapping("/test9")
    public String test9(@CookieValue("JSESSIONID") Cookie sessionId){
        System.out.println("test9:"+sessionId.getName()+":"+sessionId.getValue());
        return "success";
    }

    @RequestMapping("/test10")
    public String test10(@CookieValue(value = "username" ,required = false,defaultValue = "no") String username ){
        System.out.println("test10:"+username);
        return "success";
    }

    //@RequestHeader 绑定请求头数据
    @RequestMapping("/test11")
    public String test11(@RequestHeader("Accept") String accept){
        System.out.println("test11:"+accept);
        return "success";
    }

    @RequestMapping("/test12")
    public String test12(@RequestHeader("Accept") String accept){
        System.out.println("test12:"+accept);
        return "success";
    }

    //@ModelAttribute


}
