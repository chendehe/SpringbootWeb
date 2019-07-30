package com.chendehe.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
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
    System.out.println("init .. afterPropertiesSet");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("destroy .. destroy");
  }

}
