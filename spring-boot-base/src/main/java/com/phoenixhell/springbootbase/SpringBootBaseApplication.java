package com.phoenixhell.springbootbase;

import com.phoenixhell.springbootbase.bean.Person;
import com.phoenixhell.springbootbase.config.MyWebConfig;
import org.omg.CORBA.Environment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * ServletComponentScan   扫描自定义webServlet
 */
@ServletComponentScan(basePackages = "com.phoenixhell.springbootbase.servlet")
@SpringBootApplication(scanBasePackages = "com.phoenixhell.springbootbase")
public class SpringBootBaseApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootBaseApplication.class, args);

        String[] names = applicationContext.getBeanDefinitionNames();
        //for (String name : names) {
        //    System.out.println(name);
        //}

        /*
           MyConfig$$EnhancerBySpringCGLIB  spring增加了的代理对象
           proxyBeanMethods = true 的情况下 获取的实例都是同一个
           proxyBeanMethods = false 的情况下 获取的实例都不一样
        */
        MyWebConfig myConfig = applicationContext.getBean(MyWebConfig.class);
        Person person1 = myConfig.person();
        Person person2 = myConfig.person();
        //System.out.println(myConfig);
        //System.out.println(person1==person2);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        systemEnvironment.forEach((key, value) -> System.out.println(key + ":" + value));

    }
}
