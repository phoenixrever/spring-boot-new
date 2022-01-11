package com.phoenixhell.springbootbase.config;

import com.phoenixhell.springbootbase.bean.Person;
import com.phoenixhell.springbootbase.bean.Pet;
import com.phoenixhell.springbootbase.converter.CustomMessageConverter;
import com.phoenixhell.springbootbase.interceptor.LoginInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.util.UrlPathHelper;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 * Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * <p>
 * springboot2 中 proxyBeanMethods 默认为true
 * 代理bean的方法 MyConfig$$EnhancerBySpringCGLIB  spring增加了的代理对象
 * MyConfig myConfig = applicationContext.getBean(MyConfig.class);
 * Person person1 = myConfig.person();
 * Person person2 = myConfig.person();
 * System.out.println(myConfig);
 * System.out.println(person1==person2);
 * <p>
 * proxyBeanMethods = true  Full 模式 的情况下 通过此配置类中的方法 spring 代理对象
 * 调用时候总会检查容器中是否已经存在 获取的实例都是同一个
 * <p>
 * proxyBeanMethods = false Lite模式  的情况下 获取的实例都不一样
 * <p>
 * lite 模式每次创造对象不会检查容器中是否已经存在 速度会加快
 * <p>
 * 如果组件之间是相互依赖的(一个对象的属性中有另外一个对象) proxyBeanMethods设置成true
 */
@Configuration(proxyBeanMethods = false)
public class MyWebConfig implements WebMvcConfigurer {

    //自定义组件名
    @Bean(value = "customName")
    public Person person() {
        return new Person("loser", 18, null);
    }

    //配置druid 数据源
    /* @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource(){
        DruidDaraSource.setFilter("stat") 开启sql监控
        return new DruidDaraSource();
    }*/

    //spring WebMvcConfigurer 有多个实现 我们写的这个实现会先到这里找实现方法
    //没有就会找其他实现类 WebMvcAutoConfigurationAdapter implements WebMvcConfigurer
    //总之就是根据文档implements WebMvcConfigurer 覆写我们想要改变的方法就行
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    //自定义绑定转换convertor
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Pet>() {
            @Override
            public Pet convert(String s) {
                if (StringUtils.isEmpty(s)) {
                    return null;
                }
                String[] split = s.split(",");
                return new Pet(split[0], Integer.parseInt(split[1]));
            }
        });
        WebMvcConfigurer.super.addFormatters(registry);
    }

    /**
     * configureMessageConverters 会覆盖默认的converter
     * 返回自定义format application/x-custom   x 代表扩展
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new CustomMessageConverter());
    }

    //自定义静态资源行为
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static");
    }*/

    /**
     * 自定义参数形式 ?format = "x-custom"   直接发送基于请求头header的 application/x-custom 不需要设置这个
     * 而且如果我们 自定义的strategy 没有设置  HeaderContentNegotiationStrategy 不能返回 处理基于请求头的请求
     * 会默认返回任意格式的数据 (application/json)
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        MediaType xml = MediaType.APPLICATION_XML;
        MediaType json = MediaType.APPLICATION_JSON;
        MediaType custom = MediaType.parseMediaType("application/x-custom");
        HashMap<String, MediaType> mediaMap = new HashMap<>();
        mediaMap.put("xml", xml);
        mediaMap.put("json", json);
        mediaMap.put("custom", custom);
        ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaMap);
        //补: 设置基于请求头的策略
        HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();
        configurer.strategies(Arrays.asList(parameterStrategy, headerStrategy));
    }

    //注册拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/", "/login.html", "/login", "/static/**", "/error");

    }
}
