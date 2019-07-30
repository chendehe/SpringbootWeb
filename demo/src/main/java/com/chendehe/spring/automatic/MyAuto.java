package com.chendehe.spring.automatic;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * @author CDH
 * @since 2019/7/30 17:47
 */
@Service
@ComponentScan("com.chendehe.spring.automatic")
public class MyAuto {
  // @Autowired可以加载属性、构造器、方法；
  // 如果有参构造器/加了@Bean的方法只有一个参数，@Autowired可以省略！
  // 按照：类型MyService、属性名、Qualifier，寻找，并进行注入
  // Qualifier优先级最高
  // required = false,没有Bean时，返回null
  /*@Autowired(required = false)*/
//  @Qualifier("bbb")
  //@Primary：没有@Qualifier时，优先加载加了@Primary的类。
  //AutowiredAnnotationBeanPostProcessor

  //Java 规范：
  //JSR250 @Resource(功能少)，默认按属性名注入
  // ,@Qualifier\@Primary无效
//  @Resource(name = "aaa")
  //JSR330 @Inject(需要导包)
  MyService bbb;

  public MyAuto(MyService bbb) {
    this.bbb = bbb;
  }

//  @Autowired
//  public MyService get(MyService bbb) {
//    System.out.println(bbb);
//    return bbb;
//  }

  public void get() {
    System.out.println(bbb);
  }
}
