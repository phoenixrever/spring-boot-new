package com.phoenixhell.springbootbase.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

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

    //RedirectAttributes
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("msg","message");
        return "forward:requestAttributes";
    }

    //RedirectAttributes
    @GetMapping("/requestAttributes")
    public String redirectAttributes(@RequestAttribute("msg") String redirectAttributes,HttpServletRequest httpServletRequest){
        System.out.println("String====>"+redirectAttributes);
        System.out.println("httpServletRequest====>"+httpServletRequest.getAttribute("msg"));
        return "requestAttributes";
    }
}
