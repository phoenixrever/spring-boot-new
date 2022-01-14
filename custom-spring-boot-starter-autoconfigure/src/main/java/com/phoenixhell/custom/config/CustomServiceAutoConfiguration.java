package com.phoenixhell.custom.config;

import com.phoenixhell.custom.Entity.HelloProperties;
import com.phoenixhell.custom.service.CustomService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(value = HelloProperties.class)
public class CustomServiceAutoConfiguration {

    @ConditionalOnMissingBean(CustomService.class)
    @Bean
    public CustomService customService(){
        return new CustomService();
    }
}
