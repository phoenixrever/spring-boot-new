package com.phoenixhell.annotation.service;

import com.phoenixhell.annotation.dao.AutowiredDao;
import com.phoenixhell.annotation.dao.Car;
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

    private Car car;

    /**
     * 位置 2:
     * [标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略(不需要写@Autowired)，
     * 当然写了也没事
     * 参数位置的组件还是可以自动从容器中获取
     */
    public AutowiredService(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }


    /**
     * 位置 1:
     * 标注在方法上或者放在参数位置 spring容器创建此对象时候,就会调用此方法完成赋值
     * @param car 方法的参数会自动从容器中获取注入
     */
    //@Autowired
    public void setCar(/*@Autowired*/ Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "AutowiredService{" +
                "autowiredDao2=" + autowiredDao2 +
                ", car=" + car +
                '}';
    }
}
