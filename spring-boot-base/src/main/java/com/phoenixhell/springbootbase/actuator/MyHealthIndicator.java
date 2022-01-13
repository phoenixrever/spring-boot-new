package com.phoenixhell.springbootbase.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 自定义health endpoint  参照DiskSpaceHealthIndicator 配置
 */
@Component
public class MyHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //测试nysql 链接等等看看是否健康
        HashMap<String, String> map = new HashMap<>();
        if (1 == 1) {
            builder.up();
            map.put("status", "ok");
        } else {
            //builder.down();
            builder.status(Status.OUT_OF_SERVICE);
        }
        builder.withDetail("detail1", "detail1")
                .withDetail("detail2", "detail2")
                .withDetail("detail3", "detail3")
                .withDetails(map);
    }
}
