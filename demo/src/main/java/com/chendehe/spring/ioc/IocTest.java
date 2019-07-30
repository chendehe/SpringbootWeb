package com.chendehe.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试注入
 * 注入方式：
 * 1. 包扫描+组件注解
 * 2. @Configuration+@Bean
 * 3. @Import、ImportSelector、ImportBeanDefinitionRegistrar
 * 4. 使用FactoryBean
 * @author CDH
 * @since 2019/7/30 15:05
 */
public class IocTest {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
    String[] definitionNames = context.getBeanDefinitionNames();
    for (String name : definitionNames) {
      // 扫描路径下包含的Bean
      System.out.println(name);
    }

    System.out.println(context.getBean("getPerson"));
//  非工厂Bean不能用&获取  System.out.println(context.getBean("&getPerson"));
    // 利用工程实现的注入，加前缀 & 可以获取到BeanFactory本身。
    System.out.println(context.getBean("carBean"));
    System.out.println(context.getBean("&carBean"));

  }
}

