package com.phoenixhell.annotation;

import com.phoenixhell.annotation.aop.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringAnnotationApplicationTests {
    @Autowired
    private Calculator calculator;

    @Test
    void contextLoads() {

        calculator.div(1,1);
    }
}
