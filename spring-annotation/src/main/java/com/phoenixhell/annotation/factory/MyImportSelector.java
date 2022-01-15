package com.phoenixhell.annotation.factory;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 实现ImportSelector接口 注册ColorImportSelector
 *
 */


public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata  当前标注@Import注解的类(MyConfig)的信息
     * @return 要导入到容器中的组件的全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String className = importingClassMetadata.getClassName();
        System.out.println("@ImportSelector 包含的类被加载到容器了");
        return new String[]{"com.phoenixhell.annotation.entity.ColorImportSelector"};
    }
}
