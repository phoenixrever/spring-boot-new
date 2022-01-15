package com.phoenixhell.annotation.entity;

/**
 * @ImportSelector 方式被注入
 * id 默认是组件全类名
 */


public class ColorImportSelector {
    public ColorImportSelector() {
        System.out.println("ColorImportSelector 通过@ImportSelector 被注入了");
    }
}
