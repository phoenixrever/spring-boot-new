package com.phoenixhell.annotation.entity;

/**
 * 等待Spring提供的 FactoryBean（工厂Bean）来注册自己
 */

public class ColorFactoryEntity {
    public ColorFactoryEntity() {
        System.out.println("FactoryBean 注册ColorFactoryEntity 成功");
    }
}
