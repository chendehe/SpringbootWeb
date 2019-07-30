package com.chendehe.spring.lifecycle;

import com.chendehe.spring.ioc.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author CDH
 * @since 2019/7/30 16:45
 */
@Configuration
@ComponentScan("com.chendehe.spring.lifecycle")
public class LifeCylceConfig {

  @Bean(initMethod = "init", destroyMethod = "destroy")
  Car car() {
    return new Car();
  }

}
