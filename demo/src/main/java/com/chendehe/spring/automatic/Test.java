package com.chendehe.spring.automatic;

import com.chendehe.spring.ioc.Person;
import com.chendehe.spring.ioc.PersonConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CDH
 * @since 2019/7/30 17:45
 */
public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAuto.class);

//    MyAware auto = context.getBean(MyAware.class);
//    System.out.println(111111111);
  }
}
