package com.monochrome.wechatpublisher.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author monochrome
 * @date 2022/8/7
 */

@ConfigurationProperties(prefix = "com.monochrome.qweather")
@Component
public class QWeatherProperties {

    private String id;
    private String key;
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
