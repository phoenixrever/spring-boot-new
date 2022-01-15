package com.phoenixhell.annotation.entity;

/**
 * @import 方式被注入
 * id 默认是组件全类名
 */

public class ColorToImport {
    public ColorToImport() {
        System.out.println("ColorToImport 被注入了");
    }
}
