package com.phoenixhell.springbootbase.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @since 2022/1/14 0014-上午 10:08
 */

//prod 环境 注入此类
@Profile("prod")
@Data
@Component
@ConfigurationProperties(value = "women")
public class Wife implements Women{
    private String name;
    private Integer age;
}