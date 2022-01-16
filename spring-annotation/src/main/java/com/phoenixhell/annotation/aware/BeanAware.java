package com.phoenixhell.annotation.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 继承ApplicationContextAware 通过BeanPostProcessor 就能拿到IOC容器
 */

@Component
public class BeanAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        System.out.println("传入的ioc容器: "+applicationContext);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String stringValue = resolver.resolveStringValue("hello ${os.name} #{10-3}");
        System.out.println("StringValueResolver解析的值: ="+stringValue);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("得到当前bean的名字: "+name);
    }
}
