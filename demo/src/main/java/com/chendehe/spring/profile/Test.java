package com.chendehe.spring.profile;

import com.chendehe.spring.automatic.MyAuto;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Profile 动态激活和切换组件。例如用在 @Bean 和配置文件中加profile
 * 默认是"default"
 * -Dspring.profile.active=
 */
public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAuto.class);

  }
}