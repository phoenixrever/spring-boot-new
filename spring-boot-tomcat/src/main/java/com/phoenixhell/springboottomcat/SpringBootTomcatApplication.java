package com.phoenixhell.springboottomcat;

import com.phoenixhell.springboottomcat.jvm.ClassToLoaded;
import com.phoenixhell.springboottomcat.jvm.MyClassLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 重要
 * ServletComponentScan   扫描自定义webServlet
 * 必须要防在main里面
 */
@ServletComponentScan(basePackages = "com.phoenixhell.springboottomcat.servlet")
@SpringBootApplication
public class SpringBootTomcatApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootTomcatApplication.class, args);

        /**
         * 应用程序类加载器（Application ClassLoader 默认）。负责加载用户类路径（classpath）上的指定类库
         */
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> loadClass = systemClassLoader.loadClass("com.phoenixhell.springboottomcat.jvm.ClassToLoaded");
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("类加载器: "+systemClassLoader);

        //AppClassLoader的父加载器   ExtClassLoader
        ClassLoader appClassLoadeParent = systemClassLoader.getParent();
        System.out.println("AppClassLoader的父加载器:"+appClassLoadeParent);
        //ExtClassLoader的父加载器
        System.out.println("ExtClassLoader:"+systemClassLoader.getParent().getParent());

        //com.phoenixhell.springboottomcat.jvm.ClassToLoaded
        System.out.println("加载的类"+loadClass);

        //查看容器的类的加载器  AppClassLoader
        ClassLoader classLoader = loadClass.getClassLoader();
        System.out.println("查看类的加载器: "+classLoader);

        //自定义classloader 被AppClassLoader 加载
        ClassLoader parent = MyClassLoader.getSystemClassLoader();
        System.out.println("myClassLoader 由"+parent+"加载");
        MyClassLoader myClassLoader = new MyClassLoader(parent);
        Class<?> aClass = myClassLoader.loadClass("com.phoenixhell.springboottomcat.jvm.MyClassloaded");

        //MyClassLoader 的加载类是 AppClassLoader
        //双亲委派机制下 AppClassLoader 已经可以加载到类了 直接由他加载
        System.out.println("MyClassloaded 的加载类: "+aClass.getClassLoader());

    }

}
