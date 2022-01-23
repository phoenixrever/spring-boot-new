package com.phoenixhell.springboottomcat.jvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 自定义classloader
 */

public class MyClassLoader extends ClassLoader {
    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name)  {
        //通常这里是指定一个文件夹 然后根据name找出对应的文件 这里图方便直接指定文件
        Path path = Paths.get("N:\\Git\\spring-boot-new\\spring-boot-tomcat\\target\\classes\\com\\phoenixhell\\springboottomcat\\jvm\\MyClassloaded.class");
        if(Files.exists(path)){
            try {
                byte[] bytes = Files.readAllBytes(path);
                Class<?> clazz = this.defineClass(name, bytes, 0, bytes.length);
                return clazz;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Class<?> loadClass(String name) {
        Class<?> loadedClass = findLoadedClass(name);
        if(loadedClass!=null){
            return loadedClass;
        }
        ClassLoader extClassLoader = getSystemClassLoader().getParent();
        Class<?> clazz;
          try {
            //extClassLoader 是加载不到我们用户classpath下面的class文件的
            // 这样他就只会加载object 我们自定义的加载器就能加载用户文件
            //不用appClassLoader 的原因是他也会扫描用户文件 就不用我们的了
             clazz = extClassLoader.loadClass(name);
        } catch (ClassNotFoundException e) {
            System.out.println("extClassLoader 是加载不到我们用户classpath下面的class文件的");
            clazz = findClass(name);
        }
        return clazz;
    }
}
