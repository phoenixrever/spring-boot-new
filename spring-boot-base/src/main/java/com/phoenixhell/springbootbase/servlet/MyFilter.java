package com.phoenixhell.springbootbase.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author phoenixhell
 * @since 2022/1/11 0011-上午 9:17
 */

@Slf4j
@WebFilter(urlPatterns = {"/myservlet"})
public class MyFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
      log.info("原生filter放行");
      chain.doFilter(request,response);
    }
}
