package com.chendehe.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author CDH
 * @since 2019/7/30 17:12
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("调用实例化前的后置处理器###### postProcessBeforeInitialization："+beanName);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("调用实例化后的后置处理器###### postProcessAfterInitialization："+beanName);
    return bean;
  }
}
