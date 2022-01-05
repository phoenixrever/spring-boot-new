package com.phoenixhell.springbootbase.controller;

import com.phoenixhell.springbootbase.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.Map;

/**
 * @author phoenixhell
 * @since 2022/1/5 0005-下午 4:11
 */

@RestController
public class ParamController {

    //PathVariable 也可以是直接是个map 包含所有 参数
    @GetMapping("/param/{username}/other/{age}")
    public String pathVariable(@PathVariable String username, @PathVariable String age,@PathVariable Map<String,String> person){
        return person.toString();
    }

    //获取单个请求头和全部请求头
    @GetMapping("/header")
    public String header(@RequestHeader("User-Agent")String userAgent, @RequestHeader Map<String,String> header){
        System.out.println(userAgent);
        System.out.println(header.get("host"));
        return header.toString();
    }

    //获取单个参数和全部参数http://localhost:8080/requestParam?name=shadow&age=18
    @GetMapping("/requestParam")
    public String requestParam(@RequestParam("name")String name, @RequestParam Map<String,String> person){
        System.out.println(name);
        System.out.println(person.get("name"));
        return person.toString();
    }

    //获取单个cookie String 或者封装成cookie类型   注意cookie没有map
    @GetMapping("/cookie")
    public String cookie(@CookieValue("oracle.uix")String uix, @CookieValue("oracle.uix") Cookie cookie){
        System.out.println(uix);
        System.out.println(cookie.getValue());
        return cookie.toString();
    }

    //获取json 数据ajax data内容 或者表单提交内容
    @PostMapping("/data")
    public Person getData(@RequestBody Person person,@RequestBody Map<String,String> map){
        System.out.println(map);
        return person;
    }

}
