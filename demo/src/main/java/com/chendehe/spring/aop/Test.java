package com.chendehe.spring.aop;

import com.chendehe.spring.automatic.MyAuto;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP 动态代理
 *
 * @author CDH
 * @since 2019/7/30 19:32
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.chendehe.spring.aop")
public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
//    for (String name : context.getBeanDefinitionNames()) {
//      System.out.println(name);
//    }

    MyService service = context.getBean(MyService.class);
    String print = service.print();
    System.out.println(print);
  }
}
