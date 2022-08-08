//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.monochrome.wechatpublisher.util.qweather;
import java.time.ZonedDateTime;

public class QWeatherResponse {
    private String code;
    private ZonedDateTime updateTime;
    private String fxLink;
    private Refer refer;

    public QWeatherResponse() {
    }

    public QWeatherResponse(String statusEnum) {
        this.code = statusEnum;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ZonedDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return this.fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public Refer getRefer() {
        return this.refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}
