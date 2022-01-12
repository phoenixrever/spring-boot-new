package com.phoenixhell.springbootbase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("断言 assertions")
public class AssetTest {

    /**
     * assertEquals  判断两个对象或两个原始类型是否相等
     * <p>
     * assertNotEquals 判断两个对象或两个原始类型是否不相等
     * <p>
     * assertSame  判断两个对象引用是否指向同一个对象
     * <p>
     * assertNotSame  判断两个对象引用是否指向不同的对象
     * <p>
     * assertTrue     判断给定的布尔值是否为 true
     * <p>
     * assertFalse     判断给定的布尔值是否为 false
     * <p>
     * assertNull      判断给定的对象引用是否为 null
     * <p>
     * assertNotNull    判断给定的对象引用是否不为 null
     */
    @DisplayName("simple assertions")
    @Test
    void testSimpleAssert() {
        int calculate = calculate(1, 2);
        assertEquals(calculate, 2, "自定义错误信息");
        //前面断言失败了 后面的不会运行
        assertTrue(1 == 2,"结果不为true");
    }

    //模拟业务逻辑
    int calculate(int x, int y) {
        return x + y;
    }

    //通过 assertArrayEquals 方法来判断两个对象或原始类型的数组是否相等
    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }

    //组合断言  所有断言全部成功才算成功
    //assertAll 方法接受多个 org.junit.jupiter.api.Executable 函数式接口的实例作为要验证的断言，
    //可以通过 lambda 表达式很容易的提供这些断言
    @Test
    @DisplayName("assert all")
    public void all() {
        //heading 组合的名字
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(true && false,"结果不为true")
        );
    }

    //异常断言
    //在JUnit4时期，想要测试方法的异常情况时，需要用@Rule注解的ExpectedException变量还是比较麻烦的。
    // 而JUnit5提供了一种新的断言方式Assertions.assertThrows() ,配合函数式编程就可以进行使用。
    @Test
    @DisplayName("异常断言")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));
    }

    //超时断言
    //Junit5还提供了Assertions.assertTimeout() 为测试方法设置了超时时间
    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    //快速失败
    //通过 fail 方法直接使得测试失败
    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }

}
