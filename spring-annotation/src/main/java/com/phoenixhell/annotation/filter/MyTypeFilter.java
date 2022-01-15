package com.phoenixhell.annotation.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;


import java.io.IOException;

/**
 * FilterType.CUSTOM： 实现TypeFilter 接口 使用自定义规则
 * excludeFilters 规范 返回true的排除
 */


public class MyTypeFilter implements TypeFilter {

    /**
     * @param metadataReader 读取到当前正在扫描的类信息
     *
     * @param metadataReaderFactory  可以获取到其他任何类信息的
     *
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前正在扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String className = classMetadata.getClassName();

        //获取当前类的资源信息(比如类路径)
        Resource resource = metadataReader.getResource();
        System.out.println("自定义TypeFilter 包扫描到组件===============>"+className);
        //excludeFilters 规范 返回true的排除  组件包含er字符串的 排除容器
        if(className.contains("MyConfig")){
            return true;
        }
        //false 为不排除
        return false;
    }
}
