package com.phoenixhell.springboottomcat.servlet;


import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Tomcat 相关
 * 所有请求共用一个servlet 如果有属性的话===>线程不安全
 *
 * SingleThreadModel 标记接口 作用：
 *       Web 容器创建多个 servlet 实例；即为每个用户创建一个实例
 *      每个servlet一次只能处理一个请求===>线程安全 导致严重的性能问题
 */

@WebServlet(urlPatterns = "/myservlet")
public class TomcatServlet extends HttpServlet implements SingleThreadModel{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("my servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
