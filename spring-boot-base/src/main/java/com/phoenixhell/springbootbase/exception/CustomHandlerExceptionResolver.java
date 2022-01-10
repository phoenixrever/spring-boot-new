package com.phoenixhell.springbootbase.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  自定义异常解析器
 *  注解@Order(value = Ordered.HIGHEST_PRECEDENCE) 最高优先级
 *  排在第一位首先经过我们的异常解析器  数字越小 优先级越高 等于 value=1
 *
 *  因为排在第一位 会导致排在其后的其他异常都不可用
 */

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            //response.sendError 。error请求就会转给controller
            //你的异常没有任何人能处理。tomcat底层 response.sendError。error请求就会转给controller
            //basicErrorController 要去的页面地址是 ErrorViewResolver  ；
            response.sendError(511,"自定义异常解析器错误");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回ModelAndView 促发break 跳出解析器循环 handlerExceptionResolvers
        //不然其他人解析
        return new ModelAndView();
    }
}
