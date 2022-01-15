package com.phoenixhell.annotation.service;

import com.phoenixhell.annotation.dao.AutowiredDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AutowiredService {

    /**
     * 注入的时候如果找到多个相同类型的组件，
     * 再将属性的名称(注入的时候指定的名字)作为组件的id去容器中查找
     *
     *或者用以下方法明确指定:
     *      @Qualifier(value = "autowiredDao")
     *      @Primary 直接标注同类型的组件优先级最高(低于@Qualifier指定的)
     * required = false 指定不是必须
     */
    @Qualifier(value = "autowiredDao")
    @Autowired(required = false)
    private AutowiredDao autowiredDao2;

    @Override
    public String toString() {
        return "AutowiredService{" +
                "autowiredDao=" + autowiredDao2 +
                '}';
    }
}
