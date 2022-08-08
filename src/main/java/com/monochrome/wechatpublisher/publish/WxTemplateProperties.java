package com.monochrome.wechatpublisher.publish;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author monochrome
 * @date 2022/8/7
 */

@ConfigurationProperties(prefix = "com.monochrome.wx.template")
@Component
public class WxTemplateProperties {

    private String goodMorning;

    public String getGoodMorning() {
        return goodMorning;
    }

    public void setGoodMorning(String goodMorning) {
        this.goodMorning = goodMorning;
    }
}
