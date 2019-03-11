package com.jili.hadmin.config;

import com.jili.hadmin.task.SchedulerTask;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/**
 * @Author: 左飞
 * @Date: 2019/3/11 14:18
 * @Version 1.0
 */
@Configuration
public class ScheduledConfig {
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(SchedulerTask schedulerTask){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetObject(schedulerTask);
        return bean;
    }
}
