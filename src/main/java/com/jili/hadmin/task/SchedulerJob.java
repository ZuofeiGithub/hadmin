package com.jili.hadmin.task;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 左飞
 * @Date: 2019/3/11 13:58
 * @Version 1.0
 */
public class SchedulerJob {
    private static Scheduler scheduler = null;

    public static void run(){
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail jobDetail = JobBuilder.newJob(TaskJob.class).withIdentity("job1","group1").build();
            ScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(5000).repeatForever();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail,trigger);
            TimeUnit.SECONDS.sleep(20);
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
