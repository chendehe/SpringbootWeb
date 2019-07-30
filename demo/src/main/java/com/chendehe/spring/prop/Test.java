package com.chendehe.spring.prop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CDH
 * @since 2019/7/30 17:27
 */
public class Test {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserProperties.class);
    UserProperties bean = context.getBean(UserProperties.class);

    System.out.println(bean);
  }
}
