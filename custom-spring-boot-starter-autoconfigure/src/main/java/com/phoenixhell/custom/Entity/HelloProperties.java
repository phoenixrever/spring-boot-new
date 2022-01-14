package com.phoenixhell.custom.Entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author phoenixhell
 * @since 2022/1/14 0014-下午 2:06
 */

@ConfigurationProperties(prefix = "custom.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
