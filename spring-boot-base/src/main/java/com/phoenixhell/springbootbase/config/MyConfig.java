package com.phoenixhell.springbootbase.config;

import com.phoenixhell.springbootbase.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *   Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *    Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *
 * springboot2 中 proxyBeanMethods 默认为true
 * 代理bean的方法 MyConfig$$EnhancerBySpringCGLIB  spring增加了的代理对象
 *         MyConfig myConfig = applicationContext.getBean(MyConfig.class);
 *         Person person1 = myConfig.person();
 *         Person person2 = myConfig.person();
 *         System.out.println(myConfig);
 *         System.out.println(person1==person2);
 *
 * proxyBeanMethods = true  Full 模式 的情况下 通过此配置类中的方法 spring 代理对象
 *      调用时候总会检查容器中是否已经存在 获取的实例都是同一个
 *
 * proxyBeanMethods = false Lite模式  的情况下 获取的实例都不一样
 *
 * lite 模式每次创造对象不会检查容器中是否已经存在 速度会加快
 *
 * 如果组件之间是相互依赖的(一个对象的属性中有另外一个对象) proxyBeanMethods设置成true
 *
 */
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    //自定义组件名
    @Bean(value = "customName")
    public Person person(){
        return  new Person("loser",18);
    }
}
