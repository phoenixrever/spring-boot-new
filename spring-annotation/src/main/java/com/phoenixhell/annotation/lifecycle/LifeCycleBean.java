package com.phoenixhell.annotation.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 继承ApplicationContextAware 通过BeanPostProcessor 就能拿到IOC容器
 * 后面详细研究
 */

public class LifeCycleBean implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public LifeCycleBean() {
        System.out.println("============LifeCircleBean created=============");
    }
    public void init(){
        System.out.println("============LifeCircleBean init=============");
    }

    public void destroy(){
        System.out.println("============LifeCircleBean destroy=============");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
