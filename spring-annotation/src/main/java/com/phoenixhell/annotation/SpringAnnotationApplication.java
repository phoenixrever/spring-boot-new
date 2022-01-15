package com.phoenixhell.annotation;

import com.phoenixhell.annotation.entity.UserEntity;
import com.phoenixhell.annotation.filter.MyTypeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@Slf4j
@SpringBootApplication
public class SpringAnnotationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringAnnotationApplication.class, args);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            log.info(name);
        }
        //@scope  单列和多实例测试 单实例 饿汉式(@lazy也可以懒加载) 加载 随容器一起加载
        //多实例 懒汉式 调用时候才会加载
        Object userEntity1 = run.getBean("userEntity");
        Object userEntity2 = run.getBean("userEntity");
        System.out.println(userEntity1==userEntity2);

        //工厂bean获取的是调用其getObject 方法返回的对象
        //使用的时候才会注册容器相当于懒加载
        //Object colorFactoryBean = run.getBean("colorFactoryBean");
        //System.out.println("colorFactoryBean======>"+colorFactoryBean.getClass());

        // & 获取工厂bean 本身
        Object colorFactoryBean = run.getBean("&colorFactoryBean");
        System.out.println("colorFactoryBean======>"+colorFactoryBean.getClass());

        run.close();
    }
}
