package com.phoenixhell.springbootbase.controller;

import com.phoenixhell.springbootbase.bean.GirlFriend;
import com.phoenixhell.springbootbase.bean.LoginUser;
import com.phoenixhell.springbootbase.bean.Person;
import com.phoenixhell.springbootbase.bean.Women;
import com.phoenixhell.springbootbase.exception.UserTooManyException;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author phoenixhell
 * @since 2022/1/4 0004-下午 3:54
 */
@Controller
public class IndexController {
    Counter counter;

    //只有一个有参会自动从容器中注入参数
    public IndexController(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("index.count");
    }

    @GetMapping({"/","/login.html"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginUser loginUser,HttpSession session,RedirectAttributes redirectAttributes) {
        if(StringUtils.hasText(loginUser.getUsername())&& "12345".equalsIgnoreCase(loginUser.getPassword())){
            session.setAttribute("loginUser",loginUser);
            return "redirect:index";
        }
        redirectAttributes.addFlashAttribute("error","账号或者密码不正确");
        return "redirect:login.html";
    }

    //==========================profile===============================
    @Value("${myInfo.name:shadowsilent}")
    private String name;

    @Value("${myInfo.age:18}")
    private String age;

    @Autowired
    private Women women;
    //template 视图支持需要thymeleaf 支持

    //spring boot 可以直接取到环境变量的值
    @Value("${JAVA_HOME}")
    private String javaHome;

    @GetMapping("/index")
    public String index(Model model){
        //模拟arithmetic 异常
       // int a=1/0;
        //自定义异常
        //throw new UserTooManyException();

        //metrics 查看到底被调用多少次
        counter.increment();
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("women",women);
        model.addAttribute("javaHome",javaHome);
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

    //============================复杂参数=====================================

    //http://localhost:8080/modelAndMap?name=shadow&age=18
    //所有添加进去的值都放入request作用域 传递下去直到render页面 传入request和response
    @GetMapping("/modelAndMap")
    public String model(Map<String,Object> map, Model model, HttpServletResponse response){
        map.put("name","shadow");
        model.addAttribute("age",20);
        Cookie cookie = new Cookie("cookie_name","cookie_value");;
        response.addCookie(cookie);
        return "modelAndMap";
    }

}
