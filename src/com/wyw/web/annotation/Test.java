package com.wyw.web.annotation;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.net.URI;

/**
 * @ClassName Test
 * @Description
 * @Author Wangyw
 */
public class Test {
    public static void main(String[] args) {

        try {
            String url = "http://127.0.0.1:8088/rh/test10";
            //创建HttpRequest
            ClientHttpRequest request =
                    new SimpleClientHttpRequestFactory().
                            createRequest(new URI(url), HttpMethod.POST);
            //设置请求头的内容类型头和内容编码
            //request.getHeaders().set("Content-Type", "application/json;charset=UTF-8");
            request.getHeaders().set("Accept", "application/json");
            //写出请求内容体
            String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
            request.getBody().write(jsonData.getBytes("UTF-8"));
            //发送请求并得到响应
            ClientHttpResponse response = request.execute();
            System.out.println(response.getStatusCode());
            System.out.println(response.getHeaders());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
