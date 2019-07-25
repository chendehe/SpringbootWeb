package com.chendehe.config;

import com.chendehe.schedule.QuartzSchedule;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;

//@Configuration
public class JobConfig {

  @Bean
  public JobDetail myJobDetail() {
    return JobBuilder.newJob(QuartzSchedule.class).withIdentity("MyJob")
        .storeDurably().build();
  }

  @Bean
  public Trigger myJobTrigger() {
    SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
        .withIntervalInSeconds(2).repeatForever();
    return TriggerBuilder.newTrigger().forJob(myJobDetail()).withIdentity("MyTrigger")
        .withSchedule(simpleScheduleBuilder).build();
  }

}