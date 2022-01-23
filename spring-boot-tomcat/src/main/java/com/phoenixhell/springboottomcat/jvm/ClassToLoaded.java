package com.phoenixhell.springboottomcat.jvm;

/**
 * 测试被类加载器加载
 */

public class ClassToLoaded {
    public ClassToLoaded() {
        System.out.println("ClassToLoaded 被类加载器加载了");
    }
}
