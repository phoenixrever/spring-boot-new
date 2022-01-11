package com.phoenixhell.springbootbase.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author phoenixhell
 * @since 2022/1/11 0011-上午 9:25
 */

@Slf4j
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      log.info("ServletContextEvent init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("ServletContextEvent Destroyed");
    }
}
