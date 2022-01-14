package com.phoenixhell.springbootbase.controller;

import com.phoenixhell.custom.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用自定义starter 里面自动注入的CustomService
 */

@RestController
public class CustomStarterController {
    @Autowired
    private CustomService customService;

    @GetMapping("/hello")
    public String sayHello(){
        String stater = customService.sayHello("my_custom_stater");
        return stater;
    }
}
