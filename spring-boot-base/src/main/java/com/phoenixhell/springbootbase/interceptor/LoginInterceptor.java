package com.phoenixhell.springbootbase.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("loginUser")!=null){
            return true;
        }

        session.setAttribute("error","请先登录");
        //request.sendRedirect 转向的页面中是不能通过request.getAttribute("username")来传值
        //这是因为上个页面请求已经结束，也就是 request这个对象已经消亡了。所以也就得不到值了。
        //可以使用request.getDispatcherHeader().forward(request,response)
        //这里不需要，因为通过session传值
        //request.getRequestDispatcher().forward("/login.html");
        response.sendRedirect("/login.html");
        return  false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
