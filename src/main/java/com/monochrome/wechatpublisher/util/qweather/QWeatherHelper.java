package com.monochrome.wechatpublisher.util.qweather;

import com.alibaba.fastjson.JSON;
import com.monochrome.wechatpublisher.util.HttpUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author monochrome
 * @date 2022/8/7
 */
@Component
public class QWeatherHelper {

    final QWeatherProperties qWeatherProperties;

    String weatherUrl = "https://devapi.qweather.com/v7/weather/3d";

    public QWeatherHelper(QWeatherProperties qWeatherProperties) {
        this.qWeatherProperties = qWeatherProperties;

        weatherUrl += "?location=" + qWeatherProperties.getLocation() + "&key=" + qWeatherProperties.getKey();
    }

    public Daily getWeather() {
        Daily daily = null;
        try {
            String response = HttpUtil.doGet(weatherUrl);
            QWeatherDailyResponse qWeatherDailyResponse = JSON.parseObject(response, QWeatherDailyResponse.class);
            if (qWeatherDailyResponse != null && "200".equals(qWeatherDailyResponse.getCode())) {
                daily = qWeatherDailyResponse.getDaily().get(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return daily;
    }
}
