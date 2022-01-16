package com.phoenixhell.annotation.service;

import com.phoenixhell.annotation.dao.ResourceDao;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 *  		@Resource:
 *  			可以和@Autowired一样实现自动装配功能；默认是按照组件名称(resourceDao)进行装配的；
 *  			没有能支持@Primary功能没有支持@Autowired（reqiured=false）;
 *  		@Inject:
 *  			需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
 *  @Autowired:Spring定义的； @Resource、@Inject都是java规范
 */
@Data
@Service
public class ResourceService {
    @Resource(name = "resourceDao")
    private ResourceDao resourceDao;

}
