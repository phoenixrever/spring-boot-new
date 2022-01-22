package com.phoenixhell.springbootbase.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

//spring.factories 里面注册
//spring 启动时候  会去spring.factories找 ApplicationContextInitializer 加载进容器
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer::initialize");
    }
}
