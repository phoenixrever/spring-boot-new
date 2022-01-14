package com.phoenixhell.springbootbase.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;

//spring.factories 里面注册
public class MySpringApplicationRunListener implements SpringApplicationRunListener {
    private  SpringApplication application;
    private String[] args;

    //必须有构造函数不然报错
    //MySpringApplicationRunListener.<init>(org.springframework.boot.SpringApplication, [Ljava.lang.String;)
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener  ------   starting ");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("SpringApplicationRunListener  ------   environmentPrepared ");

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener  ------   contextPrepared ");

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener  ------   contextLoaded ");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        //此时ioc里面的组件才初始化完成
        System.out.println("SpringApplicationRunListener  ------   started ");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener  ------   running ");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("SpringApplicationRunListener  ------   failed ");
    }
}
