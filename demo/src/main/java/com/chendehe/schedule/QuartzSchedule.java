package com.chendehe.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzSchedule extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
    System.out.println("hello,job");
  }

}