package com.phoenixhell.springboottomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 重要
 * ServletComponentScan   扫描自定义webServlet
 * 必须要防在main里面
 */
@ServletComponentScan(basePackages = "com.phoenixhell.springboottomcat.servlet")
@SpringBootApplication
public class SpringBootTomcatApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootTomcatApplication.class, args);
    }

}
