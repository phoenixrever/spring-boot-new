package com.phoenixhell.annotation.extension;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @EventListener 注解方式实现监听
 */

@Service
public class UserServiceListener {
    @EventListener(classes = ApplicationEvent.class)
    public void Listen(ApplicationEvent event){
        System.out.println("@EventListener 注解方式实现监听事件"+event);
    }
}
