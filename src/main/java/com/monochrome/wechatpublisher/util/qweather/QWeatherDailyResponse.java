//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.monochrome.wechatpublisher.util.qweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(
    ignoreUnknown = true
)
public class QWeatherDailyResponse extends QWeatherResponse {
    private List<Daily> daily;

    public QWeatherDailyResponse() {
    }

    public QWeatherDailyResponse(String statusEnum) {
        super(statusEnum);
    }

    public List<Daily> getDaily() {
        return this.daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }
}
