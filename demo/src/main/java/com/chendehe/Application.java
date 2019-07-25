package com.chendehe;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
//需要Redis时放开
//@ImportAutoConfiguration(RedisAutoConfiguration.class)
public class Application {
  public static void main(String[] args) {
    new SpringApplicationBuilder(Application.class)
        .bannerMode(Mode.CONSOLE)
//        .web(WebApplicationType.REACTIVE) // 启用响应式编程
        .run(args);
  }
}
