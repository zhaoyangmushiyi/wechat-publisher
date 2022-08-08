package com.monochrome.wechatpublisher.publish.impl;

import com.monochrome.wechatpublisher.publish.Publisher;
import com.monochrome.wechatpublisher.publish.WxTemplateProperties;
import com.monochrome.wechatpublisher.util.qweather.QWeatherHelper;
import com.monochrome.wechatpublisher.util.Whispers;
import com.monochrome.wechatpublisher.util.qweather.Daily;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Component;

/**
 * @author monochrome
 * @date 2022/8/7
 */
@Component
public class GoodMorningPublisher implements Publisher {

    private final WxMpService wxMpService;

    private final Whispers whispers;
    private final QWeatherHelper qWeatherHelper;
    private final WxTemplateProperties wxTemplateProperties;

    public GoodMorningPublisher(WxMpService wxMpService, Whispers whispers, WxTemplateProperties wxTemplateProperties, QWeatherHelper qWeatherHelper) {
        this.wxMpService = wxMpService;
        this.whispers = whispers;
        this.wxTemplateProperties = wxTemplateProperties;
        this.qWeatherHelper = qWeatherHelper;
    }

    @Override
    public void publish(String openId) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(wxTemplateProperties.getGoodMorning())
                .build();
        //填写变量信息，比如天气之类的
        Daily weather = qWeatherHelper.getWeather();
        templateMessage.addData(new WxMpTemplateData("date", weather.getFxDate(), "#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("textDay", weather.getTextDay(), "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("tempMin", weather.getTempMin(), "#173177"));
        templateMessage.addData(new WxMpTemplateData("tempMax", weather.getTempMax(), "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("whisper", whispers.getRandomWhisper(), "#C71585"));
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }
}
