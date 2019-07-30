package com.chendehe.spring.aop;

import org.springframework.stereotype.Service;

/**
 * 业务
 * @author CDH
 * @since 2019/7/30 19:32
 */
@Service
public class MyService {

  /**
   * 打印如下
   * startAround..
   * Start
   * print123
   * endAround..
   * End
   * returnStart
   * ---
   */
  public String print() {
    System.out.println("print" + 123);
    return "---";
  }

}
