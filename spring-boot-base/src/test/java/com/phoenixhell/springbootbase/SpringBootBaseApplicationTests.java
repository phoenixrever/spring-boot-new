package com.phoenixhell.springbootbase;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.TimeUnit;


/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 * public @interface SpringBootTest {
 */

@DisplayName("junit5 功能测试类")
//@SpringBootTest    //不需要spring 提供给的自动注入功能的话可以不写这个注解
class SpringBootBaseApplicationTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("**************beforeAll 所有test运行之前运行**********************\n");
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("==============BeforeEach 在每个单元测试之前执行=============");
    }


    @DisplayName("测试DisplayName注解")
    @Test
    void testDisplayName() {
        System.out.println("测试DisplayName注解");
    }

    @Disabled
    @DisplayName("测试Timeout注解")
    @Timeout(value = 3,unit = TimeUnit.SECONDS)
    @Test
    void testTimeout() {
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("测试testTimeout注解 超出时间会抛出异常");
    }

    @DisplayName("测试RepeatedTest注解")
    @RepeatedTest(2)
    void testRepeat() {
        System.out.println("测试RepeatedTest注解 自动运行2次");
    }


    @DisplayName("测试BeforeAll与BeforeAfter注解")
    @Test
    void testBeforeAll() {
        System.out.println("测试BeforeAll注解 testBeforeAll 中..");
    }

    @DisplayName("测试BeforeAll与BeforeAfter注解")
    @Test
    void testBeforeAfter() {
        System.out.println("测试BeforeAfter注解 testAfter 中..");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("==============AfterEach 在每个单元测试之后执行=============\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("**************afterAll 所有test运行之后运行**********************\n\n");
    }
}
