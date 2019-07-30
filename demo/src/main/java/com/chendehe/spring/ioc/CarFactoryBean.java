package com.chendehe.spring.ioc;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author CDH
 * @since 2019/7/30 16:31
 */
public class CarFactoryBean implements FactoryBean<Car> {

  // 注入的对象
  @Override
  public Car getObject() throws Exception {
    System.out.println("getObject");
    return new Car();
  }

  // 类型
  @Override
  public Class<?> getObjectType() {
    System.out.println("getObjectType");
    return Car.class;
  }

  // 是否单例，true表示是单例
  @Override
  public boolean isSingleton() {
    System.out.println("isSingleton");
    return true;
  }
}
