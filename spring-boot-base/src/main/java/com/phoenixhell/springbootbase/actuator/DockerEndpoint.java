package com.phoenixhell.springbootbase.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * 自定义endpoint
 */

//  /actuator/container  id==>endpoint 名字
@Endpoint(id = "container")
@Component
public class DockerEndpoint {

    // /actuator/container 的显示内容
    //get 相当于获取 class 的属性 不能有传参
    @ReadOperation
    public Map getDockerInfo(){
        return Collections.singletonMap("info","docker started...");
    }

    //jConsole 里面可以操作   或者在idea(POST)  或者postman post /actuator/container
    @WriteOperation
    private void restartDocker(){
        //模拟命令行 docker 重启
        System.out.println("docker restarted....");
    }
}
