package com.monochrome.wechatpublisher.publish;

import com.monochrome.wechatpublisher.publish.impl.GoodMorningPublisher;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author monochrome
 * @date 2022/8/7
 */
@Component
public class PublisherJob {

    private final GoodMorningPublisher goodMorningPublisher;
    private final WxMpService wxMpService;

    public PublisherJob(GoodMorningPublisher goodMorningPublisher, WxMpService wxMpService) {
        this.goodMorningPublisher = goodMorningPublisher;
        this.wxMpService = wxMpService;
    }

    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorning(){
        try {
            WxMpUserList wxMpUserList = wxMpService.getUserService().userList(null);
            List<String> openids = wxMpUserList.getOpenids();
            for (String openid : openids) {
                goodMorningPublisher.publish(openid);
            }
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }

}
