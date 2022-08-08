package com.monochrome.wechatpublisher;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author monochrome
 * @date 2022/8/7
 */
@Component
public class PublisherJob {

    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorning(){
    }

}
