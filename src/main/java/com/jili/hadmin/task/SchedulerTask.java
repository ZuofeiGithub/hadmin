package com.jili.hadmin.task;

import org.springframework.stereotype.Component;

/**
 * @Author: 左飞
 * @Date: 2019/3/11 14:16
 * @Version 1.0
 */
@Component
public class SchedulerTask {

    public void execute(){
        System.out.println("执行任务");
    }
}
