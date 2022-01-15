package com.phoenixhell.annotation.entity;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 测试条件加载 @Conditional windows系统就加载
 */

public class WindowEntity implements Condition {
    /**
     * @param context
     * @param metadata 注解的信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String OS = environment.getProperty("os.name");
        System.out.println("================"+OS+"===================");
        assert OS != null;
        return OS.contains("Windows");
    }
}
