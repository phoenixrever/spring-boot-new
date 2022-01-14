package com.phoenixhell.springbootbase.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

//spring.factories 里面注册
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener::onApplicationEvent");
    }
}
