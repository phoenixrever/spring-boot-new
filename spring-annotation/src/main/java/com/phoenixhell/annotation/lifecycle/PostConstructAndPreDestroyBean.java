package com.phoenixhell.annotation.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
 * @PreDestroy：在容器销毁bean之前通知我们进行清理工作
 */

@Component
public class PostConstructAndPreDestroyBean {
    public PostConstructAndPreDestroyBean() {
        System.out.println(">>>>>>>>>>>>>PostConstructAndPreDestroyBean created<<<<<<<<<<<<<<<");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init() {
        System.out.println(">>>>>>>>>>>>>PostConstructAndPreDestroyBean init<<<<<<<<<<<<<<<");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(">>>>>>>>>>>>>PostConstructAndPreDestroyBean destroy<<<<<<<<<<<<<<<");
    }
}
