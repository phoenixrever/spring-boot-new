package com.phoenixhell.annotation.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Resource:
 *      可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
 *      没有能支持@Primary功能没有支持@Autowired（reqiured=false）;
 *  @Inject:
 *      需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
 */
@Data
@Repository
public class ResourceDao {
    private String label="ResourceDao1";
}
