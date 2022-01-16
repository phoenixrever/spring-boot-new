package com.phoenixhell.annotation.aop;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 被切面类
 */

@Component
public class Calculator {
    public Integer div(int x,int y){
        return x/y;
    }
}
