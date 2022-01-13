package com.phoenixhell.springbootbase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;

/**
 * @author phoenixhell
 * @since 2022/1/13 0013-下午 2:17
 */
@DisplayName("参数化测试")
public class TestParameter {

    @DisplayName("参数化测试1")
    @ValueSource(strings = {"one", "two", "three"})
    @ParameterizedTest
    public void parameterizedTest1(String string) {
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
    }


    @DisplayName("方法来源参数")
    @MethodSource("method")    //指定方法名
    @ParameterizedTest
    public void testWithExplicitLocalMethodSource(String name) {
        System.out.println(name);
        Assertions.assertNotNull(name);
    }

    // @MethodSource("method") 参数的值来自方法的话必须返回一个静态的流
    static Stream<String> method() {
        return Stream.of("apple", "banana");
    }

}
