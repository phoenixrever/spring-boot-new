package com.phoenixhell.annotation.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *  Bean实现InitializingBean接口（定义初始化逻辑)
 *  相当于 @Bean(initMethod = "init")
 * @Component   放入容器或者 @Bean 注入
 */

public class LifeCycleInitializingBean implements InitializingBean, DisposableBean {

    public LifeCycleInitializingBean() {
        System.out.println("************LifeCycleInitializingBean created************");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("************LifeCycleInitializingBean afterPropertiesSet 属性值赋好了************");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("************LifeCycleInitializingBean destroyed************");
    }
}
