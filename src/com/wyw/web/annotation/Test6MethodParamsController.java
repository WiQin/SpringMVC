package com.wyw.web.annotation;

import com.wyw.bean.User;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Test6MethodParamsController
 * @Description  功能处理方法中可以加的参数
 * @Author Wangyw
 */
@Controller
@RequestMapping("mp")
public class Test6MethodParamsController {

    //ServlerRequest和ServletResponse
    //HttpServletRequest和HttpServletResponse
    @RequestMapping("/test1")
    public String test1(ServletRequest request, ServletResponse response){

        return "hello";
    }

    //InputStream和OutputStream
    //Reader和Writer
    //使用输出流,就不能再发回视图了,因为使用输出流那么就是使用了response,使用了response就是要自己处理返回给浏览器的内容,那么也就不能再让Controller返回视图了
    @RequestMapping("/test2")
    public void test2(InputStream is, OutputStream os){

    }

    //WebRequest/NativeWebRequest
    @RequestMapping("/test3")
    public String webRequest(WebRequest webRequest, NativeWebRequest nativeWebRequest) {
        System.out.println(webRequest.getParameter("test"));
        webRequest.setAttribute("name", "tom",WebRequest.SCOPE_REQUEST);
        System.out.println(webRequest.getAttribute("name", WebRequest.SCOPE_REQUEST));
        HttpServletRequest request =
                nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response =
                nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        return "success";
    }

    //HttpSession
    @RequestMapping("test4")
    public String session(HttpSession session) {
        System.out.println(session);
        session.setAttribute("sessionName","name");
        return "success";
    }

    //命令/表单对象(也可以是是自定义对象 例如User)
    @RequestMapping(value = "/test5")
    public String toCreateUser(HttpServletRequest request, User user) {
        return null;
    }

    //Model Map
    @RequestMapping(value="/test6")
    public String test(Model m1, Map<String,Object> m2, ModelMap m3) {
        m1.addAttribute("a", "a");
        m2.put("b", "b");
        m3.put("c", "c");
        System.out.println(m1 == m2);
        System.out.println(m2 == m3);
        System.out.println(m1.getClass());
        System.out.println(m2.getClass());
        System.out.println(m3.getClass());
        return "success";
    }

    //HttpEntity<T>
    @RequestMapping(value="/test7")
    public String  test(HttpEntity<String> httpEntity){
        //获得请求中的所有的header部分
        HttpHeaders headers = httpEntity.getHeaders();
        //获得请求中的所有的body部分
        String body = httpEntity.getBody();

        Set<Map.Entry<String, List<String>>> set = headers.entrySet();
        StringBuffer s = new StringBuffer();
        for(Map.Entry<String,List<String>> entry:set){
            String key = entry.getKey();
            s.append(key+": ");
            List<String> list = entry.getValue();
            for(String value:list){
                s.append(value+" ");
            }
            System.out.println(s.toString());
            s.setLength(0);
        }
        System.out.println("----------------");
        System.out.println("body = "+body);

        return "success";
    }

    //ResponseEntity的使用,可以自定义响应的各个部分
    @RequestMapping("/test8")
    public ResponseEntity<String> test(){
        //创建响应头对象
        HttpHeaders headers = new HttpHeaders();

        //创建MediaType对象
        MediaType mt = new MediaType("text","html", Charset.forName("UTF-8"));
        //设置ContentType
        headers.setContentType(mt);

        //准备好相应体
        String content = new String("hello world");

        //根据响应内容/响应头信息/响应状态码创建响应对象
        ResponseEntity<String> re = new ResponseEntity<String>(content,headers, HttpStatus.OK);

        //返回ResponseEntity对象
        return re;
    }

    //SessionStatus



    //RedirectAttributes
    @RequestMapping("/test10")
    public String test10(User user,Model model){

        model.addAttribute("msg","register");
        return "success";
    }

    @RequestMapping("/test11")
    public String test11(User user, RedirectAttributes ras){

        ras.addFlashAttribute("msg","register");
        return "redirect:/mp/toSuccess";
    }
    @RequestMapping("/toSuccess")
    public String toSuccess(){

        return "success";
    }


    //BindingResult
}
