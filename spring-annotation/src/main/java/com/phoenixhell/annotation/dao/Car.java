package com.phoenixhell.annotation.dao;

import org.springframework.stereotype.Component;

/**
 * @Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值
 */
@Component
public class Car {
    private String name;
}
