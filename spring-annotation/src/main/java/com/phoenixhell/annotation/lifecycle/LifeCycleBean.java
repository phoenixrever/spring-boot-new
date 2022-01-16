package com.phoenixhell.annotation.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class LifeCycleBean {

    public LifeCycleBean() {
        System.out.println("============LifeCircleBean created=============");
    }
    public void init(){
        System.out.println("============LifeCircleBean init=============");
    }

    public void destroy(){
        System.out.println("============LifeCircleBean destroy=============");
    }
}
