package com.qianyufeni.learnBoot.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * springboot定时任务示例
 */
@Component
public class SpringJobDemo {
    /**
     * 每2秒执行一次,适用于简单定时任务
     */
    //@Scheduled(cron = "*/2 * * * * ?")
    public void execute(){
        System.out.println(System.currentTimeMillis());
    }
}
