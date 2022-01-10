package com.phoenixhell.springbootbase.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author phoenixhell
 * @since 2022/1/10 0010-下午 3:48
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    //处理数学运算异常
    //返回的是视图地址 json要加@ResponseBody
    @ResponseBody
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handleArithException(Exception exception){
        return "error--------------------------"+exception.getMessage();
    }
}
