package com.liwenguang.dingtalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DingTalkApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DingTalkApp.class, args);

    }
}