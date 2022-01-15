package com.phoenixhell.annotation.lifecycle;

/**
 * @author phoenixhell
 * @since 2022/1/15 0015-下午 3:39
 */

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
