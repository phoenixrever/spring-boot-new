package com.phoenixhell.custom.service;

import com.phoenixhell.custom.Entity.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 一定注意默认不要放在容器中
 */

public class CustomService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String name) {
        return helloProperties.getPrefix() + ": " + name + " " + helloProperties.getSuffix();
    }
}
