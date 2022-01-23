package com.phoenixhell.springboottomcat.jvm;

/**
 * 被由自定义MyClassloader 加载的类
 * Myclassloader 加载了此类 MyClassloaded 后还会加载此类的父类Object
 * object 是java.lang 包下的
 */
public class MyClassloaded extends Object {
}
