package com.jili.hadmin.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Author: 左飞
 * @Date: 2019/3/11 13:56
 * @Version 1.0
 */
public class TaskJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("TaskJob::"+new Date());
    }
}
