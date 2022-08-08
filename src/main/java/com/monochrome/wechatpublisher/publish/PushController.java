package com.monochrome.wechatpublisher.publish;

import com.monochrome.wechatpublisher.publish.impl.GoodMorningPublisher;
import com.monochrome.wechatpublisher.util.qweather.QWeatherHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushController {
    //要推送的用户openid
    private static String monochrome = "oZwYv5r_YkyPVSlFXjL_5zrtGyIU";

    private final GoodMorningPublisher publisher;

    private final QWeatherHelper qWeatherHelper;

    private final PublisherJob publisherJob;

    public PushController(GoodMorningPublisher goodMorningPublisher, QWeatherHelper qWeatherHelper, PublisherJob publisherJob) {
        this.publisher = goodMorningPublisher;
        this.qWeatherHelper = qWeatherHelper;
        this.publisherJob = publisherJob;
    }

    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/publishToMonochrome")
    public void publishToMonochrome() {
        publisher.publish(monochrome);
    }

    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/publishToAll")
    public void publishToAll() {
        publisherJob.goodMorning();
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/publish/{openId}")
    public void publishByOpenId(@PathVariable("openId") String openId) {
        publisher.publish(openId);
    }
    /**
     * 微信测试账号推送
     * */
    @GetMapping("/getWeather")
    public void getWeather() {
        qWeatherHelper.getWeather();
    }
}