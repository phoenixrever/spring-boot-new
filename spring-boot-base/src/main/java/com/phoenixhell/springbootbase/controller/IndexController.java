package com.phoenixhell.springbootbase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author phoenixhell
 * @since 2022/1/4 0004-下午 3:54
 */
@Controller
public class IndexController {
    //template 视图支持需要thymeleaf 支持
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
