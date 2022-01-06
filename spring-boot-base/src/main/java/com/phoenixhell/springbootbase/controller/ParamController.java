package com.phoenixhell.springbootbase.controller;

import com.phoenixhell.springbootbase.bean.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author phoenixhell
 * @since 2022/1/5 0005-下午 4:11
 */

@RestController
public class ParamController {

    //============================注解参数=====================================
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

    //矩阵变量   /matrix;jsessionId=xxxx,yyy ; another=xxx;
    // 把cookie的值使用矩阵变量传递 和普通query param 区分
    // /matrix/name=shadow;age=20,30,40;gender=male
    //开启矩阵变量功能  矩阵变量必须写成路径变量形式 {path}
    @GetMapping("/matrix/{path}")
    public Map<String, Object> matrix(
            @MatrixVariable("name") String name,
            @MatrixVariable("age") List<Integer> ages,
            @MatrixVariable("gender") String gender,
            @MatrixVariable Map<String, Object> matrixMap,
            @PathVariable String path){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("age",ages);
        map.put("gender",gender);
        System.out.println(map);
        //map接收所有值
        System.out.println("==============matrixMap接收所有值==============");
        System.out.println(matrixMap);
        System.out.println(path);

        return map;
    }

    // /matrix/{1;age=10,20}/{2;age=30,40}
    @GetMapping("/matrix/{bossId}/{empId}")
    public Map<String, Object> matrix2(
            @MatrixVariable(value = "age",pathVar = "bossId") List<Integer> bossIds,
            @MatrixVariable(value = "age",pathVar = "empId") List<Integer> empIds,
            @MatrixVariable Map<String, Object> matrixMap){
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossIds",bossIds);
        map.put("empIds",empIds);
        System.out.println(map);//{bossIds=[10, 20], empIds=[30, 40]}
        //map接收所有值
        System.out.println("==============matrixMap接收所有值==============");
        System.out.println(matrixMap); //{age=10} 分段不能直接用map接收
        return map;
    }

}
