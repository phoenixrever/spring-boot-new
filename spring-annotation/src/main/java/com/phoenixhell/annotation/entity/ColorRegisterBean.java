package com.phoenixhell.annotation.entity;

/**
 * 被实现 ImportBeanDefinitionRegistrar的类注入的组件
 */

public class ColorRegisterBean {
    public ColorRegisterBean() {
        System.out.println("ColorRegisterBean 被Register 了");
    }
}
