package com.phoenixhell.annotation.factory;

import com.phoenixhell.annotation.entity.ColorRegisterBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

//手工注册 ColorRegisterBean
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata  当前标注@import注解的类(MyConfig)的信息
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b = registry.containsBeanDefinition("colorRegisterBean");
        if(!b){
            registry.registerBeanDefinition("colorRegisterBean", new RootBeanDefinition(ColorRegisterBean.class) {
            });
        }
    }
}
