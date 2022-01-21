package com.phoenixhell.annotation.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * All bean definitions will have been loaded, but no beans will have been instantiated yet
 * 在所有bean定义信息将要被加载，bean实例还未创建的； 在BeanFactoryPostProcessor之前
 */

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     * @param registry bean 定义信息的保存中心
     *                 beanFactory 就是按照BeanDefinitionRegistry里面的保存的
     *                 每一个bean定义信息来创建bean的实例
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("在所有bean定义信息将要被加载，bean实例还未创建的时候<===>在BeanFactoryPostProcessor之前 bean的数量:"+registry.getBeanDefinitionCount());
        //bean 定义中注册一个对象
        //AbstractBeanDefinition cat = BeanDefinitionBuilder.rootBeanDefinition(Cat.class).getBeanDefinition();
        RootBeanDefinition cat = new RootBeanDefinition(Cat.class);
        registry.registerBeanDefinition("cat",cat);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor==>所有的bean的定义已经加载到beanFactory，但是bean的实例还未创建 bean的数量:"+beanFactory.getBeanDefinitionCount());
    }
}
