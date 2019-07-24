package com.chendehe.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class SpringSchedule {

  /**
   * <p>fixedDelay：时间间隔是上一次任务的结束和下一次任务的开始.</p>
   * <p>fixedRate：时间间隔是两次任务的开始点.</p>
   * <p>异步的注解@Async，可以指定入参，可以返回Future，也可以指定Executor，</p>
   * <p>不能和类似@PostConstruct对生命周期回调的方法一起使用，需要分两个类来写。</p>
   */
  @Scheduled(fixedDelay = 2000)
  public void doSomethingSync() {
    System.out.println("doSomething...");
  }

//  @Async
//  public void doSomethingAsync() {
//    System.out.println("doSomething...");
//  }
//  @Async
//  public void doSomethingAsync1() {
//    System.out.println("doSomething1...");
//  }
//  @Async
//  public void doSomethingAsync2() {
//    System.out.println("doSomething2...");
//  }
//  @Async
//  public void doSomethingAsync3() {
//    System.out.println("doSomething3...");
//  }


}
