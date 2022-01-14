package com.phoenixhell.springbootbase.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * profile 条件装配
 */


@Profile("dev")
@Data
@Component
@ConfigurationProperties(value = "women")
public class GirlFriend implements Women{
    private String name;
    private Integer age;
}
