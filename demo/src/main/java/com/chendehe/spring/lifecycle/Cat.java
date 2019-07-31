package com.chendehe.spring.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author CDH
 * @since 2019/7/30 16:57
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

  public Cat() {
    System.out.println("new Cat()");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("调用初始化----- afterPropertiesSet");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("调用销毁----- destroy");
  }

  @PostConstruct
  void postConstruct() {
    System.out.println("调用注解的初始化===== postConstruct");
  }

  @PreDestroy
  void preDestroy() {
    System.out.println("调用注解的销毁===== destroy");
  }

  void initMethod() {
    System.out.println("调用init初始化***** initMethod");
  }

  void destroyMethod() {
    System.out.println("调用destroy销毁***** destroyMethod");
  }

}
