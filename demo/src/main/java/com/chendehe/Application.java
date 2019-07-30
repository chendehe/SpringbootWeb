package com.chendehe;

import com.chendehe.util.FreeMarkerUtils;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;


@SpringBootApplication
@ComponentScan(excludeFilters = {
    @Filter(type = FilterType.REGEX, pattern = {"com\\.chendehe\\.spring\\..*"}),
    @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = FreeMarkerUtils.class)
})
//配置druid必须加的注解，如果不加，访问页面打不开，
// filter和servlet、listener之类的需要单独进行注册才能使用，
// spring boot里面提供了该注解起到注册作用
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
