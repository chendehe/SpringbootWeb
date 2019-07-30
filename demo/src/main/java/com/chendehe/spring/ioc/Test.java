package com.chendehe.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试注入
 * 注入方式：
 * 1. 包扫描+组件注解
 * 2. @Configuration+@Bean
 * 3. @Import、ImportSelector、ImportBeanDefinitionRegistrar
 * 4. 使用FactoryBean
 *
 * @author CDH
 * @since 2019/7/30 14:50
 */
public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
    Object bean = context.getBean(Person.class);
    System.out.println(bean);
    // Bean名字默认是方法名getPerson，使用@Bean("person")可以修改Bean的名字
    Object getPerson = context.getBean("getPerson");
    System.out.println(getPerson);
  }
}
