package com.chendehe.spring.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * @author CDH
 * @since 2019/7/30 17:02
 */
@Component
public class Dog {
  public Dog() {
    System.out.println("new Dog()");
  }

  @PostConstruct
  void postConstruct() {
    System.out.println("init --- postConstruct");
  }

  @PreDestroy
  void destroy() {
    System.out.println("destroy --- destroy");
  }
}
