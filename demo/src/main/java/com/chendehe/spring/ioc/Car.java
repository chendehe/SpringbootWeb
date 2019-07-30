package com.chendehe.spring.ioc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CDH
 * @since 2019/7/30 16:35
 */
@Data
public class Car {
  private String type;

  public Car() {
    System.out.println("new Car()");
  }

  void init() {
    System.out.println("----------init--------");
  }

  void destroy() {
    System.out.println("----------destroy--------");
  }
}
