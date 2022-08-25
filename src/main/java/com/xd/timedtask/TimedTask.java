package com.xd.timedtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 这是一个定时任务的类
 * @author: xudong
 * @email: 15673687783@163.com
 * @date: 2022/8/22 11:48
 */
@Component
public class TimedTask {
    /**
     * 这是一个示例
     * cron 表达式在线生成地址：https://cron.qqe2.com/
     */
    @Scheduled(cron ="0/1 * * * * ?")
    public void task(){
        System.out.println(Thread.currentThread().getName()+"```````");
    }
}
