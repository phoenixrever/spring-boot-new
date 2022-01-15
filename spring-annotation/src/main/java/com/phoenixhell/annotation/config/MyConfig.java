package com.phoenixhell.annotation.config;

import com.phoenixhell.annotation.entity.*;
import com.phoenixhell.annotation.factory.ColorFactoryBean;
import com.phoenixhell.annotation.factory.MyImportBeanDefinitionRegistrar;
import com.phoenixhell.annotation.factory.MyImportSelector;
import com.phoenixhell.annotation.filter.MyTypeFilter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;

/**
 * 重新覆盖 扫描包和排除规则
 */
@Import({ColorToImport.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})  //id 默认是组件全类名
@ComponentScan( value = "com.phoenixhell.annotation",excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class}) })
@Configuration
public class MyConfig {

    /**
     * SCOPE_PROTOTYPE 多例模式  懒汉式 调用时候才会加载
     * SCOPE_PROTOTYPE 单例模式(默认) 饿汉式 ioc容器启动时候就会加载到容器中
     * WebApplicationContext#SCOPE_REQUEST 同一个请求创建一个实例
     * WebApplicationContext#SCOPE_SESSION 同一个session创建一个实例
     *  单实例@lazy也可以懒加载：
     */

    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    @Bean
    public UserEntity userEntity(){
        System.out.println("测试单实例bean的饿汉式加载");
        return new UserEntity();
    }

    //测试条件加载 @ConditionalOnMissingBean
    @ConditionalOnMissingBean(value = ConditionalEntity.class)
    @Bean
    public DogEntity dogEntity(){
        System.out.println("容器中没有 ConditionalEntity 的情况下 才会加载dog");
        return new DogEntity();
    }

    @Conditional({WindowEntity.class})
    @Bean
    public WindowEntity windowEntity(){
        System.out.println("操作系统为window就把此类加载到IOC容器中");
        return new WindowEntity();
    }

    // FactoryBean 注册组件
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
