package com.monochrome.wechatpublisher.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Whispers {
    private static final List<String> whispers = new ArrayList<>();

    /**
     * 载入金句库
     */
    static {
        InputStream inputStream = Whispers.class.getClassLoader().getResourceAsStream("whispers.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder str = new StringBuilder();
            String temp = "";
            while ((temp = br.readLine()) != null) {
                if (!StringUtils.isEmpty(temp)) {
                    str.append("\r\n").append(temp);
                } else {
                    whispers.add(str.toString());
                    str = new StringBuilder();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRandomWhisper() {
        Random random = new Random();
        return whispers.get(random.nextInt(whispers.size()));
    }
}
