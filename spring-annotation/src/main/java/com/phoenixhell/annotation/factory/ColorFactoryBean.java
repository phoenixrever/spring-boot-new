package com.phoenixhell.annotation.factory;

import com.phoenixhell.annotation.entity.ColorFactoryEntity;
import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂bean 生产 ColorFactoryEntity
 */
public class ColorFactoryBean implements FactoryBean<ColorFactoryEntity> {
    @Override
    public ColorFactoryEntity getObject() throws Exception {
        return new ColorFactoryEntity();
    }

    @Override
    public Class<?> getObjectType() {
        return ColorFactoryEntity.class;
    }

    //true 为单实例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
