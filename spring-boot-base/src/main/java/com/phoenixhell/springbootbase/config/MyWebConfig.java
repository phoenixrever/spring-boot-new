package com.phoenixhell.springbootbase.config;

import com.phoenixhell.springbootbase.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;


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
@Configuration(proxyBeanMethods = false)
public class MyWebConfig implements WebMvcConfigurer {

    //自定义组件名
    @Bean(value = "customName")
    public Person person(){
        return  new Person("loser",18);
    }

    //spring WebMvcConfigurer 有多个实现 我们写的这个实现会先到这里找实现方法
    //没有就会找其他实现类 WebMvcAutoConfigurationAdapter implements WebMvcConfigurer
    //总之就是根据文档implements WebMvcConfigurer 覆写我们想要改变的方法就行
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}
