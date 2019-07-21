package com.chendehe.util;

import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtils implements ApplicationContextAware {

  /**
   * 上下文对象实例.
   */
  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContextUtils.applicationContext = applicationContext;
  }

  /**
   * 获取applicationContext.
   */
  private static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  /**
   * 通过name获取 Bean.
   */
  public static Object getBean(String name) {
    return getApplicationContext().getBean(name);
  }

  /**
   * 通过class获取Bean.
   */
  public static <T> T getBean(Class<T> clazz) {
    return getApplicationContext().getBean(clazz);
  }

  /**
   * 通过name,以及Clazz返回指定的Bean.
   */
  public static <T> T getBean(String name, Class<T> clazz) {
    return getApplicationContext().getBean(name, clazz);
  }

  /**
   * 通过name,以及Clazz返回指定的Bean.
   */
  public static <T> Map<String, T> getBeanByType(Class<T> clazz) {
    return applicationContext.getBeansOfType(clazz);
  }
}