package com.phoenixhell.annotation.extension;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring 扩展原理
 * BeanPostProcessor：bean后置处理器，bean创建对象初始化前后进行拦截工作的
 *
 * BeanFactoryPostProcessor：beanFactory的后置处理器:
 *  		在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
 *  		所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 *
 * BeanDefinitionRegistryPostProcessor:
 *          在所有bean定义信息将要被加载，bean实例还未创建的； 在BeanFactoryPostProcessor之前
 */

@Configuration
public class ExtensionConfig {

}
