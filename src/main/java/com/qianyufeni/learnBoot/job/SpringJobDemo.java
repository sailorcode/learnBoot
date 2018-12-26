package com.qianyufeni.learnBoot.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * springboot定时任务示例
 */
@Component
public class SpringJobDemo {
    private Logger logger = LoggerFactory.getLogger(SpringJobDemo.class);

    @Scheduled(cron = "*/40 * * * * ?")
    public void execute(){

    }
}
