package com.wyw.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName Test2RequestPathController
 * @Description
 * @Author Wangyw
 */
@Controller
public class Test2RequestPathController {
    //普通路径映射
    @RequestMapping("/test1")
    public String test1(){
        return "hello";
    }

    @RequestMapping(value = "/test2")
    public String test2(){
        return "hello";
    }

    @RequestMapping({"/test2","test33"})
    public String test3(){
        return "hello";
    }

    //模板映射
    @RequestMapping("/test4/{userId}")
    public String test4(@PathVariable long userId){
        return "hello";
    }
    @RequestMapping("/test5/{id}")
    public String test5(@PathVariable("id") long userId){//把id的值交给userId,或者把参数定义成与注解中一致
        return "hello";
    }
    @RequestMapping("/test6/{userId}/t")
    public String test6(@PathVariable long userId){
        return "hello";
    }

    //ant风格的路径映射
    //* 0-n个字符
    //？ 1个字符
    //**  包含路径及子路径（或空）
    @RequestMapping("/test7/*")
    public String test7(){
        return "hello";
    }

    @RequestMapping("/test8*")
    public String test8(){
        return "hello";
    }

    @RequestMapping("/test9？")
    public String test9(){
        return "hello";
    }

    @RequestMapping("/test10/？")
    public String test10(){
        return "hello";
    }

    @RequestMapping("/test11/**")
    public String test11(){
        return "hello";
    }

    @RequestMapping("/test12/**/{userId}")
    public String test12(@PathVariable long userId){
        return "hello";
    }
}
