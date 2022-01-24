package com.phoenixhell.springboottomcat.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 */

@WebFilter(urlPatterns = "/myservlet")
public class TomcatFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TomcatFilter------------"+request.getProtocol());
        chain.doFilter(request,response);
    }
}
